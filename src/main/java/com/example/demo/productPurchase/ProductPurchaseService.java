package com.example.demo.productPurchase;

import com.example.demo.account.Account;
import com.example.demo.account.AccountMapper;
import com.example.demo.account.AccountRepository;
import com.example.demo.account.dto.AccountPurchasesDto;
import com.example.demo.discount.Discount;
import com.example.demo.discount.DiscountRepository;
import com.example.demo.product.Product;
import com.example.demo.product.ProductMapper;
import com.example.demo.product.ProductRepository;
import com.example.demo.product.dto.ProductDto;
import com.example.demo.productPurchase.dto.PostProductPurchaseDto;
import com.example.demo.productPurchase.dto.ProductPurchaseDto;
import com.example.demo.productPurchase.dto.ResponsePayloadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductPurchaseService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DiscountRepository discountRepository;

    public ResponseEntity<ResponsePayloadDto<AccountPurchasesDto>> purchase(PostProductPurchaseDto postDto) {
//        Map<Long, Integer> productsIdToQuantityMap = new HashMap<>();
//
//        for (ProductPurchaseDto productPurchaseDto: postDto.getProductPurchases()) {
//            Long productId = productPurchaseDto.getProduct().getId();
//            int quantity = productPurchaseDto.getQuantity();
//
//            int productQuantity = productsIdToQuantityMap.getOrDefault(productId, 0);
//            productsIdToQuantityMap.put(productId, productQuantity + quantity);
//        }
        Map<Long, Integer> productsIdToQuantityMap = getProductsIdToQuantityMap(postDto.getProductPurchases());

        Map<Long, Product> productMap = new HashMap<>();
        productRepository.findAllById(productsIdToQuantityMap.keySet())
            .forEach(p -> productMap.put(p.getId(), p));

        BigDecimal total = new BigDecimal("0");

        Set<Map.Entry<Long, Integer>> entrySet = productsIdToQuantityMap.entrySet();
        Map<Long, BigDecimal> productIdToDiscountTotalMap = new HashMap<>(entrySet.size(), 1f);
        // productIdToDiscountTotalMap

        for (Map.Entry<Long, Integer> entry: entrySet) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();

            Product product = productMap.get(productId);
            BigDecimal productPrice = product.getPrice();

            BigDecimal totalPriceForProduct = productPrice.multiply(BigDecimal.valueOf(quantity));
//            Discount discount = discountRepository.findFirstByProduct_IdAndStartFromLessThanEqualAndDueToGreaterThanEqualOrderByValueDecimalDesc(productId, new Date(), new Date());
            List<Discount> discounts = discountRepository.findActualDiscountsDescOrder(productId);
            discounts.stream().forEach(d -> System.out.println(d.getValueDecimal()));
//            System.out.println(discounts.get(0).getValueDecimal());

            if (!discounts.isEmpty()) {
                BigDecimal topActualDiscount = discounts.get(0).getValueDecimal();
                BigDecimal discountAmount = totalPriceForProduct.multiply(topActualDiscount);

                productIdToDiscountTotalMap.put(productId, discountAmount);
            }
//            BigDecimal priceWithDiscount = totalPriceForProduct.subtract(discountAmount);
            System.out.println("Price: " + totalPriceForProduct);
//            System.out.println("Price with discount: " + priceWithDiscount);

            // product id to (discount total)
            total = total.add(totalPriceForProduct);
        }

        Set<Map.Entry<Long, BigDecimal>> discountsSet = productIdToDiscountTotalMap.entrySet();
