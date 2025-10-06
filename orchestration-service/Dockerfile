FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/orchestration-layer.jar orchestration-layer.jar
ENTRYPOINT ["java", "-jar", "orchestration-layer.jar"]
