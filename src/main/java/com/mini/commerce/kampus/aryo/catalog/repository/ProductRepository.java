package com.mini.commerce.kampus.aryo.catalog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.commerce.kampus.aryo.catalog.entity.Product;
import com.mini.commerce.kampus.aryo.catalog.enums.ProductStatus;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByStatus(ProductStatus status);
}
