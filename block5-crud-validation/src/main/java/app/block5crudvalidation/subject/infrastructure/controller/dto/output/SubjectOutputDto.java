package app.block5crudvalidation.subject.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectOutputDto {

    private Long idSubject;

    private Long idStudent;

    private String name;

    private String comments;

    private LocalDate initialDate;

    private LocalDate finishDate;
}
