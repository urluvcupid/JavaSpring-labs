# SIS 5 — Film Management System with Swagger

This project is a Film Management System built with Spring Boot, PostgreSQL, Flyway and Swagger/OpenAPI

## What was implemented
- custom domain: Film Management System
- Swagger/OpenAPI documentation
- versioned API: `/api/v1/...`
- DTO documentation with `@Schema`
- validation shown in Swagger
- pagination with `Pageable`
- documented error responses

## Notes
Because annotation processing was unstable on my machine, I used manual constructors, getters/setters and manual mapping instead of Lombok/MapStruct.
