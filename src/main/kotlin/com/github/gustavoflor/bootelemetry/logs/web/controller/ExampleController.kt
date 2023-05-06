package com.github.gustavoflor.bootelemetry.logs.web.controller

import com.github.gustavoflor.bootelemetry.logs.web.HttpHeaders
import net.logstash.logback.argument.StructuredArguments.kv
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime.now

@RestController
@RequestMapping("/v1/examples")
class ExampleController {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun example(
        @RequestHeader(HttpHeaders.ORIGIN_ID_HEADER) originId: String,
        @RequestHeader(HttpHeaders.ORIGIN_NAME_HEADER) originName: String
    ) {
        MDC.putCloseable(HttpHeaders.ORIGIN_ID_HEADER, originId).use {
            logger.info("Hello World for {} at {}", kv(HttpHeaders.ORIGIN_NAME_HEADER, originName), now())
            it.close()
        }
    }

}