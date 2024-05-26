package app.block5crudvalidation.teacher.domain.repository;

import app.block5crudvalidation.teacher.domain.entity.Teacher;

import java.util.List;

public interface RetrieveTeacherRepository {

    Teacher find(Long idTeacher);

    List<Teacher> findAll();
}
