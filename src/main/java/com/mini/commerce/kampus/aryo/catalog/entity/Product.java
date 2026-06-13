package com.mini.commerce.kampus.aryo.catalog.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.mini.commerce.kampus.aryo.catalog.enums.ProductStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false, name = "SKU")
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    @Min(value = 1, message = "Harga harus lebih besar dari 0")
    private BigDecimal price;

    @Column(nullable = false)
    @Min(value = 0, message = "Stok tidak boleh negatif")
    private int stock;

    @Column(nullable = false)
    private ProductStatus status = ProductStatus.ACTIVE;
}
