package com.tecylab.product_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotNull(message = "El precio es obligatorio")
        BigDecimal price,
        @NotNull(message = "El stock es obligatorio")
        Integer stock

) {}
