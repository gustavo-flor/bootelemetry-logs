#!/bin/sh

export OTEL_SERVICE_NAME=bootelemetry-logs
export OTEL_LOGS_EXPORTER=otlp
export OTEL_TRACES_EXPORTER=none
export OTEL_METRICS_EXPORTER=none

exec java -javaagent:./otel-javaagent.jar $1 -jar app.jar