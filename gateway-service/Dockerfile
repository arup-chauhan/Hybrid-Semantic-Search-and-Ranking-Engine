FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/gateway-service.jar gateway-service.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
