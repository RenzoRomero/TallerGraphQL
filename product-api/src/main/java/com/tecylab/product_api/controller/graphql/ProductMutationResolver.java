package com.tecylab.product_api.controller.graphql;

import com.tecylab.product_api.dto.ProductRequest;
import com.tecylab.product_api.dto.ProductResponse;
import com.tecylab.product_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductMutationResolver {

    private final ProductService productService;

    @MutationMapping
    public ProductResponse createProduct(@Argument("input") ProductRequest productRequest) {
        return productService.create(productRequest);
    }

    @MutationMapping
    public ProductResponse updateProduct(@Argument("id") Long id,
                                         @Argument("input") ProductRequest productRequest) {
        return productService.update(id, productRequest);
    }

    @MutationMapping
    public void deleteProduct(@Argument("id") Long id) {
        productService.delete(id);
    }

}
