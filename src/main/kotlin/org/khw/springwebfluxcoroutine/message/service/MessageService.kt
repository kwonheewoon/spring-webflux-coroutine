package org.khw.springwebfluxcoroutine.message.service


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import lombok.RequiredArgsConstructor
import org.khw.springwebfluxcoroutine.message.domain.dto.MessageSaveApiDto
import org.khw.springwebfluxcoroutine.message.domain.dto.MessageUpdateApiDto
import org.khw.springwebfluxcoroutine.message.domain.dto.MessageViewApiDto
import org.khw.springwebfluxcoroutine.message.domain.entity.Message
import org.khw.springwebfluxcoroutine.message.domain.entity.MessageFactory
import org.khw.springwebfluxcoroutine.message.domain.mapper.MessageMapper
import org.khw.springwebfluxcoroutine.message.repository.MessageRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
@RequiredArgsConstructor
class MessageService(
    val messageRepository: MessageRepository,
    val messageMapper: MessageMapper
){
    // 비동기 데이터 스트림 flow를 반환하니 suspend 필요 없을수도?
    fun findAllMessage(): Flow<Message> {
        return messageRepository.findAll().asFlow()
    }

    suspend fun saveMessage(messageSaveApiDto: MessageSaveApiDto): MessageViewApiDto {
        return messageMapper.entityToViewApiDto(messageRepository.save(MessageFactory.create(messageSaveApiDto))
            .awaitSingle())
    }

    suspend fun updateMessage(messageId: Long, messageUpdateApiDto: MessageUpdateApiDto): MessageViewApiDto {
        return messageRepository.findById(messageId).
            switchIfEmpty(Mono.error(IllegalStateException("존재하지 않는 메시지"))).
            flatMap { message ->
                message.update(messageUpdateApiDto)
                messageRepository.save(message)
            }
            .awaitSingle()
            .let { messageMapper.entityToViewApiDto(it) }
    }
}

