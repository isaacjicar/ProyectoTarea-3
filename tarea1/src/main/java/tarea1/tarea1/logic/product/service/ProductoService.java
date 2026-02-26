package tarea1.tarea1.logic.product.service;





import tarea1.tarea1.logic.product.dto.request.ProductCreateRequest;
import tarea1.tarea1.logic.product.dto.request.ProductUptadeRequest;
import tarea1.tarea1.logic.product.dto.response.ProductResponse;

import java.util.List;


public interface ProductoService {
    ProductResponse crete(ProductCreateRequest prodCreRequest);
    ProductResponse update(Long id , ProductUptadeRequest prodUpdRequest);
    void delete (Long id);
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
}

