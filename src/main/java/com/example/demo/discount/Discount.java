package com.example.demo.discount;

import com.example.demo.product.Product;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id")
    Product product;

    BigDecimal valueDecimal;

    String description;

    Date startFrom;
    Date dueTo;

    @Column(name = "`timestamp`", columnDefinition = "timestamp default current_timestamp")
    @CreationTimestamp
    Date createdAt;
}
