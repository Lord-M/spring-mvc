package com.example.demo.productPurchase;

import com.example.demo.product.Product;
import com.example.demo.product.dto.ProductDto;
import com.example.demo.productPurchase.dto.PostProductPurchaseDto;
import com.example.demo.productPurchase.dto.ProductPurchaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPurchaseMapper {
    ProductPurchaseMapper MAPPER = Mappers.getMapper(ProductPurchaseMapper.class);

    ProductPurchase dtoToProduct(ProductPurchaseDto postDto);

    ProductPurchaseDto dtoToDto(ProductPurchaseDto postDto);

    ProductPurchaseDto productToDto(ProductPurchase productPurchase);
}
