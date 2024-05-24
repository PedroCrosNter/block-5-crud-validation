package app.block5crudValidation.person.application.user_case_impl;

import app.block5crudValidation.person.application.UpdatePersonUseCase;
import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.domain.repository.RetrievePersonRepository;
import app.block5crudValidation.person.domain.repository.UpdatePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    private final UpdatePersonRepository updatePersonRepository;
    private final RetrievePersonRepository retrievePersonRepository;


    @Override
    public Long update(Person person) {

        // Find person in repository
        Person existingPerson = retrievePersonRepository.find(person.getId());

        // Update person AND return updated person's ID
        return updatePersonRepository.update(person).getId();
    }
}
