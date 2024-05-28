package app.block5crudvalidation.subject.domain.repository;

import app.block5crudvalidation.subject.domain.entity.Subject;

public interface CreateSubjectRepository {

    Long save(Subject subject);
}
