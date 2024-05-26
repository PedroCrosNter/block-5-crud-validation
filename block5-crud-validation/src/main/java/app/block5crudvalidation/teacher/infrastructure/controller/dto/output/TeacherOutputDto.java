package app.block5crudvalidation.teacher.infrastructure.controller.dto.output;

import app.block5crudvalidation.shared.enums.Branch;
import lombok.NonNull;

public class TeacherOutputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private Long idPerson;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;
}
