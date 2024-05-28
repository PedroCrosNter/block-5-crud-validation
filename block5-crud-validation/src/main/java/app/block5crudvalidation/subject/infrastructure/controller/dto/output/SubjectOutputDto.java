package app.block5crudvalidation.subject.infrastructure.controller.dto.output;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class SubjectOutputDto {

    private Long idSubject;

//    private Long idStudent;

    private String name;

    private String comments;

    private LocalDate initialDate;

    private LocalDate finishDate;

//    private List<StudentOutputDto> students;
}
