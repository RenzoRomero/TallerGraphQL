package com.tecylab.product_api.dto;

import java.math.BigDecimal;

public record ProductResponse(

        Long id,
        String name,
        BigDecimal price,
        Integer stock

) {}
