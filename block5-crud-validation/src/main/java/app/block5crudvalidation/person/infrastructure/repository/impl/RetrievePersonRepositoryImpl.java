package app.block5crudvalidation.person.infrastructure.repository.impl;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.RetrievePersonRepository;
import app.block5crudvalidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudvalidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudvalidation.shared.exceptions.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrievePersonRepositoryImpl implements RetrievePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Person find(Long idPerson) {
        return Optional.ofNullable(idPerson)
                .map(id -> personRepositoryJpa.findById(id)
                        .map(PersonMapper.INSTANCE::toEntity)
                        .orElseThrow(() -> new PersonNotFoundException(id)))
                .orElseThrow(IdGivenIsNullException::new);
    }

    @Override
    public List<Person> findAll() {
        List<PersonJpa> personJpaList = personRepositoryJpa.findAll();
        return personJpaList.stream()
                .map(PersonMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }
}