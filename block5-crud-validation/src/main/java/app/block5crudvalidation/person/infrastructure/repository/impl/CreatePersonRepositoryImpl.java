package app.block5crudvalidation.person.infrastructure.repository.impl;

import app.block5crudvalidation.person.application.mapper.PersonEntityMapper;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.CreatePersonRepository;
import app.block5crudvalidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudvalidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreatePersonRepositoryImpl implements CreatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Long save(Person person) {
        PersonJpa personJpa = PersonEntityMapper.INSTANCE.toEntityJpa(person);
        return personRepositoryJpa.save(personJpa).getIdPerson();
    }
}
