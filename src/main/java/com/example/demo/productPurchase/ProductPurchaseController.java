package com.example.demo.productPurchase;

import com.example.demo.account.dto.AccountPurchasesDto;
import com.example.demo.productPurchase.dto.PostProductPurchaseDto;
import com.example.demo.productPurchase.dto.ProductPurchaseDto;
import com.example.demo.productPurchase.dto.ResponsePayloadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/purchases")
public class ProductPurchaseController {

    @Autowired
    ProductPurchaseService productPurchaseService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ResponsePayloadDto<AccountPurchasesDto>> post(@RequestBody PostProductPurchaseDto postDto) {
//        BigDecimal total = postDto.getProductPurchases().stream().reduce()
//        Map<Long, Integer> q = postDto.getProductPurchases().stream()
//            .collect(Collectors.toMap(
//                p -> p.getProduct().getId(),
//                p -> p,
//                (p1, p2) -> {; }
//            ))

//        Map<Long, Integer> productsIdToQuantityMap = new HashMap<>();
//        for (ProductPurchaseDto productPurchaseDto: postDto.getProductPurchases()) {
//            Long productId = productPurchaseDto.getProduct().getId();
//            int quantity = productPurchaseDto.getQuantity();
//
//            int productQuantity = productsIdToQuantityMap.getOrDefault(productId, 0);
//            productsIdToQuantityMap.put(productId, productQuantity + quantity);
//        }

//        System.out.println(productsIdToQuantityMap);
        System.out.println(postDto);

//        ResponsePayloadDto<AccountPurchasesDto> responsePayloadDto = productPurchaseService.purchase(postDto);
        ResponseEntity<ResponsePayloadDto<AccountPurchasesDto>> response = productPurchaseService.purchase(postDto);
        return response;

//        return String.format("Hello %s!", postDto.getAccount().getUserName());
//        if (accountPurchasesDto.isPresent()) {
//            System.out.println("account-purchases-dto: " + accountPurchasesDto.get());
//            return ResponseEntity.ok(accountPurchasesDto.get());
//        } else {
//            // System.out.println("account-purchases-dto:" + accountPurchasesDto.get());
//            return ResponseEntity.badRequest().body(postDto);
//        }
    }
}
