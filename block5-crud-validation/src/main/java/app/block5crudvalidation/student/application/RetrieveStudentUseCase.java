package app.block5crudvalidation.student.application;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.student.domain.entity.Student;

import java.util.List;

public interface RetrieveStudentUseCase {

    Student find(Long idStudent) throws EntityNotFoundException;

    List<Student> findAll();
}
