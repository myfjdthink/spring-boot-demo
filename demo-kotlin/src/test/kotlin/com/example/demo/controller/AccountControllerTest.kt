package com.example.demo.controller

import com.example.demo.dto.RechargeDTO
import com.example.demo.model.Account
import com.example.demo.model.AccountRepository
import com.example.demo.model.AccountRepositoryTests
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import java.net.URL


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountControllerTest(
        @Autowired val restTemplate: TestRestTemplate,
        @Autowired var accountRepository: AccountRepository) {

    private val logger = LoggerFactory.getLogger(AccountRepositoryTests::class.java)

    @LocalServerPort
    private val port: Int = 0

    private lateinit var base: URL

    @BeforeAll
    fun setUp() {
        val url = String.format("http://localhost:%d/", port)
        logger.debug(String.format("port is : [%d]", port))
        this.base = URL(url)
    }


    @Test
    fun recharge() {
        val dto = RechargeDTO()
        dto.amount = 90.0
        dto.userId = 2L

        val response = this.restTemplate.postForEntity(
                this.base.toString() + "/api/v1/account/recharge", dto, Account::class.java)
        logger.debug(String.format("测试结果为：%s", response.body))

        val account = accountRepository.findOneByUserId(dto.userId)
        assertThat(account!!.balance).isEqualTo(90.0)
    }
}