package app.block5crudvalidation.student.infrastructure.controller.dto.output;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.teacher.domain.entity.Teacher;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentOutputDto {

    @NonNull
    private Long idStudent;

    @NonNull // Foreign key
    private Person person;

    @NonNull
    private Integer numHoursWeek;

    private Teacher teacher;

    @NonNull
    private Branch branch;
}
