package com.example.demo.service;

import com.example.demo.dto.RechargeDTO;
import com.example.demo.model.Account;
import com.example.demo.model.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    AccountRepository accountRepository;

    @Transactional
    public Account recharge(RechargeDTO rechargeDTO) {
        return this.updateBalance(rechargeDTO.userId, rechargeDTO.amount, "recharge");
    }

    public Account updateBalance(Long userId, double amount, String type) {
        Account account = accountRepository.findOneByUserId(userId);
        if (account == null) {
            account = new Account();
            account.setBalance(0d);
            account.setUserId(userId);
            account = accountRepository.save(account);
        }
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        return account;
    }
}
