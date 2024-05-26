package app.block5crudvalidation.teacher.application.mapper;

import app.block5crudvalidation.teacher.domain.entity.Teacher;
import app.block5crudvalidation.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.block5crudvalidation.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
import app.block5crudvalidation.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface TeacherEntityMapper {

    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);


// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################

    @Mappings({
            @Mapping(source = "idStudent", target = "idStudent"),
            @Mapping(source = "idPerson", target = "teacherJpa.idPerson"),
            @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
            @Mapping(source = "idTeacher", target = "teacherJpa.idTeacher"),
            @Mapping(source = "branch", target = "branch", ignore = true)
    })
    Teacher toEntity(TeacherCreateInputDto studentCreateInputDto);

    Teacher toEntity(TeacherUpdateInputDto studentUpdateInputDto);

    Teacher toEntity(TeacherJpa teacherJpa);

    void toEntity(Teacher source, @MappingTarget TeacherJpa target);

    // ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Teacher> toEntityListFromJpa(List<TeacherJpa> teachers);

    @Named("toEntityListFromInputDto")
    List<Teacher> toEntityListFromInputDto(List<TeacherCreateInputDto> teacherInputDtoList);


    // ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    TeacherJpa toEntityJpa(Teacher teacher);

    TeacherJpa toEntityJpa(TeacherJpa teacherJpa);

    TeacherJpa toEntityJpa(TeacherCreateInputDto teacherCreateInputDto);

    // ########################################## LIST #########################################
    List<TeacherJpa> toEntityJpaList(List<Teacher> students);

    Iterable<TeacherJpa> toEntityJpaIterable(List<Teacher> students);
}
