package tarea1.tarea1.logic.product.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ProductCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String descripcion;

    @NotNull @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull @Min(0)
    private int stockQuantity;

    @NotNull
    private long categoryId;
}
