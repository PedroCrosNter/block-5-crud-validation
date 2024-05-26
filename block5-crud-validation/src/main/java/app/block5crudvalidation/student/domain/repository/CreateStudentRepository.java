package app.block5crudvalidation.student.domain.repository;

import app.block5crudvalidation.student.domain.entity.Student;

public interface CreateStudentRepository {

    Long save(Student student);
}
