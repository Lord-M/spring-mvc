package com.example.demo.balanceUpdate;

import com.example.demo.balanceUpdate.dto.PostBalanceUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @Autowired
    BalanceUpdateService balanceUpdateService;

    @PostMapping
    @RequestMapping("/add_money")
    public PostBalanceUpdateDto post(@RequestBody PostBalanceUpdateDto balanceUpdate) {
        System.out.println(balanceUpdate);
        PostBalanceUpdateDto savedBalanceUpdate = balanceUpdateService.create(balanceUpdate);
        System.out.println(savedBalanceUpdate);
//        return String.format("Hello %s!", savedBalanceUpdate.);
        return savedBalanceUpdate;
    }
}
