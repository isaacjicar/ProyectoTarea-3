package tarea1.tarea1.logic.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoryCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String descripcion;
}
