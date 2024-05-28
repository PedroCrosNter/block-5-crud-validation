package app.block5crudvalidation.student.infrastructure.repository.jpa;

import app.block5crudvalidation.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepositoryJpa extends JpaRepository<StudentJpa, Long> {

    @Query("SELECT s.students FROM SubjectJpa s WHERE s.idSubject = :subjectId")
    List<StudentJpa> findStudentsBySubjectId(Long subjectId);
//    List<SubjectJpa> findBySubjectsIdStudent(Long studentId);
}
