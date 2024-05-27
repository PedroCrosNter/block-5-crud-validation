package app.block5crudvalidation.teacher.application.impl;

import app.block5crudvalidation.person.application.RetrievePersonUseCase;
import app.block5crudvalidation.teacher.application.CreateTeacherUseCase;
import app.block5crudvalidation.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.domain.repository.CreateTeacherRepository;
import app.block5crudvalidation.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTeacherUseCaseImpl implements CreateTeacherUseCase {

    private final CreateTeacherRepository createTeacherRepository;
    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public Long save(TeacherCreateInputDto teacherCreateInputDto) {

        Teacher teacher = TeacherEntityMapper.INSTANCE.toEntity(teacherCreateInputDto);

        teacher.setPerson(
                retrievePersonUseCase.find(
                        teacherCreateInputDto.getIdPerson()
                )
        );

        return createTeacherRepository.save(teacher);
    }
}
