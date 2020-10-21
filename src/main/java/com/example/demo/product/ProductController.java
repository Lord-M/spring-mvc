package com.example.demo.product;

import com.example.demo.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @RequestMapping("/list")
    public List<ProductDto> get(@RequestParam Optional<String[]> category) {
        List<ProductDto> productDtoList = productService.getList(category);
        System.out.println(productDtoList);
        return productDtoList;

//        String s = "";
//        if (category.isPresent()) {
//            for (String q : category.get()) {
//                s += q;
//            }
//        }
//        return String.format("Hello %s!", s);
    }
}
