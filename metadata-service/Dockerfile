FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/metadata-layer.jar metadata-layer.jar
ENTRYPOINT ["java", "-jar", "metadata-layer.jar"]
