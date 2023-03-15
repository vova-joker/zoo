package com.example.zoo.controller;

import com.example.zoo.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import zoo.api.ProductApi;
import zoo.dto.ProductPostDto;
import zoo.dto.ProductResultDto;

import java.util.List;

@RestController
@Api(tags = {"product"})
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;
    @Override
    public ResponseEntity<ProductResultDto> addProduct(ProductPostDto productPostDto) {
        return ResponseEntity.ok(productService.addProduct(productPostDto));
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @Override
    public ResponseEntity<List<ProductResultDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Override
    public ResponseEntity<ProductResultDto> getProductById(Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Override
    public ResponseEntity<ProductResultDto> updateProduct(ProductResultDto productResultDto) {
        return ResponseEntity.ok(productService.updateProduct(productResultDto));
    }
}
