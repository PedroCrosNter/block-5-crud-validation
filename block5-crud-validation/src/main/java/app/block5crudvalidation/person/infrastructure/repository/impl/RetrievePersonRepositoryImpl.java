package app.block5crudvalidation.person.infrastructure.repository.impl;

import app.block5crudvalidation.person.application.mapper.PersonEntityMapper;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.RetrievePersonRepository;
import app.block5crudvalidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RetrievePersonRepositoryImpl implements RetrievePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Person find(Long idPerson) {
//        return Optional.ofNullable(idPerson)
//                .map(id -> personRepositoryJpa.findById(id)
//                        .map(PersonEntityMapper.INSTANCE::toEntity)
//                        .orElseThrow(() -> new PersonNotFoundException(id)))
//                .orElseThrow(IdGivenIsNullException::new);
        return PersonEntityMapper.INSTANCE.toEntity(
                personRepositoryJpa.findById(idPerson)
                        .orElseThrow(() -> new EntityNotFoundException(Person.class, idPerson)));
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepositoryJpa.findAll(pageable)
                .map(PersonEntityMapper.INSTANCE::toEntity);
    }

}