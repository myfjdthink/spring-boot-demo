package com.example.demo.controller;

import com.example.demo.dto.RechargeDTO;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public Account recharge(@RequestBody RechargeDTO dto) {
        log.debug("debug recharge " + dto.userId + " amount: " + dto.amount);
        return accountService.recharge(dto);
    }
}
