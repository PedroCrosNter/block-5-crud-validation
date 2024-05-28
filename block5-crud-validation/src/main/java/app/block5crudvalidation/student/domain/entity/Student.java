package app.block5crudvalidation.student.domain.entity;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.subject.domain.entity.Subject;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private Long idStudent;
    private Person person;
    private Integer numHoursWeek;
    private Teacher teacher;
    private Branch branch;
    private List<Subject> subjects;

    public void addSubjects(Subject subject) {
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
    }

    public void removeSubjects(Subject subject) {
        if (subjects != null) {
            subjects.remove(subject);
        }
    }
}
