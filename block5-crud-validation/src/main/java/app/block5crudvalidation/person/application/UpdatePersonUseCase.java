package app.block5crudvalidation.person.application;

import app.block5crudvalidation.person.domain.entity.Person;

public interface UpdatePersonUseCase {

    Long update(Person person);
}
