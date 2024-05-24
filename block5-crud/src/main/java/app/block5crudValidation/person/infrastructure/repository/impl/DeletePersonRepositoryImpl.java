package app.block5crudValidation.person.infrastructure.repository.impl;

import app.block5crudValidation.person.domain.repository.DeletePersonRepository;
import app.block5crudValidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeletePersonRepositoryImpl implements DeletePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public void delete(Long idPerson) {
        // 1st form
        personRepositoryJpa.deleteById(idPerson); // Return VOID

        // 2nd form
//        PersonJpa personJpaToDelete = personRepositoryJpa.findById(idPerson)
//                .orElseThrow(() -> new PersonNotFoundException(idPerson));
//
//        personRepositoryJpa.delete(personJpaToDelete);
    }

    @Override
    public void delete(String idPerson) {
        this.delete(Long.valueOf(idPerson));
    }
}
