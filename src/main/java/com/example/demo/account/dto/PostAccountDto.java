package com.example.demo.account.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PostAccountDto {
    Long id;
    String userName;
    Date createdAt;
    BigDecimal balance;
}
