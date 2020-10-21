package com.example.demo.product;

import com.example.demo.product.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product dtoToProduct(ProductDto productDto);

    ProductDto productToDto(Product product);
}
