package org.khw.springwebfluxcoroutine.message.domain.mapper

import org.khw.springwebfluxcoroutine.message.domain.dto.MessageViewApiDto
import org.khw.springwebfluxcoroutine.message.domain.entity.Message
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MessageMapper {


    fun entityToViewApiDto(message: Message): MessageViewApiDto

    fun entityListToViewApiDtoList(message: List<Message>): List<MessageViewApiDto>
}