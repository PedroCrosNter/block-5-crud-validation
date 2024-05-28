package app.block5crudvalidation.subject.infrastructure.controller.dto.input;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class SubjectCreateInputDto {

//    private Long idStudent;

    private String name;

    private String comments;

    private LocalDate initialDate;

    private LocalDate finishDate;

//    private List<Long> idSubjects;
}
