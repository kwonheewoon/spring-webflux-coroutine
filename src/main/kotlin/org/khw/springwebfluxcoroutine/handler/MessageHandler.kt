package org.khw.springwebfluxcoroutine.handler

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactor.awaitSingle
import lombok.RequiredArgsConstructor
import org.khw.springwebfluxcoroutine.domain.dto.MessageSaveApiDto
import org.khw.springwebfluxcoroutine.domain.mapper.MessageMapper
import org.khw.springwebfluxcoroutine.service.MessageService
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
}