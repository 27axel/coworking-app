FROM maven:3.9.4-amazoncorretto-20-al2023 AS build
COPY src src
COPY pom.xml .
RUN mvn -f pom.xml clean package

FROM openjdk:20
COPY --from=build /target/coworking_app-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]