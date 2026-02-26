package tarea1.tarea1.logic.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import tarea1.tarea1.logic.role.model.Role;
import tarea1.tarea1.logic.role.repository.RoleRepository;
import tarea1.tarea1.logic.user.dto.request.UserCreateRequest;
import tarea1.tarea1.logic.user.dto.request.UserUpdateRequest;
import tarea1.tarea1.logic.user.dto.response.UserResponse;
import tarea1.tarea1.logic.user.model.User;


@Mapper(componentModel = "spring")
public abstract class UserMapper {

    protected RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "roleId")
    public abstract User toEntity(UserCreateRequest dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "roleId")
    public abstract void updateEntity(@MappingTarget User user, UserUpdateRequest dto);


    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "role", source = "role.name")
    public abstract UserResponse toResponse(User user);


    protected Role map(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role no existe con id=" + id));
    }
}
