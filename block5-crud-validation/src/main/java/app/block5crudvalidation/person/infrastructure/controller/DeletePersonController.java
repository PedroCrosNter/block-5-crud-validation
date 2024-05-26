package app.block5crudvalidation.person.infrastructure.controller;

import app.block5crudvalidation.person.application.DeletePersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class DeletePersonController {

    private final DeletePersonUseCase deletePersonUseCase;


    // DELETE: localhost:8080/people/{idPerson}
    @DeleteMapping("/{idPerson}")
    public ResponseEntity<?> delete(@PathVariable Long idPerson) {
        // Delete by ID
        deletePersonUseCase.delete(idPerson);

        // Build a ResponseEntity
        return ResponseEntity.ok().build();
    }

}