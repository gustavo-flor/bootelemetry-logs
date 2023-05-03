# Bootelemetry Logs

App to test usage of OpenTelemetry with logs exporter and javaagent.

## Dependencies

- Docker

## Deployment

Run this command to up the application and its dependencies

```shell
docker-compose up -d --build
```

- Application available at http://localhost:8080
- Grafana available at http://localhost:3000 (add Loki data source to visualize)
- Loki available at http://localhost:3100

## Loki Grafana

Use this query to visualize the logs generate by the application

```jsonpath
{exporter="OTLP"} | json | line_format `{{.body}}`
```
