package com.example.demo.controller;

import com.example.demo.dto.RechargeDTO;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(tags = "用户账户相关接口", description = "提供用户账户相关的 Rest API")
@RequestMapping("api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public boolean addUser(@Valid Account account) {
        return false;
    }

    @GetMapping("/find/{id}")
    public Account findById(@PathVariable("id") int id) {
        return new Account();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Account account) {
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public Account recharge(@RequestBody RechargeDTO dto) {
        log.debug("debug recharge " + dto.userId + " amount: " + dto.amount);
        return accountService.recharge(dto);
    }
}
