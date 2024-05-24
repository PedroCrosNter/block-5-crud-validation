package app.block5crudValidation.shared.exceptions;

public class IdGivenIsNullException extends RuntimeException {

    public IdGivenIsNullException() {
        super("Se ha introducido un ID nulo");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this; // Stop showing all trace
    }
}
