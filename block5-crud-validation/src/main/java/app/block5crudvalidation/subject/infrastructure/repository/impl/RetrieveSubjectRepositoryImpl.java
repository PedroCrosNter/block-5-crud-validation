package app.block5crudvalidation.subject.infrastructure.repository.impl;

import app.block5crudvalidation.shared.exceptions.EntityNotFoundException;
import app.block5crudvalidation.subject.application.mapper.SubjectEntityMapper;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.subject.domain.repository.RetrieveSubjectRepository;
import app.block5crudvalidation.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.block5crudvalidation.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrieveSubjectRepositoryImpl implements RetrieveSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Subject findById(Long idSubject) {

        return SubjectEntityMapper.INSTANCE.toEntity(
                subjectRepositoryJpa.findById(idSubject)
                        .orElseThrow(() -> new EntityNotFoundException(Subject.class, idSubject)));
    }

    @Override
    public List<Subject> findAll() {

        List<SubjectJpa> subjectJpaList = subjectRepositoryJpa.findAll();
        return subjectJpaList.stream()
                .map(SubjectEntityMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }
}
