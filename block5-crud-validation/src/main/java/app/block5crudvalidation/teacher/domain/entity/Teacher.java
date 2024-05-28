package app.block5crudvalidation.teacher.domain.entity;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.student.domain.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Long idTeacher;
    private Person person;
    private String comments;
    private Branch branch;
    private List<Student> students;
}
