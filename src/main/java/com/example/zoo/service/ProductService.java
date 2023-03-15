package com.example.zoo.service;

import com.example.zoo.entity.Product;
import zoo.dto.ProductPostDto;
import zoo.dto.ProductResultDto;

import java.util.List;

public interface ProductService {

    ProductResultDto getProductById(Long id);

    List<ProductResultDto> getAllProducts();

    ProductResultDto addProduct(ProductPostDto productPostDto);

    ProductResultDto updateProduct(ProductResultDto product);

    String deleteProduct(Long id);
}
