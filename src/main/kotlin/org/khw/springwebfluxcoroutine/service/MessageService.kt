package org.khw.springwebfluxcoroutine.service


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import lombok.RequiredArgsConstructor
import org.khw.springwebfluxcoroutine.domain.dto.MessageSaveApiDto
import org.khw.springwebfluxcoroutine.domain.dto.MessageViewApiDto
import org.khw.springwebfluxcoroutine.domain.entity.Message
import org.khw.springwebfluxcoroutine.domain.entity.MessageFactory
import org.khw.springwebfluxcoroutine.domain.mapper.MessageMapper
import org.khw.springwebfluxcoroutine.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class MessageService(
    val messageRepository: MessageRepository,
    val messageMapper: MessageMapper
){
    suspend fun findAllMessage(): Flow<Message> {
        return messageRepository.findAll().asFlow()
    }

    suspend fun saveMessage(messageSaveApiDto: MessageSaveApiDto): MessageViewApiDto{
        return messageMapper.entityToViewApiDto(messageRepository.save(MessageFactory.create(messageSaveApiDto))
            .awaitSingle())
    }
}

