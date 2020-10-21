package com.example.demo.productPurchase;

import com.example.demo.account.Account;
import com.example.demo.product.Product;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "product_purchases")
public class ProductPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_id")
    Account account;

    int quantity;

    @Column(precision = 12, scale = 4)
    BigDecimal pricePerItem;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    Date createdAt;
}
