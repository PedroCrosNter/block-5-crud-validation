package app.block5crudvalidation.person.application.impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.person.application.UpdatePersonUseCase;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.UpdatePersonRepository;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    // Update -> Repository
    private final UpdatePersonRepository updatePersonRepository;
    // Retrieve -> UseCase
    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public Long update(Person person) throws EntityNotFoundException {

        Person existingPerson;

        // Find person in repository
        try {
            existingPerson = retrievePersonUseCase.find(person.getIdPerson());
        } catch (Exception ex) {
            throw new EntityNotFoundException(Person.class, person.getIdPerson());
        }

        // Update person AND return updated person's ID
        return updatePersonRepository.update(person).getIdPerson();
    }
}
