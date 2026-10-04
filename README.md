# Asset Hub

Asset Hub is a Spring Boot REST API for keeping track of company hardware: who has which laptop, which items are free, and which are in the repair shop. The main rule it enforces is simple: an asset can never be allocated to two people at once.

I also used this project to practice a few things I wanted to get right, such as transactional operations, proper validation, consistent error responses, and versioned database migrations with Flyway.

---

## What it does

- **Tracks inventory.** Every asset has a status (`AVAILABLE`, `ALLOCATED` or `MAINTENANCE`), and assets are linked to departments and employees.
- **Keeps allocations consistent.** Checking an asset out or returning it runs inside a single transaction, so an asset's status and its allocation record can't drift apart.
- **Rejects bad requests early.** Incoming payloads are validated in the controller layer with Jakarta Validation. Missing IDs, return dates in the past and similar mistakes get caught before they reach the service layer.
- **Returns clean errors.** A `@RestControllerAdvice` handler turns domain exceptions like `ResourceNotFoundException` and `InvalidAllocationStateException` into readable JSON with the right status code (`404` or `400`).
- **Leaves the schema to Flyway.** Hibernate's `ddl-auto=update` is off. The schema comes from versioned SQL scripts, and Hibernate only checks it at startup (`ddl-auto=validate`).

---

## Tech stack

| Area | Tools |
| :--- | :--- |
| Framework | Spring Boot 4.x, Java 21+ |
| Persistence | Spring Data JPA / Hibernate |
| Database | H2 (in-memory, for local use) |
| Migrations | Flyway |
| API docs | SpringDoc OpenAPI 3 / Swagger UI |
| Testing | JUnit 5, Mockito |

---

## Database migrations

All schema changes live in `src/main/resources/db/migration/`.

| Script | What it does |
| :--- | :--- |
| `V1__create_initial_schema.sql` | Creates the base tables: `departments`, `users`, `asset_categories`, `assets` and `asset_allocations` |

On startup, Hibernate checks the entities against these tables (`spring.jpa.hibernate.ddl-auto=validate`). If something doesn't match, the app refuses to start.

---

## Running it locally

You'll need Java 21 or newer. Maven is optional because the project includes the Maven wrapper.

1. Clone the repo:

   ```bash
   git clone https://github.com/<your-username>/asset-hub.git
   cd asset-hub
   ```

2. Run the tests:

   ```bash
   ./mvnw clean test
   ```

3. Start the app:

   ```bash
   ./mvnw spring-boot:run
   ```

The app runs on port `8080`. On boot it seeds a little sample data (an IT department, a user and a laptop) so you have something to play with right away.

---

## Trying the API

Once the app is running, you can explore and call every endpoint from your browser:

- **Swagger UI:** http://localhost:8080/swagger-ui/index.html
- **Raw OpenAPI JSON:** http://localhost:8080/v3/api-docs

---

## Progress

**Done**

- [x] Transactional checkout and return flows
- [x] Input validation and global exception handling
- [x] Service-layer tests with JUnit 5 and Mockito
- [x] Interactive API docs with Swagger UI
- [x] Flyway migrations with Hibernate schema validation

**Up next**

- [ ] Workspace and desk allocation
- [ ] Authentication and role-based access control (Spring Security + JWT)
- [ ] Docker Compose setup with PostgreSQL
