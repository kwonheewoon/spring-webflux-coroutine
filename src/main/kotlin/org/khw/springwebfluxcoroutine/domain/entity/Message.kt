package org.khw.springwebfluxcoroutine.domain.entity

import org.khw.springwebfluxcoroutine.domain.dto.MessageUpdateApiDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("test.messages")
class Message(
    id: Long? = null,
    text: String
){

    @Id
    val id: Long? = id

    var text = text
    fun update(messageUpdateApiDto: MessageUpdateApiDto){
        this.text = messageUpdateApiDto.text
    }
}