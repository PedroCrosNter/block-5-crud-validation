package app.block5crudvalidation.student.application.impl;

import app.block5crudvalidation.person.domain.repository.DeletePersonRepository;
import app.block5crudvalidation.student.application.DeleteStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStudentUseCaseImpl implements DeleteStudentUseCase {

    private final DeletePersonRepository deletePersonRepository;


    @Override
    public void delete(Long idStudent) {
        deletePersonRepository.delete(idStudent);
    }
}
