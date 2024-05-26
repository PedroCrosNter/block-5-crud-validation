package app.block5crudvalidation.student.application.mapper;

import app.block5crudvalidation.student.domain.entity.Student;
import app.block5crudvalidation.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudvalidation.student.infrastructure.controller.dto.input.StudentUpdateInputDto;
import app.block5crudvalidation.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentEntityMapper {
    
    StudentEntityMapper INSTANCE = Mappers.getMapper(StudentEntityMapper.class);


// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################

    @Mappings({
            @Mapping(source = "idStudent", target = "idStudent"),
            @Mapping(source = "idPerson", target = "personJpa.idPerson"),
            @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
            @Mapping(source = "idTeacher", target = "teacherJpa.idTeacher"),
            @Mapping(source = "branch", target = "branch", ignore = true)
    })
    Student toEntity(StudentCreateInputDto studentCreateInputDto);

    Student toEntity(StudentUpdateInputDto studentUpdateInputDto);

    Student toEntity(StudentJpa personJpa);

    void toEntity(Student source, @MappingTarget StudentJpa target);

// ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Student> toEntityListFromJpa(List<StudentJpa> peopleJpa);

    @Named("toEntityListFromInputDto")
    List<Student> toEntityListFromInputDto(List<StudentCreateInputDto> peopleInputDtoList);


// ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    StudentJpa toEntityJpa(Student student);

    StudentJpa toEntityJpa(StudentJpa personJpa);

    StudentJpa toEntityJpa(StudentCreateInputDto personCreateInputDto);

// ########################################## LIST #########################################
    List<StudentJpa> toEntityJpaList(List<Student> students);

    Iterable<StudentJpa> toEntityJpaIterable(List<Student> students);
}
