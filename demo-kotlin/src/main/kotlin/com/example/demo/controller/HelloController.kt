package com.example.demo.controller

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/")
class HelloController {
    private val logger = LoggerFactory.getLogger(HelloController::class.java)

    @RequestMapping("/hello/{name}")
    fun hello(@PathVariable(value = "name") name: String): String {
        logger.debug("get name is $name")
        return "Hello $name"
    }
}
