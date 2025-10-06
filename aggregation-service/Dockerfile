FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/aggregation-service-1.0.0.jar aggregation-service.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "aggregation-service.jar"]
