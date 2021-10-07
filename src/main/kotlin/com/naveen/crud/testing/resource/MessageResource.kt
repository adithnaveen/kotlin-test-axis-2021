package com.naveen.crud.testing.resource

import com.naveen.crud.testing.entity.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageResource {
    @GetMapping
    fun index(): List<Message> = listOf(
            Message("1", "Hello!"),
            Message("2", "Bonjour!"),
            Message("3", "Privet!")
    )
}
