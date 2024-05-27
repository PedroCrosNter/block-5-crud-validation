package app.block5crudvalidation.student.infrastructure.controller;

import app.block5crudvalidation.student.application.CreateStudentUseCase;
import app.block5crudvalidation.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class CreateStudentController {

    private final CreateStudentUseCase createStudentUseCase;


    // POST: localhost:8080/students
    /**
     * BODY: {
     *   "id_person": 3,
     *   "numHoursWeek": 20,
     *   "id_teacher": 2001,
     *   "branch": "FRONT"
     * }
     */
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody StudentCreateInputDto studentCreateInputDto) {

        // Applying use case
        Long idStudent = createStudentUseCase.save(studentCreateInputDto);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(idStudent);
    }
}
