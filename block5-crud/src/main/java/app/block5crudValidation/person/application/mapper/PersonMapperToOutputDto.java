package app.block5crudValidation.person.application.mapper;

import app.block5crudValidation.person.domain.entity.Person;
import app.block5crudValidation.person.infrastructure.controller.dto.output.PersonOutputDto;
import app.block5crudValidation.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapperToOutputDto {

    PersonMapperToOutputDto INSTANCE = Mappers.getMapper(PersonMapperToOutputDto.class);

    PersonOutputDto toOutputDto(Person person);

    PersonOutputDto toOutputDto(PersonJpa personJpa);

    List<PersonOutputDto> toOutputDtoList(List<Person> people);
}
