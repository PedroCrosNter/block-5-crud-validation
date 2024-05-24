package app.block5crudvalidation.person.infrastructure.repository.jpa;

import app.block5crudvalidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryJpa extends JpaRepository<PersonJpa, Long> {
}
