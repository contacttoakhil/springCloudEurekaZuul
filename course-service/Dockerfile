# Use with docker-compose.yml
FROM openjdk:8-jdk-alpine
MAINTAINER Akhil Mittal <contacttoakhil123@gmail.com>
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /tmp/local/courseservice
ADD target/course-service.jar /tmp/local/courseservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh

# Use when deploying on docker manually
#FROM openjdk:8-jdk-alpine
#MAINTAINER Akhil Mittal <contacttoakhil123@gmail.com>
#ADD target/course-service.jar course-service.jar
#ENTRYPOINT ["java", "-jar", "/course-service.jar"]
#EXPOSE 2222
