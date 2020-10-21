package com.example.demo.product;

import com.example.demo.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> getList(Optional<String[]> categories) {
        List<Product> products;
        if (categories.isPresent()) {
            products = productRepository.findByCategory_NameInIgnoreCase(categories.get());
        } else {
            products = new ArrayList<>();
            productRepository.findAll().forEach(products::add);
        }
        List<ProductDto> productsDto = products.stream().map(p -> ProductMapper.MAPPER.productToDto(p)).collect(Collectors.toList());
        return productsDto;
    }
}
