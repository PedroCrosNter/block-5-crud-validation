package app.block5crudvalidation.person.application.mapper;

import app.block5crudvalidation.person.domain.entity.Person;
import app.block5crudvalidation.person.infrastructure.controller.dto.input.PersonInputDto;
import app.block5crudvalidation.person.infrastructure.controller.dto.input.PersonUpdateInputDto;
import app.block5crudvalidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
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

//    @Mapping(source = "idPerson", target = "idPerson")
    Person toEntity(PersonJpa personJpa);

    void toEntity(Person source, @MappingTarget PersonJpa target);

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
