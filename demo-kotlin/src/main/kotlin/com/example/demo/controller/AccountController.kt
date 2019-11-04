package com.example.demo.controller

import com.example.demo.dto.RechargeDTO
import com.example.demo.model.Account
import com.example.demo.service.AccountService
import io.swagger.annotations.Api
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@Slf4j
@RestController
@Api(tags = ["用户账户相关接口"], description = "提供用户账户相关的 Rest API")
@RequestMapping("api/v1/account")
class AccountController {

    private val logger = LoggerFactory.getLogger(AccountController::class.java)

    @Autowired
    private lateinit var accountService: AccountService

    @PostMapping("/add")
    fun addUser(@Valid account: Account): Boolean {
        return false
    }

    @GetMapping("/find/{id}")
    fun findById(@PathVariable("id") id: Int): Account {
        return Account()
    }

    @PutMapping("/update")
    fun update(@RequestBody account: Account): Boolean {
        return true
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Int): Boolean {
        return true
    }

    @RequestMapping(value = "/recharge", method = [RequestMethod.POST])
    fun recharge(@RequestBody dto: RechargeDTO): Account {
        logger.debug("debug recharge " + dto.userId + " amount: " + dto.amount)
        return accountService.recharge(dto)
    }
}
