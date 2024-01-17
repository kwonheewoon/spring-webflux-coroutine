package org.khw.springwebfluxcoroutine.message.domain.entity

import org.khw.springwebfluxcoroutine.message.domain.dto.MessageSaveApiDto

class MessageFactory {
    companion object{
        fun create(messageSaveApiDto: MessageSaveApiDto): Message {
            return Message(text = messageSaveApiDto.text)
        }
    }
}