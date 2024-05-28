package app.block5crudvalidation.student.infrastructure.controller.dto.output;

import app.block5crudvalidation.person.infrastructure.controller.dto.output.PersonOutputDto;
import app.block5crudvalidation.shared.enums.Branch;
import app.block5crudvalidation.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.block5crudvalidation.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentOutputDto {

    @NonNull
    private Long idStudent;

    @NonNull // Foreign key
    private PersonOutputDto person;

    @NonNull
    private Integer numHoursWeek;

    private TeacherOutputDto teacher;

    @NonNull
    private Branch branch;

    private List<SubjectOutputDto> subjects;
}
