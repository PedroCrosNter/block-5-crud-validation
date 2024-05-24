package app.block5crudValidation.person.infrastructure.repository.impl;

import app.block5crudValidation.person.application.mapper.PersonMapper;
import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.domain.repository.CreatePersonRepository;
import app.block5crudValidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudValidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CreatePersonRepositoryImpl implements CreatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Long save(Person person) {
        PersonJpa personJpa = PersonMapper.INSTANCE.toEntityJpa(person);
        return personRepositoryJpa.save(personJpa).getId();
    }

    // TODO PREGUNTAR: código redundante
    @Override
    public List<Long> saveAll(List<Person> people) {

        // Map List of Entity from controller to List of EntityJpa => to save in RepositoryJpa
        List<PersonJpa> savedPeopleJpa = personRepositoryJpa
                .saveAll(
                        PersonMapper.INSTANCE.toEntityJpaList(
                                // List from Controller
                                people
                        )
                );

        return savedPeopleJpa.stream()
                .map(PersonJpa::getId)
                .collect(Collectors.toList());
    }
}
