package tarea1.tarea1.api.controller.userController;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tarea1.tarea1.logic.user.dto.response.UserResponse;
import tarea1.tarea1.logic.user.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

}
