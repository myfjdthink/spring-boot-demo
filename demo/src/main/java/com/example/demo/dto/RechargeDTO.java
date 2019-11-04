package com.example.demo.dto;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class RechargeDTO implements Serializable {
    public Long userId;
    public Double amount;
}
