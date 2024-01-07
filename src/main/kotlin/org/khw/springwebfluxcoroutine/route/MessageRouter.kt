package org.khw.springwebfluxcoroutine.route

import org.khw.springwebfluxcoroutine.handler.MessageHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class MessageRouter{
    @Bean
    fun personRoutes(handler: MessageHandler) = coRouter {
        "/messages".nest {
            GET("", handler::findAllMessage)
        }
    }
}
