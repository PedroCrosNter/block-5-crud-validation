package app.block5crudvalidation.person.infrastructure.controller;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.person.application.mapper.PersonDtoMapper;
import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.infrastructure.controller.dto.output.PersonOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class RetrievePersonController {

    private final RetrievePersonUseCase retrievePersonUseCase;


    // GET: localhost:8080/people/{id}
    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonOutputDto> find(@PathVariable Long idPerson) {

        Person person = retrievePersonUseCase.find(idPerson);

        return ResponseEntity
                .ok()
                .body(
                        PersonDtoMapper.INSTANCE.toOutputDto(person)
                );
    }

    // GET: localhost:8080/people
//    @GetMapping
//    public ResponseEntity<List<PersonOutputDto>> findAll() {
//
//        List<Person> people = retrievePersonUseCase.findAll();
//
//        List<PersonOutputDto> peopleOutputDto = PersonDtoMapper.INSTANCE.toOutputDtoList(people);
//
//        return  ResponseEntity
//                .ok()
//                .body(
//                        peopleOutputDto
//                );
//    }
//    Pageable => GET: localhost:8080/people?page=1&size=2 | ?limit=4
    @GetMapping
    public ResponseEntity<Page<PersonOutputDto>> findAll(@PageableDefault(page = 0, size = 5) Pageable pageable) {

        Page<Person> people = retrievePersonUseCase.findAll(pageable);

        Page<PersonOutputDto> peopleOutputDto = people.map(PersonDtoMapper.INSTANCE::toOutputDto);

        return  ResponseEntity
                .ok()
                .body(
                        peopleOutputDto
                );
    }
}
