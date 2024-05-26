package app.block5crudvalidation.person.application;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;

import java.util.List;

public interface RetrievePersonUseCase {

    Person find(Long personId) throws EntityNotFoundException;

    List<Person> findAll();
}
