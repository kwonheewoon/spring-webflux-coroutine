package org.khw.springwebfluxcoroutine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
class SpringWebfluxCoroutineApplication

fun main(args: Array<String>) {
    runApplication<SpringWebfluxCoroutineApplication>(*args)
}
