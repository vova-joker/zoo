package com.example.zoo.mapper;

import com.example.zoo.entity.Product;
import org.mapstruct.Mapper;
import zoo.dto.ProductPostDto;
import zoo.dto.ProductResultDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResultDto mapProductToDto(Product product);

    List<ProductResultDto> mapListOfProductsToListDto(List<Product> products);

    Product mapProductDtoToProduct(ProductResultDto productResultDto);

    Product mapProductDtoToProduct(ProductPostDto productResultDto);

    List<Product> mapListOfProductDtoToListOfProducts(List<ProductResultDto> productResultDtos);


}
