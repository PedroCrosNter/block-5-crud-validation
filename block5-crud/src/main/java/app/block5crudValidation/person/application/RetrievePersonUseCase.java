package app.block5crudValidation.person.application;

import app.block5crudValidation.person.domain.entity.Person;

import java.util.List;

public interface RetrievePersonUseCase {

    Person find(Long personId); // TODO devolver Optional<Person> o Person

    List<Person> findAll();
}
