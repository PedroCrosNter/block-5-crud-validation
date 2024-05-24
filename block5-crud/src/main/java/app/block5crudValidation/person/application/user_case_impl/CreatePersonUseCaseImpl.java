package app.block5crudValidation.person.application.user_case_impl;

import app.block5crudValidation.person.application.CreatePersonUseCase;
import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.domain.repository.CreatePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

    private final CreatePersonRepository createPersonRepository;


    @Override
    public Long save(Person person) {
        return createPersonRepository.save(person);
    }

    @Override
    public List<Long> saveAll(List<Person> people) {
        return createPersonRepository.saveAll(people);
    }
}
