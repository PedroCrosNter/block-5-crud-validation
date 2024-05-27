package app.block5crudvalidation.teacher.application.mapper;

import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;

public abstract interface TeacherForeignEntityMapper {

    TeacherJpa toEntityJpa(Teacher teacher);
}
