package app.block5crudvalidation.person.application;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;

public interface UpdatePersonUseCase {

    Long update(Person person) throws EntityNotFoundException;
}
