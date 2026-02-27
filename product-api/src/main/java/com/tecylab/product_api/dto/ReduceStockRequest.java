package com.tecylab.product_api.dto;

import jakarta.validation.constraints.NotNull;

public record ReduceStockRequest(

        @NotNull(message = "el id del producto es obligatorio")
        Long productId,
        @NotNull(message = "la cantidad es obligatoria")
        Integer quantity

) {
}
