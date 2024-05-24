package app.block5crudValidation.person.infrastructure.controller;

import app.block5crudValidation.person.application.RetrievePersonUseCase;
import app.block5crudValidation.person.application.mapper.PersonMapper;
import app.block5crudValidation.person.application.mapper.PersonMapperToOutputDto;
import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.infrastructure.controller.dto.output.PersonOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class RetrievePersonController {

    private final RetrievePersonUseCase retrievePersonUseCase;


    // GET: localhost:8080/people/{id}
    @GetMapping("/{idPerson}")
    public ResponseEntity<?> find(@PathVariable Long idPerson) {
        Person person = retrievePersonUseCase.find(idPerson);

        return ResponseEntity.ok().body(
                PersonMapper.INSTANCE.toOutputDto(person)
        );
    }

    // GET: localhost:8080/people
    @GetMapping
    public ResponseEntity<List<PersonOutputDto>> findAll() {

        List<Person> people = retrievePersonUseCase.findAll();

//        List<PersonOutputDto> peopleOutputDto = PersonMapper.INSTANCE.toOutputDtoList(people);
        List<PersonOutputDto> peopleOutputDto = PersonMapperToOutputDto.INSTANCE.toOutputDtoList(people);

        return ResponseEntity.ok().body(peopleOutputDto);
    }

}
