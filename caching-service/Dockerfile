FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/caching-service.jar caching-service.jar
ENTRYPOINT ["java","-jar","caching-service.jar"]
