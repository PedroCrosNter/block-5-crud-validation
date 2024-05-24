package app.block5crudvalidation.person.infrastructure.controller.dto.output;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class PersonOutputDto {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String age;

    @NonNull
    private String bornPlace;

    @NonNull
    private String surname;

    @NonNull
    // TODO ver más anotaciones @Email @Size(max = 50)
    private String companyEmail;

    @NonNull
    private String personalEmail;

    @NonNull
    private String city;

    @NotNull
    private Boolean active;

    @NotNull
    private Date createdDate;

    private String imageUrl;

    private Date terminationDate;
}
