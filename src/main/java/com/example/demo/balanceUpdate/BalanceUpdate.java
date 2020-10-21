package com.example.demo.balanceUpdate;

import com.example.demo.account.Account;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "balance_updates")
public class BalanceUpdate {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(precision = 12, scale = 4)
    BigDecimal balance;

    @Column(name ="`timestamp`")
    @CreationTimestamp
    Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH, CascadeType.MERGE, })
    @JoinColumn(name = "account_id")
    Account account;
}
