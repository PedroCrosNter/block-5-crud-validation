package app.block5crudvalidation.subject.application;

import app.block5crudvalidation.subject.domain.entity.Subject;

public interface CreateSubjectUseCase {

    Long save(Subject subject);
}
