package app.block5crudvalidation.student.application;

import app.block5crudvalidation.student.infrastructure.controller.dto.input.StudentCreateInputDto;

public interface CreateStudentUseCase {

    Long save(StudentCreateInputDto studentCreateInputDto);
}
