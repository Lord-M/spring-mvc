package com.example.demo.product;

import com.example.demo.discount.Discount;
import com.example.demo.productPurchase.ProductPurchase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String productName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    ProductCategory category;

    @Column(precision = 12, scale = 4)
    BigDecimal price;

    @Column(name = "`timestamp`", columnDefinition = "timestamp default current_timestamp")
    @CreationTimestamp
    Date createdAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductPurchase> productPurchaseList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Discount> discountList;
}
