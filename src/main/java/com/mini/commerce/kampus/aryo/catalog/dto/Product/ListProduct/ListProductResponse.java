package com.mini.commerce.kampus.aryo.catalog.dto.Product.ListProduct;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListProductResponse {
    private UUID id;
    private String sku;
    private String name;
    private String price;
}
