FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/query-service-1.0.0.jar query-service.jar
ENTRYPOINT ["java","-jar","query-service.jar"]
