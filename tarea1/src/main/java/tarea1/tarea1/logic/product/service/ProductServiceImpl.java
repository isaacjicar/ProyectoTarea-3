package tarea1.tarea1.logic.product.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tarea1.tarea1.logic.category.model.Category;
import tarea1.tarea1.logic.category.service.CategoryService;
import tarea1.tarea1.logic.product.dto.request.ProductCreateRequest;
import tarea1.tarea1.logic.product.dto.request.ProductUptadeRequest;
import tarea1.tarea1.logic.product.dto.response.ProductResponse;
import tarea1.tarea1.logic.product.mapper.ProductMapper;
import tarea1.tarea1.logic.product.model.Product;
import tarea1.tarea1.logic.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductoService{
    private final ProductRepository prodRepository;
    private final CategoryService categoryService;
    private final ProductMapper prodMapper;

    public Category getCategoryOrThrow(Long id){
        return categoryService.getEntityOrThrow(id);
    }

    @Override
    @Transactional
    public ProductResponse crete(ProductCreateRequest prodCreRequest) {

        Product entity = prodMapper.toEntity(prodCreRequest);
        Category category = categoryService.getEntityOrThrow(prodCreRequest.getCategoryId());

        entity.setCategory(category);

        Product saved = prodRepository.save(entity);
        return prodMapper.toResponse(saved);
    }


    @Override
    @Transactional
    public ProductResponse update(Long id, ProductUptadeRequest prodUpdRequest) {
        Product product = prodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no existe con el id = " + id));

        prodMapper.updateEntity(product, prodUpdRequest);
        if (prodUpdRequest.getCategoryId() != null) {
            Category category = categoryService.getEntityOrThrow(prodUpdRequest.getCategoryId());
            product.setCategory(category);
        }

        Product saved = prodRepository.save(product);
        return prodMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        if(!prodRepository.existsById(id)){
            throw new IllegalArgumentException("Producto no existe con el id" + id);
        }
        prodRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> findAll() {
        return prodRepository.findAll().stream().map(prodMapper::toResponse).toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        return prodRepository.findById(id).map(prodMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Producto no existe con el id = " + id));
    }
}
