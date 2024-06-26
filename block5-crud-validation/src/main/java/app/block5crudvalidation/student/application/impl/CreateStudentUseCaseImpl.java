package app.block5crudvalidation.student.application.impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.student.application.CreateStudentUseCase;
import app.block5crudvalidation.student.application.mapper.StudentEntityMapper;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.CreateStudentRepository;
import app.block5crudvalidation.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudvalidation.subject.application.RetrieveSubjectUseCase;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.teacher.application.RetrieveTeacherUseCase;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    // Repository -> CreateStudent
    private final CreateStudentRepository createStudentRepository;
    // Use Case
        // -> RetrievePerson
        private final RetrievePersonUseCase retrievePersonUseCase;
        // -> RetrieveTeacher
        private final RetrieveTeacherUseCase retrieveTeacherUseCase;
        // -> RetrieveSubject
        private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    @Override
    public Long save(StudentCreateInputDto studentCreateInputDto) {

        if (Objects.isNull(studentCreateInputDto.getBranch().toString()) || StringUtils.isBlank(studentCreateInputDto.getBranch().toString())) {
            studentCreateInputDto.setBranch(Branch.UNASSIGNED);
        }

        // Create entity
        Student student = StudentEntityMapper.INSTANCE.toEntity(studentCreateInputDto);

        // SET -> Person
        student.setPerson(
                // TODO lanzar excepción en caso de que 'studentCreateInputDto.getIdPerson()' no exista en bd
                retrievePersonUseCase.find(studentCreateInputDto.getIdPerson())
        );

        // SET -> Teacher
        student.setTeacher(
                // TODO lanzar excepción en caso de que 'studentCreateInputDto.getIdTeacher()' no exista en bd
                retrieveTeacherUseCase.find(studentCreateInputDto.getIdTeacher())
        );

        // SET -> Subjects
        List<Subject> subjects = studentCreateInputDto.getIdSubjects().stream()
                .map(retrieveSubjectUseCase::findById)
                .collect(Collectors.toList());

        student.setSubjects(subjects);

        // Repository -> SAVE(Student)
        return createStudentRepository.save(student);
    }
}
