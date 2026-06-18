package com.mini.commerce.kampus.aryo.catalog.mapper;

import org.mapstruct.Mapper;

import com.mini.commerce.kampus.aryo.catalog.dto.Product.CreateProduct.CreateProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.DetailProduct.DetailProductResponse;
import com.mini.commerce.kampus.aryo.catalog.dto.Product.ListProduct.ListProductResponse;
import com.mini.commerce.kampus.aryo.catalog.entity.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.ERROR)
public interface CatalogMapper {
    CreateProductResponse toCreateProductResponse(Product product);
    DetailProductResponse toDetailProductResponse(Product product);
    ListProductResponse toListProductResponse(Product product);
}
