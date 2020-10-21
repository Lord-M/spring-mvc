package com.example.demo.account;

import com.example.demo.account.dto.PostAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public PostAccountDto create(PostAccountDto accountDto) {
        Account account = AccountMapper.MAPPER.dtoToAccount(accountDto);
        System.out.println(account);
        Account savedAccount = accountRepository.save(account);
        PostAccountDto response = AccountMapper.MAPPER.accountToDto(savedAccount);
        System.out.println(response);
        return response;
    }
}
