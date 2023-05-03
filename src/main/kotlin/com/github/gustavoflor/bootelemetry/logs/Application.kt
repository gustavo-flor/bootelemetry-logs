package com.github.gustavoflor.bootelemetry.logs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootelemetryLogsApplication

fun main(args: Array<String>) {
    runApplication<BootelemetryLogsApplication>(*args)
}
