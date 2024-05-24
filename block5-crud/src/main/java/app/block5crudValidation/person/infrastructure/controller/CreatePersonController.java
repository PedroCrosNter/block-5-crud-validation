package app.block5crudValidation.person.infrastructure.controller;

import app.block5crudValidation.person.application.CreatePersonUseCase;
import app.block5crudValidation.person.application.mapper.PersonEntityMapper;
import app.block5crudValidation.person.application.mapper.PersonMapper;
import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.infrastructure.controller.dto.input.PersonInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        Person person = PersonMapper.INSTANCE.toEntity(personInputDto);

        // Applying use case
        Long personId = createPersonUseCase.save(person);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(personId);
    }

    // POST: localhost:8080/person
    /**
     * BODY: {
     *      "name": "Pedro",
     *      "age": 19,
     *      "bornPlace": "Jaén"
     * }
     */
    @PostMapping("/saveAll")
    public ResponseEntity<List<Long>> saveAll(@RequestBody List<PersonInputDto> personInputDtoList) {
        // Mapper FROM InputDto TO PersonJpa
        List<Person> people = PersonEntityMapper.INSTANCE.toEntityListFromInputDto(personInputDtoList);

        // Applying use case
        List<Long> peopleId = createPersonUseCase.saveAll(people);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(peopleId);
    }
}
