package com.github.gustavoflor.bootelemetry.logs.web.config

import com.github.gustavoflor.bootelemetry.logs.web.filter.ExampleFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {

    @Bean
    fun exampleFilterRegistrationBean(): FilterRegistrationBean<ExampleFilter> {
        val exampleFilterRegistrationBean = FilterRegistrationBean<ExampleFilter>()
        exampleFilterRegistrationBean.filter = ExampleFilter()
        return exampleFilterRegistrationBean
    }

}