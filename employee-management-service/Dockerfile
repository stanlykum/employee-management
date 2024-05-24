#Backend Dockerfile
FROM openjdk:17-jdk-slim
COPY target/employee-management-service-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8801
ENTRYPOINT ["java", "-jar", "/app.jar"]


##  Build stage
#FROM openjdk:17-jdk-slim AS build
#WORKDIR /app
#COPY pom.xml .
#RUN ./mvnw dependency:go-offline
#
## Copy the entire source code
#COPY src ./src
#
## Build the application
#RUN ./mvnw package
#
## Run stage
#FROM openjdk:17-jdk-slim
## WORKDIR /app
#WORKDIR /employee-management-service
## COPY --from=build /app/target/*.jar app.jar
#COPY --from=build /employee-management-service/target/*.jar app.jar
#
## Expose the port
#EXPOSE 8801
#
## Run the application
#ENTRYPOINT ["java", "-jar", "app.jar"]