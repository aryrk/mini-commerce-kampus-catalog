package com.mini.commerce.kampus.aryo.catalog.dto.Product.DetailProduct;

import java.math.BigDecimal;
import java.util.UUID;

import com.mini.commerce.kampus.aryo.catalog.enums.ProductStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailProductResponse {
    private UUID id;
    private String sku;
    private String name;
    private BigDecimal price;
    private int stock;
    private ProductStatus status;
}
