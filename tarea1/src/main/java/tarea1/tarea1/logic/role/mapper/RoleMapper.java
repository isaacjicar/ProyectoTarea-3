package tarea1.tarea1.logic.role.mapper;

import org.mapstruct.*;
import tarea1.tarea1.logic.role.dto.request.RoleCreateRequest;
import tarea1.tarea1.logic.role.dto.request.RoleUpdateRequest;
import tarea1.tarea1.logic.role.dto.response.RoleResponse;
import tarea1.tarea1.logic.role.model.Role;


@Mapper(componentModel = "spring")
public interface RoleMapper {


    @Mapping(target = "id", ignore = true)
    Role toEntity(RoleCreateRequest dto);


    RoleResponse toResponse(Role entity);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Role role, RoleUpdateRequest dto);
}
