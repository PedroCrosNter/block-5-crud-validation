package app.block5crudvalidation.person.application;

public interface DeletePersonUseCase {

    void delete(Long idPerson);

    void delete(String idPerson);
}
