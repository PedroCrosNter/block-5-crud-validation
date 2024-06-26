package app.block5crudvalidation.subject.application.impl;

import app.block5crudvalidation.subject.application.CreateSubjectUseCase;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.subject.domain.repository.CreateSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSubjectUseCaseImpl implements CreateSubjectUseCase {

    private final CreateSubjectRepository createSubjectRepository;


    @Override
    public Long save(Subject subject) {

        return createSubjectRepository.save(subject);
    }
}
