package app.block5crudvalidation.student.application.impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.student.application.CreateStudentUseCase;
import app.block5crudvalidation.student.application.mapper.StudentEntityMapper;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.CreateStudentRepository;
import app.block5crudvalidation.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudvalidation.teacher.application.RetrieveTeacherUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


    @Override
    public Long save(StudentCreateInputDto studentCreateInputDto) {

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

        // Repository -> SAVE(Student)
        return createStudentRepository.save(student);
    }
}
