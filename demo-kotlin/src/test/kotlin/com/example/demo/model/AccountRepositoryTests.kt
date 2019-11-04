package com.example.demo.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccountRepositoryTests {

    private val logger = LoggerFactory.getLogger(AccountRepositoryTests::class.java)

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun `jpa test "`() {

        val account = Account()

        account.balance = 30.0
        account.userId = 12
        accountRepository.save(account)

        logger.info("总共用户: ${accountRepository.count()}")

        var account1 = accountRepository.findOneByUserId(12)

        logger.info("find : $account1")
        Assertions.assertThat(account1.balance).isEqualTo(30.0)
    }
}