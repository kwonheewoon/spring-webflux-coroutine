package org.khw.springwebfluxcoroutine.message.repository

import org.khw.springwebfluxcoroutine.message.domain.entity.Message
import org.springframework.data.repository.reactive.ReactiveCrudRepository


interface MessageRepository : ReactiveCrudRepository<Message, Long>