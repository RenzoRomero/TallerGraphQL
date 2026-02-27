package com.tecylab.product_api.controller.graphql;

import com.tecylab.product_api.dto.ProductResponse;
import com.tecylab.product_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductQueryResolver {

    private final ProductService productService;

    @QueryMapping
    public ProductResponse getProductById(@Argument Long id) {
        return productService.getById(id);
    }

    @QueryMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAll();
    }
}
