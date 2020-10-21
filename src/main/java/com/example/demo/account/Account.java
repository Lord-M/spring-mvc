package com.example.demo.account;

import com.example.demo.balanceUpdate.BalanceUpdate;
import com.example.demo.productPurchase.ProductPurchase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String userName;

    @Column(precision = 12, scale = 4)
    BigDecimal balance;

    @Column(name = "`timestamp`", columnDefinition = "timestamp default current_timestamp")
    @CreationTimestamp
    Date createdAt;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<BalanceUpdate> balanceUpdateList;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductPurchase> productPurchaseList;
}
