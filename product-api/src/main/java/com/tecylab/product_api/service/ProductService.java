package com.tecylab.product_api.service;

import com.tecylab.product_api.dto.ProductRequest;
import com.tecylab.product_api.dto.ProductResponse;
import com.tecylab.product_api.dto.ReduceStockRequest;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest productRequest);
    ProductResponse getById(Long id);
    List<ProductResponse> getAll();
    ProductResponse update(Long id, ProductRequest productRequest);
    void delete(Long id);

}
