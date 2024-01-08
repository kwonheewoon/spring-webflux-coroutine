package org.khw.springwebfluxcoroutine.domain.mapper

import org.khw.springwebfluxcoroutine.domain.dto.MessageViewApiDto
import org.khw.springwebfluxcoroutine.domain.entity.Message
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MessageMapper {


    fun entityToViewApiDto(message: Message): MessageViewApiDto

    fun entityListToViewApiDtoList(message: List<Message>): List<MessageViewApiDto>
}