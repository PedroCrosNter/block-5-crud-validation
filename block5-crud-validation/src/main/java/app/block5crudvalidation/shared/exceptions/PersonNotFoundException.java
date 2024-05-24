package app.block5crudvalidation.shared.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {
        super("No se ha encontrado ninguna person con ID: " + id);
    }
}
