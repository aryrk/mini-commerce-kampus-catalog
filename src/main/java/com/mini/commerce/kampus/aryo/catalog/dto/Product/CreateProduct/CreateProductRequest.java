package com.mini.commerce.kampus.aryo.catalog.dto.Product.CreateProduct;


import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductRequest {
    
    @NotBlank(message = "SKU tidak boleh kosong")
    private String sku;

    @NotBlank(message = "Nama produk tidak boleh kosong")
    private String name;

    @NotNull(message = "Harga tidak boleh kosong")
    @Min(value = 1, message = "Harga harus lebih besar dari 0")
    private BigDecimal price;

    @NotNull(message = "Stok tidak boleh kosong")
    @Min(value = 0, message = "Stok tidak boleh negatif")
    private int stock;
}
