package app.block5crudvalidation.person.application.use_case_impl;

import app.block5crudvalidation.person.application.CreatePersonUseCase;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.CreatePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

    private final CreatePersonRepository createPersonRepository;


    @Override
    public Long save(Person person) {
        return createPersonRepository.save(person);
    }
}
