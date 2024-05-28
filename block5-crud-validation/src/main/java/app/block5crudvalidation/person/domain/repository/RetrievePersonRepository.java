package app.block5crudvalidation.person.domain.repository;

import app.block5crudvalidation.person.domain.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrievePersonRepository {

    Person find(Long idPerson);

    Page<Person> findAll(Pageable pageable);
}
