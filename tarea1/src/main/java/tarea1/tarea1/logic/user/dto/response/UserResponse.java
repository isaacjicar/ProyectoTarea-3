package tarea1.tarea1.logic.user.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {

    private long id;
    private String email;
    private long roleId;
    private String role;
}
