package app.block5crudvalidation.subject.infrastructure.repository.jpa;

import app.block5crudvalidation.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepositoryJpa extends JpaRepository<SubjectJpa, Long> {
}
