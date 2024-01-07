package org.khw.springwebfluxcoroutine.handler

import kotlinx.coroutines.flow.toList
import lombok.RequiredArgsConstructor
import org.khw.springwebfluxcoroutine.service.MessageService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
@RequiredArgsConstructor
class MessageHandler(val messageService: MessageService) {

     suspend fun findAllMessage(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(messageService.findAllMessage().toList())
    }
}