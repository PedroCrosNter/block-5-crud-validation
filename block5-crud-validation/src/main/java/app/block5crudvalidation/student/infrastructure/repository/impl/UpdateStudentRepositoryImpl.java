package app.block5crudvalidation.student.infrastructure.repository.impl;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.student.application.mapper.StudentEntityMapper;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.UpdateStudentRepository;
import app.block5crudvalidation.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateStudentRepositoryImpl implements UpdateStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Student update(Student student) {

        return studentRepositoryJpa
                .findById(student.getIdStudent())
                .map(existingStudentJpa -> {
                    // Map new data to EntityJpa
                    StudentEntityMapper.INSTANCE.toEntity(student, existingStudentJpa);
                    // Save new entity updated
                    return studentRepositoryJpa.save(existingStudentJpa);
                })
                // Map to Entity
                .map(StudentEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(Student.class, student.getIdStudent())
                );
    }
}
