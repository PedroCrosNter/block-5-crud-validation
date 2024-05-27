package app.block5crudvalidation.teacher.application;

import app.block5crudvalidation.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;

public interface CreateTeacherUseCase {

    Long save(TeacherCreateInputDto teacherCreateInputDto);
}
