package app.block5crudvalidation.teacher.infrastructure.controller.dto.output;

import app.block5crudvalidation.person.infrastructure.controller.dto.output.PersonOutputDto;
import app.block5crudvalidation.shared.enums.Branch;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherOutputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;

    PersonOutputDto person;
}
