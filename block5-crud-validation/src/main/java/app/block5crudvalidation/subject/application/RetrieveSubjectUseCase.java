package app.block5crudvalidation.subject.application;

import app.block5crudvalidation.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveSubjectUseCase {

    Subject findById(Long idSubject);

    List<Subject> findAll();
}
