package tarea1.tarea1.logic.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tarea1.tarea1.logic.product.repository.ProductRepository;


@Service
@RequiredArgsConstructor
public class ProductLookServiceImpl implements ProductLookService {

    private final ProductRepository productRepository;

    @Override
    public boolean existsByCategoryId(Long categoryId) {
        return productRepository.existsByCategoryId(categoryId);
    }
}
