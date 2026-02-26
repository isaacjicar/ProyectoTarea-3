package tarea1.tarea1.logic.category.service;



import tarea1.tarea1.logic.category.dto.request.CategoryCreateRequest;
import tarea1.tarea1.logic.category.dto.request.CategoryUpdateRequest;
import tarea1.tarea1.logic.category.dto.response.CategoryResponse;
import tarea1.tarea1.logic.category.model.Category;

import java.util.List;


public interface CategoryService {
    Category getEntityOrThrow(Long id);
    CategoryResponse crete(CategoryCreateRequest cateCreRequest);
    CategoryResponse update(Long id , CategoryUpdateRequest cateUpdRequest);
    void delete (Long id);
    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
}

