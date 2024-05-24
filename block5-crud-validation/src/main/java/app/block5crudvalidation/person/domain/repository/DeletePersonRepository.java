package app.block5crudvalidation.person.domain.repository;

public interface DeletePersonRepository {

    void delete(Long idPerson);

    void delete(String idPerson);
}