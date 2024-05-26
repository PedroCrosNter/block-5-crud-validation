package app.block5crudvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        // TODO PREGUNTAR
        /**
         *  UpdatePersonRepository/UpdateStudentRepository: ¿Cómo deberían ser? ==
         *  ==> (Boolean update(Person person); || void update(Person person);)
         */

        /**
         *  ¿El paquete "use_case_impl" es con snake_case al final?
         */

        /**
         *  ¿Es correcto el DTO -> dto.input.PersonUpdateInputDto?
         *  Ya que es igual que dto.output.PersonOutputDto
         */

        /**
         *  La anotación @NonNull de lombok tanto en entidades como en DTO ¿Es correcta?
         *  ¿Quién controla sus excepciones si uno de los campos es NULL?
         */

        /**
         * El repositorio se implementa desde domain a infra
         */

        /**
         * UpdateStudentRepository, ¿en la firma devolver "Objeto" o "Long" o nada*?
         */
    }

}
