package tarea1.tarea1.logic.category.mapper;

import org.mapstruct.*;
import tarea1.tarea1.logic.category.dto.request.CategoryCreateRequest;
import tarea1.tarea1.logic.category.dto.request.CategoryUpdateRequest;
import tarea1.tarea1.logic.category.dto.response.CategoryResponse;
import tarea1.tarea1.logic.category.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryCreateRequest dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Category entity, CategoryUpdateRequest dto);


    CategoryResponse toResponse(Category entity);
}
