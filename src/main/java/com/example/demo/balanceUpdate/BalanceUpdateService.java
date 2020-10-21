package com.example.demo.balanceUpdate;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.balanceUpdate.dto.PostBalanceUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BalanceUpdateService {

    @Autowired
    BalanceUpdateRepository balanceUpdateRepository;

    @Autowired
    AccountRepository accountRepository;

    public PostBalanceUpdateDto create(PostBalanceUpdateDto balanceUpdateDto) {
        Optional<Account> foundAccount = accountRepository.findById(balanceUpdateDto.getAccount().getId());
        // System.out.println(foundAccount);

        if (foundAccount.isPresent()) {
            Account account = foundAccount.get();
            // System.out.println(account);

            BigDecimal balanceUpdateValue = balanceUpdateDto.getBalance();
            BigDecimal accountBalance = account.getBalance();
            BigDecimal updatedBalance = (accountBalance == null) ? balanceUpdateValue : accountBalance.add(balanceUpdateValue);

            account.setBalance(updatedBalance);
//            accountRepository.save(account);
            // System.out.println(account);

//            balanceUpdateDto.getAccount().setBalance(updatedBalance);

            // System.out.println(balanceUpdateDto);
            BalanceUpdate balanceUpdate = BalanceUpdateMapper.MAPPER.dtoToBalanceUpdate(balanceUpdateDto);

            balanceUpdate.setAccount(account);

//            System.out.println(balanceUpdate);
            BalanceUpdate balanceUpdateSaved = balanceUpdateRepository.save(balanceUpdate);
            System.out.println(balanceUpdateSaved.getAccount().getBalance());
            PostBalanceUpdateDto response = BalanceUpdateMapper.MAPPER.balanceUpdateToDto(balanceUpdateSaved);
            System.out.println(response.getAccount());
            return response;
        }

        return balanceUpdateDto;
    }
}
