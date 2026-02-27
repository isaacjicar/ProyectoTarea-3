package tarea1.tarea1.api.controller.authController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tarea1.tarea1.logic.auth.AuthenticationService;
import tarea1.tarea1.logic.user.dto.request.UserLoginRequest;
import tarea1.tarea1.logic.user.dto.response.LoginResponse;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return authService.login(userLoginRequest);
    }
}

