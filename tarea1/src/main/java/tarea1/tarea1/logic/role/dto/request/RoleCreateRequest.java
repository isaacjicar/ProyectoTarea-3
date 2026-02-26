package tarea1.tarea1.logic.role.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoleCreateRequest {

    @NotBlank
    private String name;
}
