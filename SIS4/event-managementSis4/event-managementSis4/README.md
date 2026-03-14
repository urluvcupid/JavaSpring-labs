## SIS 4 — Event Management API

This project is a production-ready Event Management API built with Spring Boot, PostgreSQL and Flyway.

## What was implemented
- CRUD for events
- PostgreSQL database
- Flyway migrations
- DTO request/response objects
- validation
- global exception handling
- structured logging
- layered architecture: controller / service / repository

## Notes
The original task expected Lombok and MapStruct.  
Since my loptop have unexplainable problems, annotation processing was unstable, I used:
- manual constructors
- manual getters/setters
- manual mapping
- standard SLF4J logger
