package app.block5crudvalidation.person.infrastructure.controller;

import app.block5crudvalidation.person.application.CreatePersonUseCase;
import app.block5crudvalidation.person.application.mapper.PersonEntityMapper;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.infrastructure.controller.dto.input.PersonInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class CreatePersonController {

    private final CreatePersonUseCase createPersonUseCase;


    // POST: localhost:8080/person
    /**
     * BODY: {
     *      "name": "Pedro",
     *      "age": 19,
     *      "bornPlace": "Jaén"
     * }
     */
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody PersonInputDto personInputDto) {
        // Mapper FROM InputDto TO PersonJpa
        Person person = PersonEntityMapper.INSTANCE.toEntity(personInputDto);

        // Applying use case
        Long personId = createPersonUseCase.save(person);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(personId);
    }
}