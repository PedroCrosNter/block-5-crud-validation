package app.block5crudValidation.person.application.mapper;

import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.infrastructure.controller.dto.input.PersonInputDto;
import app.block5crudValidation.person.infrastructure.controller.dto.input.PersonUpdateInputDto;
import app.block5crudValidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {

    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);


// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################
    Person toEntity(PersonInputDto personInputDto);

    Person toEntity(PersonUpdateInputDto personUpdateInputDto);

    Person toEntity(PersonJpa personJpa);

// ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Person> toEntityListFromJpa(List<PersonJpa> peopleJpa);

    @Named("toEntityListFromInputDto")
    List<Person> toEntityListFromInputDto(List<PersonInputDto> peopleInputDtoList);


// ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    PersonJpa toEntityJpa(Person person);

    PersonJpa toEntityJpa(PersonJpa personJpa);

    PersonJpa toEntityJpa(PersonInputDto personInputDto);

// ########################################## LIST #########################################
    List<PersonJpa> toEntityJpaList(List<Person> people);

    Iterable<PersonJpa> toEntityJpaIterable(List<Person> people);
}
