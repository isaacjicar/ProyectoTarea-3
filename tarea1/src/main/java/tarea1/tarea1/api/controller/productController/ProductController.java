package tarea1.tarea1.api.controller.productController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tarea1.tarea1.logic.product.dto.request.ProductCreateRequest;
import tarea1.tarea1.logic.product.dto.request.ProductUptadeRequest;
import tarea1.tarea1.logic.product.dto.response.ProductResponse;
import tarea1.tarea1.logic.product.service.ProductoService;


import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductoService productoService;

    @GetMapping
    public List<ProductResponse> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @PostMapping
    public ProductResponse create(@RequestBody @Valid ProductCreateRequest productCreateRequest){
        return productoService.crete(productCreateRequest);
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody @Valid ProductUptadeRequest productUptadeRequest) {
        return productoService.update(id, productUptadeRequest);
    }

    @PreAuthorize("hasAuthority('SUPER-ADMIN-ROLE')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.delete(id);
    }


}
