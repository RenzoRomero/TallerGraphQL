package com.tecylab.product_api.service.impl;

import com.tecylab.product_api.dto.ProductRequest;
import com.tecylab.product_api.dto.ProductResponse;
import com.tecylab.product_api.dto.ReduceStockRequest;
import com.tecylab.product_api.exception.InsufficientStockException;
import com.tecylab.product_api.exception.ResourceNotFoundException;
import com.tecylab.product_api.mapper.ProductMapper;
import com.tecylab.product_api.model.Product;
import com.tecylab.product_api.repository.ProductRepository;
import com.tecylab.product_api.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductRequest productRequest) {
        Product product = ProductMapper.toEntity(productRequest);
        return ProductMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ProductMapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setStock(productRequest.stock());
        return ProductMapper.toResponse(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
