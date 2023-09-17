# Coworking_app

The application allows you to book a room in a network of coworking spaces (СRUD for coworking spaces and rooms, room filtering methods, room booking method) using confirmed REST requests.

## Technologies (13 in total)
- **PostgreSQL database** for in-memory storing
- **Spring boot** for using starter dependencies
- **Spring Web** for REST implementation
- **Spring JPA, Liquibase, Hibernate** for database interaction
- **Spring Validation** for DTO checking
- **Springdoc OpenApi, Swagger** for API description
- **Lombok, Mapstruct** for code generation
- **Maven** as build tool
- **Docker** for building image and container

## Launch via Docker
1) Download the project
2) Open command console and move to the project folder
3) Use this command to build the images:
```
docker build -t coworking-app -f Dockerfile .
```
4) Then run docker-compose using the command:
```
docker-compose up -d
```
## Access the running app
- [API interaction via Swagger](http://localhost:8080/swagger-ui/index.html#/)
