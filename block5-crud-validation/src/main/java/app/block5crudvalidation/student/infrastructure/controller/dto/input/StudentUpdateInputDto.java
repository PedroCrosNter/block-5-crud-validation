package app.block5crudvalidation.student.infrastructure.controller.dto.input;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentUpdateInputDto {

    @NonNull
    private Long idStudent;

    @NonNull // Foreign key
    private Person person;

    @NonNull
    private int numHoursWeek;

    @NonNull // Foreign key
    private Teacher teacher;

    @NonNull
    private Branch branch;
}
