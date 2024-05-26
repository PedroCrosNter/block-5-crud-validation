package app.block5crudvalidation.student.application.use_case_impl;

import app.block5crudvalidation.shared.exceptions.UnprocessableEntityException;
import app.block5crudvalidation.student.application.CreateStudentUseCase;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.CreateStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    private final CreateStudentRepository createStudentRepository;


    @Override
    public Long save(Student student) {

        try {
            return createStudentRepository.save(student);
        } catch (Exception e) {
            throw new UnprocessableEntityException(Student.class);
        }
    }
}
