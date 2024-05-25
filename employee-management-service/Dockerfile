#Backend Dockerfile
FROM openjdk:17-jdk-slim
COPY target/employee-management-service*.jar /app.jar
EXPOSE 8801
ENTRYPOINT ["java", "-jar", "/app.jar"]
