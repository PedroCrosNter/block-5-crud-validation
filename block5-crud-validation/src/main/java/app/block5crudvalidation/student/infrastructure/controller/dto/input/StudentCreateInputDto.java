package app.block5crudvalidation.student.infrastructure.controller.dto.input;

import app.block5crudvalidation.shared.enums.Branch;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCreateInputDto {

    @NonNull
    private Long idPerson;

    @NonNull
    private Integer numHoursWeek;

    @NonNull
    private Long idTeacher;

    @NonNull
    private Branch branch;

    private List<Long> idSubjects;
}
