package app.block5crudvalidation.person.domain.repository;

import app.block5crudvalidation.person.domain.entity.Person;

import java.util.List;

public interface RetrievePersonRepository {

    Person find(Long idPerson);

    List<Person> findAll();
}
