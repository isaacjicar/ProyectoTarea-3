package tarea1.tarea1.logic.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarea1.tarea1.logic.role.model.Role;


import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName (String name);
    boolean existsByName (String name);
}
