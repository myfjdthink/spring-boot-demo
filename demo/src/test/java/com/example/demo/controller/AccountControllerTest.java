package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dto.RechargeDTO;
import com.example.demo.model.Account;
import com.example.demo.model.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }


    @Test
    public void recharge() {
        RechargeDTO dto = new RechargeDTO();
        dto.amount = 90.0;
        dto.userId = 2L;

        ResponseEntity<Account> response = this.restTemplate.postForEntity(
                this.base.toString() + "/api/v1/account/recharge", dto, Account.class);
        System.out.println(String.format("测试结果为：%s", response.getBody()));

        Account account = accountRepository.findOneByUserId(dto.userId);
        assertThat(account).extracting(Account::getBalance).isEqualTo(90.0);
    }
}