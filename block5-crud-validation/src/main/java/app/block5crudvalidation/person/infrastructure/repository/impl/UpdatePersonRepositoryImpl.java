package app.block5crudvalidation.person.infrastructure.repository.impl;

import app.block5crudvalidation.person.application.mapper.PersonEntityMapper;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.domain.repository.UpdatePersonRepository;
import app.block5crudvalidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdatePersonRepositoryImpl implements UpdatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Person update(Person person) {
        
        return personRepositoryJpa
                .findById(person.getIdPerson())
                .map(existingPersonJpa -> {
                    // Map new data to EntityJpa
                    PersonEntityMapper.INSTANCE.toEntity(person, existingPersonJpa);
                    // Save new entity updated
                    return personRepositoryJpa.save(existingPersonJpa);
                })
                // Map to Entity
                .map(PersonEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(Person.class, person.getIdPerson())
                );
    }
}
