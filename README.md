# Ride Booking Microservices (Java 17 / Spring Boot 3)

## Requirements
- JDK 17+
- Maven 3.9+
- Docker with Docker Compose

## Run
1. Start Kafka and ZooKeeper from the project root: `docker compose up -d`.
2. Build all modules: `mvn clean package`.
3. In separate terminals, from the project root run:
   - `mvn -pl rider-service -am spring-boot:run`
   - `mvn -pl ride-service -am spring-boot:run`
   - `mvn -pl driver-service -am spring-boot:run`
   - `mvn -pl notification-service -am spring-boot:run`

Run the Maven commands in the order above after the root build has installed the reactor artifacts locally. If running from the root with `-pl`, add `-am` where needed: `mvn -pl rider-service -am spring-boot:run`.

## Seed a driver
`POST http://localhost:8082/api/drivers`
```json
{"name":"Asha Driver"}
```

## Request a ride
`POST http://localhost:8081/api/riders/rides` with `Content-Type: application/json`:
```json
{"riderId":1,"pickup":"PESCE Mandya","dropoff":"Mysuru Bus Stand"}
```
The response is HTTP 202 with an event ID. The flow is asynchronous. Check `GET http://localhost:8083/api/rides` for the created ride and watch the driver/notification service logs.

## Check drivers and rides
- `GET http://localhost:8082/api/drivers`
- `PATCH http://localhost:8082/api/drivers/1/status` with `{"status":"AVAILABLE"}` to make a driver available again.
- `GET http://localhost:8083/api/rides`
- `GET http://localhost:8083/api/rides/1`

H2 console is enabled on each service at `/h2-console`; JDBC URL is shown in each service's `application.properties`, username `sa`, blank password.

## Design notes and limitations
- Rider and ride outboxes persist the event and business write in one local database transaction. The publisher marks records published after Kafka acknowledges the send. A crash between Kafka acknowledgement and marking the row can cause redelivery; downstream idempotency is therefore required.
- Ride and driver consumers use `processed_events` keys for deduplication. Ride request and ride-created event IDs are stable UUIDs. Driver assignment publishes directly to Kafka as requested; its DB transaction and Kafka send are not atomic, so this baseline is not a full distributed transaction.
- Fare uses a deterministic placeholder distance heuristic based on the pickup/dropoff strings because no geocoding/routing provider was specified. Replace `estimateDistance` with a real distance service before production.
- This is a runnable learning baseline, not production hardened. For concurrent driver assignment, use database locking/optimistic versioning and consider Kafka retry/DLT policies, authentication, observability, and schema evolution.
