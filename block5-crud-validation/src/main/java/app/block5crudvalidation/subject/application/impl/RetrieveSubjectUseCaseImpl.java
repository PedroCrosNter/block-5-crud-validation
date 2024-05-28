package app.block5crudvalidation.subject.application.impl;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.subject.application.RetrieveSubjectUseCase;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.subject.domain.repository.RetrieveSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveSubjectUseCaseImpl implements RetrieveSubjectUseCase {

    private final RetrieveSubjectRepository retrieveSubjectRepository;


    @Override
    public Subject findById(Long idSubject) throws EntityNotFoundException {

        Subject subject;

        try {
            subject = retrieveSubjectRepository.findById(idSubject);
        } catch (Exception e) {
            throw new EntityNotFoundException(Subject.class, idSubject);
        }

        return subject;
    }

    @Override
    public List<Subject> findAll() {
        return retrieveSubjectRepository.findAll();
    }
}
