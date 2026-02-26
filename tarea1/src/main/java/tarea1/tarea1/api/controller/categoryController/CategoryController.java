package tarea1.tarea1.api.controller.categoryController;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tarea1.tarea1.logic.category.dto.request.CategoryCreateRequest;
import tarea1.tarea1.logic.category.dto.request.CategoryUpdateRequest;
import tarea1.tarea1.logic.category.dto.response.CategoryResponse;
import tarea1.tarea1.logic.category.service.CategoryService;


import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public List<CategoryResponse> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @PostMapping
    public CategoryResponse create(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest){
        return categoryService.crete(categoryCreateRequest);
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id, @RequestBody @Valid CategoryUpdateRequest categoryCreateRequest) {
        return categoryService.update(id, categoryCreateRequest);
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
