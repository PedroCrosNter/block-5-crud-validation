package app.block5crudvalidation.person.application;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrievePersonUseCase {

    Person find(Long personId) throws EntityNotFoundException;

    Page<Person> findAll(Pageable pageable);
}
