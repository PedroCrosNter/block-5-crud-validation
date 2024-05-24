package app.block5crudvalidation.person.infrastructure.repository.impl;

import app.block5crudvalidation.person.domain.repository.DeletePersonRepository;
import app.block5crudvalidation.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeletePersonRepositoryImpl implements DeletePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public void delete(Long idPerson) {
        personRepositoryJpa.deleteById(idPerson);
    }

    @Override
    public void delete(String idPerson) {
        this.delete(Long.valueOf(idPerson));
    }
}
