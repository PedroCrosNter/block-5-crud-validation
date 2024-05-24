package app.block5crudValidation.person.domain.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DeletePersonRepository {

    void delete(Long idPerson);

    void delete(String idPerson);
}
