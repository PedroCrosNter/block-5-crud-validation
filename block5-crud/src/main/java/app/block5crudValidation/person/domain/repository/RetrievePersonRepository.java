package app.block5crudValidation.person.domain.repository;

import app.block5crudValidation.person.domain.entity.Person;

import java.util.List;

public interface RetrievePersonRepository {

    Person find(Long personId);

    List<Person> findAll();
}
