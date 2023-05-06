package com.github.gustavoflor.bootelemetry.logs.web.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.http.HttpHeaders

class ExampleFilter: Filter {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val locale = request?.locale?.displayName ?: StringUtils.EMPTY
        MDC.putCloseable(HttpHeaders.ACCEPT_LANGUAGE, locale).use {
            if (locale.isNotBlank()) {
                logger.info("Accepting request for {} language", locale)
            }
            chain?.doFilter(request, response)
            it.close()
        }
    }

}