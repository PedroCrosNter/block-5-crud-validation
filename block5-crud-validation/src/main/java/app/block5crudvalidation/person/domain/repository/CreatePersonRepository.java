package app.block5crudvalidation.person.domain.repository;

import app.block5crudvalidation.person.domain.entity.Person;

public interface CreatePersonRepository {

    Long save(Person person);
}
