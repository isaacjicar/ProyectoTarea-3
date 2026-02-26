package tarea1.tarea1.logic.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarea1.tarea1.logic.product.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByCategoryId (Long categoryId);
}
