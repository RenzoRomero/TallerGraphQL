package com.tecylab.product_api.mapper;

import com.tecylab.product_api.dto.ProductRequest;
import com.tecylab.product_api.dto.ProductResponse;
import com.tecylab.product_api.model.Product;

public class ProductMapper {

    public static Product toEntity (ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .stock(productRequest.stock())
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock());
    }

}
