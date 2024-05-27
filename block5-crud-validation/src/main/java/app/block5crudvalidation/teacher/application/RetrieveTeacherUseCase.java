package app.block5crudvalidation.teacher.application;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.teacher.domain.entity.Teacher;

import java.util.List;

public interface RetrieveTeacherUseCase {

    Teacher find(Long idTeacher) throws EntityNotFoundException;

    List<Teacher> findAll() throws EntityNotFoundException;
}
