package com.example.demo.service

import com.example.demo.dto.RechargeDTO
import com.example.demo.model.Account
import com.example.demo.model.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import javax.annotation.Resource

@Service
class AccountService {

    @Resource
    internal lateinit var accountRepository: AccountRepository

    @Transactional
    fun recharge(rechargeDTO: RechargeDTO): Account {
        return this.updateBalance(rechargeDTO.userId, rechargeDTO.amount, "recharge")
    }

    fun updateBalance(userId: Long?, amount: Double, type: String): Account {
        var account: Account? = accountRepository.findOneByUserId(userId)
        if (account == null) {
            account = Account()
            account.balance = 0.0
            account.userId = userId
            account = accountRepository.save(account)
        }
        account.balance = account.balance!! + amount
        accountRepository.save(account)
        return account
    }
}
