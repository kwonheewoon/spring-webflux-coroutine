package org.khw.springwebfluxcoroutine.repository

import org.khw.springwebfluxcoroutine.domain.Message
import org.springframework.data.repository.reactive.ReactiveCrudRepository


interface MessageRepository : ReactiveCrudRepository<Message, Long>