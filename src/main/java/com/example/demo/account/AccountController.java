package com.example.demo.account;

import com.example.demo.account.dto.PostAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public PostAccountDto post(@RequestBody PostAccountDto account) {
        System.out.println(account);
        PostAccountDto response = accountService.create(account);
//        return String.format("Hello %s!", account.getUserName());
        return response;
    }

    public void updateBalance() {

    }

}
