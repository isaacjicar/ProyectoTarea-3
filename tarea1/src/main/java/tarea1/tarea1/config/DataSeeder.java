package tarea1.tarea1.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tarea1.tarea1.logic.role.model.Role;
import tarea1.tarea1.logic.role.repository.RoleRepository;
import tarea1.tarea1.logic.user.model.User;
import tarea1.tarea1.logic.user.repository.UserRepository;


@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        Role superRole = roleRepo.findByName("SUPER-ADMIN-ROLE")
                .orElseGet(() -> roleRepo.save(new Role(null, "SUPER-ADMIN-ROLE")));

        Role userRole = roleRepo.findByName("USER")
                .orElseGet(() -> roleRepo.save(new Role(null, "USER")));

        if (!userRepo.existsByEmail("super.admin@gmail.com")) {
            User u = new User();
            u.setEmail("super.admin@gmail.com");
            u.setPassword(encoder.encode("superadmin123"));
            u.setRole((superRole));
            userRepo.save(u);
        }

        if (!userRepo.existsByEmail("user@gmail.com")) {
            User u = new User();
            u.setEmail("user@gmail.com");
            u.setPassword(encoder.encode("user123"));
            u.setRole((userRole));
            userRepo.save(u);
        }
    }
}