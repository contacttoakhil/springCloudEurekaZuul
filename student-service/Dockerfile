#Use with docker-compose.yml
FROM openjdk:8-jdk-alpine
MAINTAINER Akhil Mittal <contacttoakhil123@gmail.com>
RUN apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /tmp/local/studentservice
ADD target/student-service.jar /tmp/local/studentservice
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh

# Otherwise use this. We need to ensure we start after discovery service is up.
#FROM openjdk:8-jdk-alpine
#MAINTAINER Akhil Mittal <contacttoakhil123@gmail.com>
#ADD target/student-service.jar student-service.jar
#ENTRYPOINT ["java", "-jar", "/student-service.jar"]
#EXPOSE 3333