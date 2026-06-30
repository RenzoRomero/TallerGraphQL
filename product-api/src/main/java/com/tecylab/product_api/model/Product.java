package com.tecylab.product_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el nombre es obligatorio")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "el precio es obligatorio")
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull(message = "el stock es obligatorio")
    @Column(nullable = false)
    private Integer stock;

}
