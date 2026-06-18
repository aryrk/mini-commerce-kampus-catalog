package com.mini.commerce.kampus.aryo.catalog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mini.commerce.kampus.aryo.catalog.dto.Product.CreateProduct.CreateProductRequest;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.CreateProduct.CreateProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.DetailProduct.DetailProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.ListProduct.ListProductResponse;
import com.mini.commerce.kampus.aryo.catalog.entity.Product;
import com.mini.commerce.kampus.aryo.catalog.enums.ProductStatus;
import com.mini.commerce.kampus.aryo.catalog.exception.BusinessExeption;
import com.mini.commerce.kampus.aryo.catalog.mapper.CatalogMapper;
import com.mini.commerce.kampus.aryo.catalog.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CatalogMapper catalogMapper;

    public CreateProductResponse createProduct(CreateProductRequest payload){
        Product product = new Product();
        product.setSku(payload.getSku());
        product.setName(payload.getName());
        product.setPrice(payload.getPrice());
        product.setStock(payload.getStock());

        Product savedProduct = productRepository.save(product);

        return catalogMapper.toCreateProductResponse(savedProduct);
    }

    public List<ListProductResponse> listProducts() {
        List<Product> products = productRepository.findByStatus(ProductStatus.ACTIVE);

        return products.stream()
                .map(catalogMapper::toListProductResponse)
                .toList();
    }

    public DetailProductResponse getProductDetail(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption("Product not found"));

        return catalogMapper.toDetailProductResponse(product);
    }

    public void updateProductStock(UUID id, int newStock) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption("Product not found"));
        product.setStock(newStock);
        productRepository.save(product);

        return;
    }

    public void updateProductStatus(UUID id, ProductStatus newStatus) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption("Product not found"));
        product.setStatus(newStatus);
        productRepository.save(product);

        return;
    }

}
