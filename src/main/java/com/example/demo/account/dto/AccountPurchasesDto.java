package com.example.demo.account.dto;

import com.example.demo.productPurchase.dto.ProductPurchaseDto;
import lombok.Data;

import java.util.List;

@Data
public class AccountPurchasesDto extends PostAccountDto {
    List<ProductPurchaseDto> productPurchaseList;
}
