package app.block5crudvalidation.student.domain.entity;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private Long idStudent;
    private Person person;
    private int numHoursWeek;
    private Teacher teacher;
    private Branch branch;
}
