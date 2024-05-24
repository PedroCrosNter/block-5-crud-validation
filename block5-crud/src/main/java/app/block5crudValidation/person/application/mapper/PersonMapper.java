package app.block5crudValidation.person.application.mapper;

import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.infrastructure.controller.dto.input.PersonInputDto;
import app.block5crudValidation.person.infrastructure.controller.dto.output.PersonOutputDto;
import app.block5crudValidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

// PersonDtoMapper.java?
// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################
    Person toEntity(PersonInputDto personInputDto);

    Person toEntity(PersonJpa personJpa);

    List<Person> toEntityList(List<PersonJpa> peopleJpa);

//    List<Person> toEntityList(List<PersonInputDto> peopleInputDtoList);

    void toEntity(Person source, @MappingTarget PersonJpa target);

// PersonMapperToEntityJpa.java?
// ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    PersonJpa toEntityJpa(Person person);

    PersonJpa toEntityJpa(PersonJpa personJpa);

    PersonJpa toEntityJpa(PersonInputDto personInputDto);

    List<PersonJpa> toEntityJpaList(List<Person> people);

    Iterable<PersonJpa> toEntityJpaIterable(List<Person> people);


// PersonMapperToInputDto.java?
// ##########################################################################################
// ##################################### TO InputDto ########################################
// ##########################################################################################
    PersonInputDto toInputDto(Person person);

    PersonInputDto toInputDto(PersonJpa personJpa);

// PersonMapperToOutputDto.java?
// ##########################################################################################
// ##################################### TO OutputDto #######################################
// ##########################################################################################
    PersonOutputDto toOutputDto(Person person);

    PersonOutputDto toOutputDto(PersonJpa personJpa);

    // TODO CREATE: methods
    List<PersonOutputDto> toOutputDtoList(List<Person> people);
//    List<PersonOutputDto> toOutputDtoList(List<PersonJpa> peopleJpa);
}
