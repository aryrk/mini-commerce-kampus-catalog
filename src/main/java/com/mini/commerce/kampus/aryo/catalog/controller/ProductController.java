package com.mini.commerce.kampus.aryo.catalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mini.commerce.kampus.aryo.catalog.dto.Product.CreateProduct.CreateProductRequest;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.CreateProduct.CreateProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.DetailProduct.DetailProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.ListProduct.ListProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.UpdateStatus.UpdateStatusRequest;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.UpdateStock.UpdateStockRequest;
import com.mini.commerce.kampus.aryo.catalog.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductRequest payload) {
        CreateProductResponse response = productService.createProduct(payload);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ListProductResponse>> productList() {
        List<ListProductResponse> response = productService.listProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailProductResponse> getProductDetail(@PathVariable UUID id) {
        DetailProductResponse response = productService.getProductDetail(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<Void> updateProductStock(@PathVariable UUID id, @RequestBody UpdateStockRequest payload) {
        productService.updateProductStock(id, payload.getStock());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateProductStatus(@PathVariable UUID id, @RequestBody UpdateStatusRequest payload) {
        productService.updateProductStatus(id, payload.getStatus());
        return ResponseEntity.ok().build();
    }
}
