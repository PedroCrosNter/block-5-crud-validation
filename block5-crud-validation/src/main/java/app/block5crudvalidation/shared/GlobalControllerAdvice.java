package app.block5crudvalidation.shared;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.shared.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handleEntityNotFoundException(EntityNotFoundException ex) {

        return  ResponseEntity
                .status(
                        HttpStatus.NOT_FOUND
                )
                .body(
                        new CustomError(
                                HttpStatus.NOT_FOUND
                                ,ex.getMessage()
                        )
                );
    }


    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> handleUnprocessableEntityException(UnprocessableEntityException ex) {

        return  ResponseEntity
                .status(
                        HttpStatus.UNPROCESSABLE_ENTITY
                )
                .body(
                        new CustomError(
                                HttpStatus.UNPROCESSABLE_ENTITY
                                ,ex.getMessage()
                        )
                );
    }
}
