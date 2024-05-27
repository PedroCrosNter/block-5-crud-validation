package app.block5crudvalidation.teacher.application.mapper.impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.person.application.mapper.PersonEntityMapper;
import app.block5crudvalidation.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudvalidation.teacher.application.mapper.TeacherForeignEntityMapper;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherForeignEntityMapperImpl implements TeacherForeignEntityMapper {

    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public TeacherJpa toEntityJpa(Teacher teacher) {

        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);

        teacherJpa.setPersonJpa(
                PersonEntityMapper.INSTANCE.toEntityJpa(
                        retrievePersonUseCase.find(
                                    teacher
                                        .getPerson()
                                        .getIdPerson()
                        )
                )
        );

        return teacherJpa;
    }
}
