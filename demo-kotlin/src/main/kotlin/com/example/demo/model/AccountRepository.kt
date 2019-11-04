package com.example.demo.model

import org.springframework.data.repository.CrudRepository

interface AccountRepository : CrudRepository<Account, Long> {

    fun findOneByUserId(userId: Long?): Account
}
