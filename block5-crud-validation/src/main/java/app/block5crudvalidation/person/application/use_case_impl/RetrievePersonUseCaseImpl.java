package app.block5crudvalidation.person.application.use_case_impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.RetrievePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrievePersonUseCaseImpl implements RetrievePersonUseCase {

    private final RetrievePersonRepository retrievePersonRepository;


    @Override
    public Person find(Long idPerson) {
        return retrievePersonRepository.find(idPerson);
    }

    @Override
    public List<Person> findAll() {
        return retrievePersonRepository.findAll();
    }
}