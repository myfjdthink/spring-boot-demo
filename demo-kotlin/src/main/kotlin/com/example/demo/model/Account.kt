package com.example.demo.model

import javax.persistence.*

@Entity
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = -1
    var userId: Long? = -1
    var balance: Double? = null
    @Version
    var version: Int? = 0
}
