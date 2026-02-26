package tarea1.tarea1.logic.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarea1.tarea1.logic.category.model.Category;


import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName (String name);
    Optional<Category> findByName (String name);
}
