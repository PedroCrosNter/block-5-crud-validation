package app.block5crudvalidation.student.application;

import app.block5crudvalidation.student.domain.entity.Student;

public interface UpdateStudentUseCase {

    Long update(Student student);
}
