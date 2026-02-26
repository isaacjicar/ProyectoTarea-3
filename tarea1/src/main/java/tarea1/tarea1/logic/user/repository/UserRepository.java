package tarea1.tarea1.logic.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tarea1.tarea1.logic.user.model.User;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
    boolean existsByEmail (String email);
}
