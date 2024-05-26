package app.block5crudvalidation.teacher.domain.repository;

import app.block5crudvalidation.teacher.domain.entity.Teacher;

public interface CreateTeacherRepository {

    Long save(Teacher teacher);
}
