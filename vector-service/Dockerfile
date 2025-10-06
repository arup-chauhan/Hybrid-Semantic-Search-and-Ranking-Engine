FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/vector-service.jar vector-service.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "vector-service.jar"]
