package app.block5crudvalidation.student.infrastructure.controller;

import app.block5crudvalidation.person.application.mapper.PersonDtoMapper;
import app.block5crudvalidation.student.application.RetrieveStudentUseCase;
import app.block5crudvalidation.student.application.mapper.StudentDtoMapper;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.infrastructure.controller.dto.output.StudentOutputDto;
import app.block5crudvalidation.subject.application.mapper.SubjectDtoMapper;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.block5crudvalidation.teacher.application.mapper.TeacherDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class RetrieveStudentController {

    private final RetrieveStudentUseCase retrieveStudentUseCase;


    // GET: localhost:8080/students/{idStudent}
    @GetMapping("/{idStudent}")
    public ResponseEntity<StudentOutputDto> findById(@PathVariable Long idStudent) {

        Student student = retrieveStudentUseCase.find(idStudent);

        StudentOutputDto studentOutputDto
//                = StudentDtoMapper.INSTANCE.toOutputDto(student)
                = null;

        studentOutputDto.setIdStudent(student.getIdStudent());
        studentOutputDto.setPerson(
                PersonDtoMapper.INSTANCE.toOutputDto(student.getPerson())
        );
        studentOutputDto.setNumHoursWeek(student.getNumHoursWeek());
        studentOutputDto.setTeacher(
                TeacherDtoMapper.INSTANCE.toOutputDto(student.getTeacher())
        );
        studentOutputDto.setBranch(student.getBranch());

        List< SubjectOutputDto> subjectOutputDtoList = List.of();
        List<Subject> subjects = student.getSubjects();
        for (Subject subject : subjects) {
            subjectOutputDtoList.add(
                    SubjectDtoMapper.INSTANCE.toOutputDto(subject)
            );
        }
        studentOutputDto.setSubjects(
                subjectOutputDtoList
        );

        return ResponseEntity
                .ok()
                .body(
//                        StudentDtoMapper.INSTANCE.toOutputDto(student)
                        studentOutputDto
                );
    }

    // GET: localhost:8080/students
    @GetMapping
    public ResponseEntity<List<StudentOutputDto>> findAll() {

        List<Student> students = retrieveStudentUseCase.findAll();

        List<StudentOutputDto> studentOutputDtoList = StudentDtoMapper.INSTANCE.toOutputDtoList(students);

        return  ResponseEntity
                .ok()
                .body(
                        studentOutputDtoList
                );
    }
}
