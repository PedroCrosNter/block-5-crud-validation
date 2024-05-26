package app.block5crudvalidation.teacher.infrastructure.controller.dto.input;

import app.block5crudvalidation.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherUpdateInputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private Long idPerson;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;
}
