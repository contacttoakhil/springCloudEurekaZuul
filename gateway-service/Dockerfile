FROM openjdk:8-jdk-alpine
MAINTAINER Akhil Mittal <contacttoakhil123@gmail.com>
ADD target/gateway-service.jar gateway-service.jar
ENTRYPOINT ["java", "-jar", "/gateway-service.jar"]
EXPOSE 8765