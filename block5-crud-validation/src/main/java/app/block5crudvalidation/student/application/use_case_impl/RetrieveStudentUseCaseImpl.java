package app.block5crudvalidation.student.application.use_case_impl;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.student.application.RetrieveStudentUseCase;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.RetrieveStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveStudentUseCaseImpl implements RetrieveStudentUseCase {

    private final RetrieveStudentRepository retrieveStudentRepository;


    @Override
    public Student find(Long idStudent) throws EntityNotFoundException {

        Student student;

        try {
            student = retrieveStudentRepository.findById(idStudent);
        } catch (Exception ex) {
            throw new EntityNotFoundException(Student.class, idStudent);
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        return retrieveStudentRepository.findAll();
    }
}
