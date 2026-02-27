package tarea1.tarea1.logic.product.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import tarea1.tarea1.logic.category.model.Category;
import tarea1.tarea1.logic.category.repository.CategoryRepository;
import tarea1.tarea1.logic.product.dto.request.ProductCreateRequest;
import tarea1.tarea1.logic.product.dto.request.ProductUptadeRequest;
import tarea1.tarea1.logic.product.dto.response.ProductResponse;
import tarea1.tarea1.logic.product.model.Product;


@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Autowired
    protected CategoryRepository categoryRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "categoryId")
    public abstract Product toEntity(ProductCreateRequest dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "categoryId")
    public abstract void updateEntity(@MappingTarget Product product, ProductUptadeRequest dto);


    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "category", source = "category.name")
    public abstract ProductResponse toResponse(Product product);

    protected Category map(Long id) {
        if (id == null) return null;
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no existe con id=" + id));
    }
}