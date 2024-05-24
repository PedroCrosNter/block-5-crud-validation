package app.block5crudvalidation.person.application.use_case_impl;

import app.block5crudvalidation.person.application.UpdatePersonUseCase;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.RetrievePersonRepository;
import app.block5crudvalidation.person.domain.repository.UpdatePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    private final UpdatePersonRepository updatePersonRepository;
    private final RetrievePersonRepository retrievePersonRepository; // TODO cambiar por caso de uso


    @Override
    public Long update(Person person) {

        // Find person in repository
        Person existingPerson = retrievePersonRepository.find(person.getIdPerson());

        // Update person AND return updated person's ID
        return updatePersonRepository.update(person).getIdPerson();
    }
}
