package com.example.demo.productPurchase.dto;

import com.example.demo.product.dto.ProductDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPurchaseDto {
    ProductDto product;
    BigDecimal pricePerItem;
    int quantity;
}
