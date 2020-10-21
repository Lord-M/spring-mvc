package com.example.demo.productPurchase.dto;

import com.example.demo.account.dto.PostAccountDto;
import lombok.Data;

import java.util.List;

@Data
public class PostProductPurchaseDto {
    PostAccountDto account;
    List<ProductPurchaseDto> productPurchases;
}
