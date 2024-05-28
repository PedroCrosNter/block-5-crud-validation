package app.block5crudvalidation.student.infrastructure.repository.impl;

import app.block5crudvalidation.student.application.mapper.StudentEntityMapper;
import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.domain.repository.RetrieveStudentRepository;
import app.block5crudvalidation.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudvalidation.student.infrastructure.repository.jpa.entity.StudentJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrieveStudentRepositoryImpl implements RetrieveStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Student findById(Long idStudent) {
//        studentRepositoryJpa.findById(idStudent);
//        return StudentEntityMapper.INSTANCE.toEntity(
//                studentRepositoryJpa.findById(idStudent)
//                        .orElseThrow( () -> new EntityNotFoundException(Student.class, idStudent) )
//        );

        StudentJpa studentJpa = studentRepositoryJpa.findById(idStudent).get(); // --> StudentJpa ya viene con bucle infinito y al mapearlo se interumple el programa
        Student student = StudentEntityMapper.INSTANCE.toEntity(studentJpa); // ==> CREA UN BUCLE INFINITO
//        List<SubjectJpa> subjectJpaList = studentRepositoryJpa.findStudentsBySubjectId(studentJpa.getIdStudent());
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<StudentJpa> studentJpaList = studentRepositoryJpa.findAll();
        return studentJpaList.stream()
                .map(StudentEntityMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }
}
