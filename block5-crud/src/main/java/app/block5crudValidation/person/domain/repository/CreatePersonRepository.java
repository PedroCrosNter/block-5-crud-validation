package app.block5crudValidation.person.domain.repository;

import app.block5crudValidation.person.domain.entity.Person;

import java.util.List;

public interface CreatePersonRepository {

    Long save(Person person);

    List<Long> saveAll(List<Person> people);
}
