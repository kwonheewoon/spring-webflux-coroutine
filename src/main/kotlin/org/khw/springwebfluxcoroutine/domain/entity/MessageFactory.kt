package org.khw.springwebfluxcoroutine.domain.entity

import org.khw.springwebfluxcoroutine.domain.dto.MessageSaveApiDto

class MessageFactory {
    companion object{
        fun create(messageSaveApiDto: MessageSaveApiDto): Message{
            return Message(text = messageSaveApiDto.text)
        }
    }
}