package com.example.demo.product.dto;

import com.example.demo.account.dto.PostAccountDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDto {
    Long id;
    String productName;
    BigDecimal price;
    Date createdAt;
    ProductCategoryDto category;
}
