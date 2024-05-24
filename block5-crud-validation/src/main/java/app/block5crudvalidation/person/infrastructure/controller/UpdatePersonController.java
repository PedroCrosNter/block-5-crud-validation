package app.block5crudvalidation.person.infrastructure.controller;

import app.block5crudvalidation.person.application.UpdatePersonUseCase;
import app.block5crudvalidation.person.application.mapper.PersonEntityMapper;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.infrastructure.controller.dto.input.PersonUpdateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class UpdatePersonController {

    private final UpdatePersonUseCase updatePersonUseCase;

    // PUT: localhost:8080/person
    /**
     * BODY: {
     *      "id": 3,
     *      "name": "Pedro",
     *      "age": 19,
     *      "bornPlace": "Jaén"
     * }
     */
    @PutMapping
    public ResponseEntity<Long> update(@RequestBody PersonUpdateInputDto personUpdateInputDto) {
        // Mapper FROM InputDto TO PersonJpa
        Person person = PersonEntityMapper.INSTANCE.toEntity(personUpdateInputDto);

        // Applying use case
        Long personId = updatePersonUseCase.update(person);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(personId);
    }

}
