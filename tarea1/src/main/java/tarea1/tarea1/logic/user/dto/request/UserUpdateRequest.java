package tarea1.tarea1.logic.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private long roleId;
}
