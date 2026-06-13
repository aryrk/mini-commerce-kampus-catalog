package com.mini.commerce.kampus.aryo.catalog.dto.Product.UpdateStatus;

import com.mini.commerce.kampus.aryo.catalog.enums.ProductStatus;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateStatusRequest {
    @NotBlank(message = "Status tidak boleh kosong")
    public ProductStatus status;
}
