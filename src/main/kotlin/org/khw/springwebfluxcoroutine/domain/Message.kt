package org.khw.springwebfluxcoroutine.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("test.messages")
data class Message(@Id val id: Long, val text: String)