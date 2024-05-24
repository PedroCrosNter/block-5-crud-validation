package app.block5crudValidation.person.application;

import app.block5crudValidation.person.domain.entity.Person;

public interface UpdatePersonUseCase {

    Long update(Person person);
}
