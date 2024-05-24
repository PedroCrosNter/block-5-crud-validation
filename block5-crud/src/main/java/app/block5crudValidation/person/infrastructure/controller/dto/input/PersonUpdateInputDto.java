package app.block5crudValidation.person.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonUpdateInputDto {

    private Long id;
    private String name;
    private String age;
    private String bornPlace;
}
