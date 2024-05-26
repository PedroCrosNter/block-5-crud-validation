package app.block5crudvalidation.student.domain.repository;

import app.block5crudvalidation.student.domain.entity.Student;

import java.util.List;

public interface RetrieveStudentRepository {

    Student findById(Long idStudent);

    List<Student> findAll();
}
