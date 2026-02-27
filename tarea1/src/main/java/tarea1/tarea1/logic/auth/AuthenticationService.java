package tarea1.tarea1.logic.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import tarea1.tarea1.logic.user.dto.request.UserLoginRequest;
import tarea1.tarea1.logic.user.dto.response.LoginResponse;
import tarea1.tarea1.logic.user.model.User;
import tarea1.tarea1.logic.user.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public LoginResponse login(UserLoginRequest req) {

        authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(req.getEmail(), req.getPassword())
        );

        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User no encontrado"));

        String token = jwtService.generateToken(user);
        return new LoginResponse(token, user.getEmail());
    }
}