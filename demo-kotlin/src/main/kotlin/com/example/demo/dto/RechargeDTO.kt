package com.example.demo.dto

import lombok.ToString

import java.io.Serializable

@ToString
class RechargeDTO : Serializable {
    var userId: Long = 0
    var amount: Double = 0.0
}
