package app.block5crudvalidation.student.infrastructure.repository.impl;

import app.block5crudvalidation.student.domain.repository.DeleteStudentRepository;
import app.block5crudvalidation.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteStudentRepositoryImpl implements DeleteStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public void delete(Long idStudent) {
        studentRepositoryJpa.deleteById(idStudent);
    }
}
