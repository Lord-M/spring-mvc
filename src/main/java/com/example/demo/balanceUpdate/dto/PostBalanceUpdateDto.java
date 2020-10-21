package com.example.demo.balanceUpdate.dto;

import com.example.demo.account.dto.PostAccountDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PostBalanceUpdateDto {
    Long id;
    BigDecimal balance;
    Date createdAt;
    PostAccountDto account;
}
