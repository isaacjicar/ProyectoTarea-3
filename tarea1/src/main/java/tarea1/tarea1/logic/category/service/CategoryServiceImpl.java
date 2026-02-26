package tarea1.tarea1.logic.category.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tarea1.tarea1.logic.category.dto.request.CategoryCreateRequest;
import tarea1.tarea1.logic.category.dto.request.CategoryUpdateRequest;
import tarea1.tarea1.logic.category.dto.response.CategoryResponse;
import tarea1.tarea1.logic.category.mapper.CategoryMapper;
import tarea1.tarea1.logic.category.model.Category;
import tarea1.tarea1.logic.category.repository.CategoryRepository;
import tarea1.tarea1.logic.product.service.ProductLookService;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoRepo;
    private final ProductLookService productLookService;
    private final CategoryMapper cateMapper;

    @Override
    public Category getEntityOrThrow(Long id) {
        return categoRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Categoria no existe con el id =" + id ));
    }

    @Override
    @Transactional
    public CategoryResponse crete(CategoryCreateRequest cateCreRequest) {
        if(categoRepo.existsByName(cateCreRequest.getName())){
            throw new IllegalArgumentException("La categoria ya existe" + cateCreRequest.getName());
        }
        Category saved = categoRepo.save(cateMapper.toEntity(cateCreRequest));
        return cateMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public CategoryResponse update(Long id, CategoryUpdateRequest cateUpdRequest) {
        Category category = getEntityOrThrow(id);

        if (!category.getName().equals(cateUpdRequest.getName()) && categoRepo.existsByName(cateUpdRequest.getName()))
            throw new IllegalArgumentException("Ya existe una categoria con ese nombre" + cateUpdRequest.getName());
        {
            cateMapper.updateEntity(category,cateUpdRequest);
            Category saved = categoRepo.save(category);
            return cateMapper.toResponse(saved);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!categoRepo.existsById(id)){
            throw new IllegalArgumentException("Categoria no existe con el id = "+ id);
        }
        if(productLookService.existsByCategoryId(id)){
            throw new IllegalArgumentException("No se puede elimiar: hay un producto asociado a esta categoria " );
        }
        categoRepo.deleteById(id);
    }


    @Override
    public List<CategoryResponse> findAll() {
        return categoRepo.findAll().stream().map(cateMapper::toResponse).toList();
    }

    @Override
    public CategoryResponse findById(Long id) {
        return categoRepo.findById(id).map(cateMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no existe con el id " + id));
    }
}
