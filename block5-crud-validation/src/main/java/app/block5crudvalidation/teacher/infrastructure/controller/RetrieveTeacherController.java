package app.block5crudvalidation.teacher.infrastructure.controller;

import app.block5crudvalidation.teacher.application.RetrieveTeacherUseCase;
import app.block5crudvalidation.teacher.application.mapper.TeacherDtoMapper;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class RetrieveTeacherController {

    private final RetrieveTeacherUseCase retrieveTeacherUseCase;

    // GET: localhost:8080/teachers/{idTeacher}
    @GetMapping("/{idTeacher}")
    public ResponseEntity save(@PathVariable Long idTeacher) {

        Teacher teacher = retrieveTeacherUseCase.find(idTeacher);

        return ResponseEntity
                .ok()
                .body(
                        TeacherDtoMapper.INSTANCE.toOutputDto(teacher)
                );
    }

    // GET: localhost:8080/people
    @GetMapping
    public ResponseEntity<List<TeacherOutputDto>> findAll() {

        List<Teacher> teacher = retrieveTeacherUseCase.findAll();

        List<TeacherOutputDto> teacherOutputDto = TeacherDtoMapper.INSTANCE.toOutputDtoList(teacher);

        return  ResponseEntity
                .ok()
                .body(
                        teacherOutputDto
                );
    }
}
