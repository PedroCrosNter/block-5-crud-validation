package app.block5crudvalidation.teacher.application.impl;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.teacher.application.RetrieveTeacherUseCase;
import app.block5crudvalidation.teacher.application.UpdateTeacherUseCase;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.domain.repository.UpdateTeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTeacherUseCaseImpl implements UpdateTeacherUseCase {

    private final UpdateTeacherRepository updateTeacherRepository;
    private final RetrieveTeacherUseCase retrieveTeacherUseCase;


    @Override
    public Long update(Teacher teacher) {

        Teacher existingTeacher;

        try {
            existingTeacher = retrieveTeacherUseCase.find(teacher.getIdTeacher());
        } catch (Exception e) {
            throw new EntityNotFoundException(Teacher.class, teacher.getIdTeacher());
        }

        return updateTeacherRepository.update(teacher).getIdTeacher();
    }
}
