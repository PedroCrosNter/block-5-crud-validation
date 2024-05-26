package app.block5crudvalidation.student.infrastructure.repository.jpa;

import app.block5crudvalidation.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJpa extends JpaRepository<StudentJpa, Long> {
}
