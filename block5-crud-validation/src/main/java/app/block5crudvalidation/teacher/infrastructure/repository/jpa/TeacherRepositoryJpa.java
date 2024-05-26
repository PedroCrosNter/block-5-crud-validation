package app.block5crudvalidation.teacher.infrastructure.repository.jpa;

import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositoryJpa extends JpaRepository<TeacherJpa, Long> {
}
