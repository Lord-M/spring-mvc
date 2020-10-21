package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
//    List<ProductCategory> findByName()
}