//        SortedSet<Map.Entry<Long, BigDecimal>> sortedSet = new TreeSet<>(discountsSet);
        SortedSet<Map.Entry<Long, BigDecimal>> sortedSet = new TreeSet<>(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        sortedSet.addAll(discountsSet);

        BigDecimal totalDiscount = sortedSet.stream().limit(3).map(e -> e.getValue()).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalPriceWithDiscount = total.subtract(totalDiscount);
        System.out.println("Total discount: " + totalDiscount);
        System.out.println("Total price: " + totalPriceWithDiscount);

        Optional<Account> foundAccount = accountRepository.findById(postDto.getAccount().getId());

        if (foundAccount.isPresent()) {
            Account account = foundAccount.get();
            BigDecimal currentBalance = account.getBalance();

            if (currentBalance.compareTo(totalPriceWithDiscount) > 0) {
                account.setBalance(currentBalance.subtract(totalPriceWithDiscount));

                Stream<ProductPurchase> newProductPurchasesStream = postDto.getProductPurchases()
                    .stream().map(p -> {
                        ProductPurchase productPurchase = ProductPurchaseMapper.MAPPER.dtoToProduct(p);
                        Product product = productMap.get(p.getProduct().getId());
                        BigDecimal pricePerItem = product.getPrice();
                        productPurchase.setPricePerItem(pricePerItem);
                        System.out.println("product-purchase" + productPurchase);
                        return productPurchase;
                    });

                List<ProductPurchase> accountProductPurchases = account.getProductPurchaseList();
                List<ProductPurchase> updatedProductPurchases = Stream.concat(
                    accountProductPurchases.stream(), newProductPurchasesStream
                ).collect(Collectors.toList());

                account.setProductPurchaseList(updatedProductPurchases);

                Account savedAccount = accountRepository.save(account);
                AccountPurchasesDto accountPurchasesDto = AccountMapper.MAPPER.accountToAccountPurchasesDto(savedAccount);
                System.out.println(accountPurchasesDto);
                return ResponsePayloadDto.of(accountPurchasesDto).toResponseEntity();
            }
        }

        sortedSet.stream().forEach(s -> System.out.println(s));

//                .stream().reduce(BigDecimal.ZERO, (bigDecimal, longIntegerEntry) -> {
//        });

        System.out.println("Total: " + total);

//        productsIdToQuantityMap.forEach((productId, quantity) -> {
//            Product product = productMap.get(productId);
//            BigDecimal productPrice = product.getPrice();
//
//            productPrice.multiply(BigDecimal.valueOf(quantity));
//
//            total = total.add(productPrice);total.add
//        });

//        System.out.println(productList.stream().map(Product::getProductName).collect(Collectors.toList()));
//        System.out.println(productList.stream().map(Product::getPrice).collect(Collectors.toList()));
        Account account = foundAccount.get();
//        account.setProductPurchaseList(postDto.getProductPurchases());

        AccountPurchasesDto response = AccountMapper.MAPPER.accountToAccountPurchasesDto(account);

        response.setProductPurchaseList(
            postDto.getProductPurchases().stream().map(s -> {
                Long productId = s.getProduct().getId();
                Product product = productMap.get(productId);
                ProductDto productDto = ProductMapper.MAPPER.productToDto(product);
                ProductPurchaseDto sCloned = ProductPurchaseMapper.MAPPER.dtoToDto(s);
                sCloned.setProduct(productDto);
                sCloned.setPricePerItem(productDto.getPrice());
                return sCloned;
            }).collect(Collectors.toList()));

        String notEnoughMoneyErrorMessage = "Not enough money to purchase selected items. Total price is: " + totalPriceWithDiscount;
        return ResponsePayloadDto.of(response, notEnoughMoneyErrorMessage).toResponseEntity();
    }

    private Map<Long, Integer> getProductsIdToQuantityMap(
        List<ProductPurchaseDto> productPurchases
    ) {
        Map<Long, Integer> map = new HashMap<>();

        for (ProductPurchaseDto productPurchaseDto: productPurchases) {
            Long productId = productPurchaseDto.getProduct().getId();
            int quantity = productPurchaseDto.getQuantity();

            int productQuantity = map.getOrDefault(productId, 0);
            map.put(productId, productQuantity + quantity);
        }
        return map;
    }

    private BigDecimal getPurchasesTotal() {
        return null;
    }
}
