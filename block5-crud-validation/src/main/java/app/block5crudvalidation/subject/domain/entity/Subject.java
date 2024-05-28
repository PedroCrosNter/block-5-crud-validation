package app.block5crudvalidation.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {

    private Long idSubject;
    private Long idStudent;
    private String name;
    private String comment;
    private LocalDate initialDate;
    private LocalDate finishDate;
}
