package app.block5crudvalidation.teacher.infrastructure.repository.impl;

import app.block5crudvalidation.teacher.application.mapper.TeacherForeignEntityMapper;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.domain.repository.CreateTeacherRepository;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateTeacherRepositoryImpl implements CreateTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;
    private final TeacherForeignEntityMapper teacherForeignEntityMapper;


    @Override
    public Long save(Teacher teacher) {
        // We can validate here
//        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);


        return teacherRepositoryJpa.save(
                teacherForeignEntityMapper.toEntityJpa(teacher)
        ).getIdTeacher();
    }
}
