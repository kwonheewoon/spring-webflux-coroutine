package org.khw.springwebfluxcoroutine.service


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import lombok.RequiredArgsConstructor
import org.khw.springwebfluxcoroutine.domain.Message
import org.khw.springwebfluxcoroutine.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class MessageService(val messageRepository: MessageRepository){
    suspend fun findAllMessage(): Flow<Message> {
        return messageRepository.findAll().asFlow()
    }
}

