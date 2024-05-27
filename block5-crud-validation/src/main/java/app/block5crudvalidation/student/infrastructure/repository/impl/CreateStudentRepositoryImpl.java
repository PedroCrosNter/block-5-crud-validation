package app.block5crudvalidation.student.infrastructure.repository.impl;

import app.block5crudvalidation.student.application.mapper.StudentEntityMapper;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.CreateStudentRepository;
import app.block5crudvalidation.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudvalidation.student.infrastructure.repository.jpa.entity.StudentJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateStudentRepositoryImpl implements CreateStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Long save(Student student) {
        StudentJpa studentJpa = StudentEntityMapper.INSTANCE.toEntityJpa(student);
        return studentRepositoryJpa.save(studentJpa).getIdStudent();
    }
}
