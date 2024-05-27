package app.block5crudvalidation.person.application.impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.RetrievePersonRepository;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrievePersonUseCaseImpl implements RetrievePersonUseCase {

    private final RetrievePersonRepository retrievePersonRepository;


    @Override
    public Person find(Long idPerson) throws EntityNotFoundException {

        Person person;

        try {
            person = retrievePersonRepository.find(idPerson);
        } catch (Exception e) {
            throw new EntityNotFoundException(Person.class, idPerson);
        }

        return person;
    }

    @Override
    public List<Person> findAll() {
        return retrievePersonRepository.findAll();
    }
}