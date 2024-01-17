package org.khw.springwebfluxcoroutine.blog.route

import org.khw.springwebfluxcoroutine.blog.handler.BlogHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class BlogSearchRouter{

    @Bean
    fun blogRoutes(handler: BlogHandler) = coRouter {
        "/blogs".nest {
           GET("/{portalType}", handler::searchBlogPost)
        }
    }
}
