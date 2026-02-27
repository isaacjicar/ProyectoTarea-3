package tarea1.tarea1.logic.product.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ProductResponse {

    private long id;
    private String name;
    private String descripcion;
    private BigDecimal price;
    private int stockQuantity;

    private Long categoryId;
    private String category;
}
