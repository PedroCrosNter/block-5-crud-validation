package app.block5crudValidation.person.application;

import app.block5crudValidation.person.domain.entity.Person;

import java.util.List;

public interface CreatePersonUseCase {

    Long save(Person person);

    List<Long> saveAll(List<Person> people);
}
