package app.block5crudvalidation.teacher.infrastructure.repository.impl;

import app.block5crudvalidation.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.domain.repository.CreateTeacherRepository;
import app.block5crudvalidation.teacher.domain.repository.DeleteTeacherRepository;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteTeacherRepositoryImpl implements DeleteTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public Long delete(Long idTeacher) {
        teacherRepositoryJpa.deleteById(idTeacher);
        return 0;
    }
}
