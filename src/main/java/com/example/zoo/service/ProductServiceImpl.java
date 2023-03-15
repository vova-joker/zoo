package com.example.zoo.service;

import com.example.zoo.entity.Product;
import com.example.zoo.mapper.ProductMapper;
import com.example.zoo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoo.dto.ProductPostDto;
import zoo.dto.ProductResultDto;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResultDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id = " + id + " is not found!"));
        return productMapper.mapProductToDto(product);
    }

    @Override
    public List<ProductResultDto> getAllProducts() {

        return productMapper.mapListOfProductsToListDto(productRepository.findAll());
    }

    @Override
    public ProductResultDto addProduct(ProductPostDto productPostDto) {
        Product product = productRepository.saveAndFlush(productMapper.mapProductDtoToProduct(productPostDto));
        return productMapper.mapProductToDto(product);
    }

    @Override
    public ProductResultDto updateProduct(ProductResultDto productResultDto) {
        Product product = productRepository.saveAndFlush(productMapper.mapProductDtoToProduct(productResultDto));
        return productMapper.mapProductToDto(product);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id = " + id + " is not found!"));;
        productRepository.delete(product);
        return "Product with name " + product.getName() + " was successfully deleted!";
    }
}
