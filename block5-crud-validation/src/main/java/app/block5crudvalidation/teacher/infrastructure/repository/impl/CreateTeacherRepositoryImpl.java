package app.block5crudvalidation.teacher.infrastructure.repository.impl;

import app.block5crudvalidation.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.domain.repository.CreateTeacherRepository;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateTeacherRepositoryImpl implements CreateTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public Long save(Teacher teacher) {
        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);
        return teacherRepositoryJpa.save(teacherJpa).getIdTeacher();
    }
}
