package app.block5crudvalidation.subject.infrastructure.repository.impl;

import app.block5crudvalidation.subject.application.mapper.SubjectEntityMapper;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.subject.domain.repository.CreateSubjectRepository;
import app.block5crudvalidation.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.block5crudvalidation.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateSubjectRepositoryImpl implements CreateSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Long save(Subject subject) {

        SubjectJpa subjectJpa = SubjectEntityMapper.INSTANCE.toEntityJpa(subject);
        return subjectRepositoryJpa.save(subjectJpa).getIdSubject();
    }
}
