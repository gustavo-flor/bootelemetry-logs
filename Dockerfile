FROM gradle:7.6.1-jdk17 AS build

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src

RUN gradle build --no-daemon --info

FROM openjdk:17-slim AS release

COPY --from=build /home/gradle/build/libs/*.jar /app.jar
COPY docker-entrypoint.sh /
COPY otel/otel-javaagent.jar /

RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]