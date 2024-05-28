package app.block5crudvalidation.subject.domain.repository;

import app.block5crudvalidation.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveSubjectRepository {

    Subject findById(Long idSubject);

    List<Subject> findAll();
}
