package app.block5crudValidation.person.infrastructure.repository.impl;

import app.block5crudValidation.person.application.mapper.PersonMapper;
import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.domain.repository.UpdatePersonRepository;
import app.block5crudValidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudValidation.shared.exceptions.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdatePersonRepositoryImpl implements UpdatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Person update(Person person) {
        return personRepositoryJpa
                .findById(person.getId())
                .map(existingPersonJpa -> {
                    // Map new data to EntityJpa
                    PersonMapper.INSTANCE.toEntity(person, existingPersonJpa);
                    // Save new entity updated
                    return personRepositoryJpa.save(existingPersonJpa);
                })
                // Map to Entity
                .map(PersonMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new PersonNotFoundException(person.getId())
                );
    }
}