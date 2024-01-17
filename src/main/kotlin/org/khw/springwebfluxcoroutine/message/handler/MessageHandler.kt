package org.khw.springwebfluxcoroutine.message.handler

import kotlinx.coroutines.reactor.awaitSingle
import lombok.RequiredArgsConstructor
import org.khw.springwebfluxcoroutine.message.domain.dto.MessageSaveApiDto
import org.khw.springwebfluxcoroutine.message.domain.dto.MessageUpdateApiDto
import org.khw.springwebfluxcoroutine.message.service.MessageService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
@RequiredArgsConstructor
class MessageHandler(val messageService: MessageService) {

    suspend fun findAllMessage(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().bodyAndAwait(messageService.findAllMessage())
    }

    suspend fun saveMessage(request: ServerRequest): ServerResponse{
        return ServerResponse.ok().bodyValueAndAwait(
            messageService.saveMessage(
                request.bodyToMono(MessageSaveApiDto::class.java).awaitSingle()
            )
        )
    }

    suspend fun updateMessage(request: ServerRequest): ServerResponse{
        return ServerResponse.ok().bodyValueAndAwait(
            messageService.updateMessage(
                request.pathVariable("messageId").toLong()
                ,request.bodyToMono(MessageUpdateApiDto::class.java).awaitSingle()
            )
        )
    }
}