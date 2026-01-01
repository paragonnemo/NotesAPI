# NotesAPI

A simple RESTful Notes API built with **Spring Boot** and **PostgreSQL**.  
This project was created as a learning and portfolio project to practice backend development concepts such as layered architecture, REST APIs, validation, persistence, and exception handling.

---

## Features

- CRUD operations for notes (Create, Read, Update, Delete)
- RESTful API design
- Pagination support for listing notes
- Input validation using Bean Validation (`jakarta.validation`)
- Global exception handling with meaningful HTTP responses
- Persistence using Spring Data JPA and PostgreSQL
- Configuration via environment variables (no secrets committed)

---

## Tech Stack

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
  - Spring Actuator
- **PostgreSQL**
- **Maven**
- **Hibernate**

---

## API Endpoints

Base path: `/api/notes`

| Method | Endpoint            | Description                  |
|------|---------------------|------------------------------|
| GET  | `/api/notes`        | Get all notes (paginated)    |
| GET  | `/api/notes/{id}`   | Get note by ID               |
| POST | `/api/notes`        | Create a new note            |
| PUT  | `/api/notes/{id}`   | Update an existing note      |
| DELETE | `/api/notes/{id}` | Delete a note                |

---

## Example Request (Create Note)

http
POST /api/notes
Content-Type: application/json

{
  "title": "My first note",
  "content": "This is a sample note."
}


## Configuration
Environment Variables

The application expects the following environment variables:

DB_URL
DB_USERNAME
DB_PASSWORD


Example values:

DB_URL=jdbc:postgresql://localhost:5432/notesdb
DB_USERNAME=postgres
DB_PASSWORD=postgres

application.properties

The real application.properties file is ignored and not committed.
An example file is provided:

src/main/resources/application.properties.example


This file shows the required configuration using environment variables.

----------------------------------
Future Improvements (Planned)

-Unit tests (JUnit, Mockito)
-Integration tests for controllers
-API documentation (Swagger / OpenAPI)
-Authentication and authorization
-User accounts
-JWT-based security
-Docker support (Dockerfile + docker-compose)
-CI pipeline (GitHub Actions)
