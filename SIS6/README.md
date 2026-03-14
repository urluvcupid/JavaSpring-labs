# Lab 6 — Kafka Social Media Backend

This lab contains two Spring Boot services:
- `post-service`
- `feed-service`

## What was implemented
- `post-service` creates posts, saves them to PostgreSQL and sends Kafka events
- `feed-service` consumes events and saves feed items
- `notification-group` also consumes the same events and saves notifications
- Flyway migrations
- Swagger/OpenAPI
- PostgreSQL + Kafka in Docker


## How to run

docker run -d --name social-postgres \
-p 5433:5432 \
-e POSTGRES_DB=social_post_db \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=datebayo01399 \
postgres:15

docker exec -it social-postgres psql \
-U postgres \
-d social_post_db \
-c "CREATE DATABASE social_feed_db;"

docker run -d --name kafka \
-p 9092:9092 \
-e KAFKA_NODE_ID=1 \
-e KAFKA_PROCESS_ROLES=broker,controller \
-e KAFKA_CONTROLLER_QUORUM_VOTERS=1@localhost:9093 \
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092,CONTROLLER://0.0.0.0:9093 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
-e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,CONTROLLER:PLAINTEXT \
-e KAFKA_CONTROLLER_LISTENER_NAMES=CONTROLLER \
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
-e CLUSTER_ID=Mk3OEYBSD34fcwNTJENDLw \
confluentinc/cp-kafka:7.5.0