package app.block5crudvalidation.subject.infrastructure.controller;

import app.block5crudvalidation.subject.application.RetrieveSubjectUseCase;
import app.block5crudvalidation.subject.application.mapper.SubjectDtoMapper;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class RetrieveSubjectController {

    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    // GET: localhost:8080/subjects/{id}
    @GetMapping("/{idSubject}")
    public ResponseEntity<SubjectOutputDto> find(@PathVariable Long idSubject) {

        Subject subject = retrieveSubjectUseCase.findById(idSubject);

        return ResponseEntity
                .ok()
                .body(
                        SubjectDtoMapper.INSTANCE.toOutputDto(subject)
                );
    }

    // GET: localhost:8080/subjects
    @GetMapping
    public ResponseEntity<List<SubjectOutputDto>> findAll() {

        List<Subject> subjects = retrieveSubjectUseCase.findAll();

        List<SubjectOutputDto> subjectsOutputDto = SubjectDtoMapper.INSTANCE.toOutputDtoList(subjects);

        return  ResponseEntity
                .ok()
                .body(
                        subjectsOutputDto
                );
    }
}
