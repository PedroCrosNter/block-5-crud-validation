package app.block5crudvalidation.teacher.domain.entity;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.enums.Branch;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Long idTeacher;
    private Person person;
    private String comments;
    private Branch branch;
}
