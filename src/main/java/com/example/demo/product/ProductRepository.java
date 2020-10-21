package com.example.demo.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByCategory_NameInIgnoreCase(String[] categories);

//    List<>
}
