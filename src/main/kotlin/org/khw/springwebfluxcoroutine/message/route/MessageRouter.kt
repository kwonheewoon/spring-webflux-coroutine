package org.khw.springwebfluxcoroutine.message.route

import org.khw.springwebfluxcoroutine.message.handler.MessageHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class MessageRouter{
    @Bean
    fun messageRoutes(handler: MessageHandler) = coRouter {
        "/messages".nest {
            GET("", handler::findAllMessage)
            POST("", handler::saveMessage)
            PUT("/{messageId}", handler::updateMessage)
        }
    }
}
