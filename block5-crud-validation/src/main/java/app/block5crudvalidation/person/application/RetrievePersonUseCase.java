package app.block5crudvalidation.person.application;

import app.block5crudvalidation.person.domain.entity.Person;

import java.util.List;

public interface RetrievePersonUseCase {

    Person find(Long personId);

    List<Person> findAll();
}
