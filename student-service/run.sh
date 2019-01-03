
#!/bin/sh

echo "********************************************************"
echo "Student-service: Waiting for the discovery service to start on port 8761"
echo "********************************************************"

while ! nc -z discovery-service 8761 ; do
    echo "Waiting for the discovery service (Eureka Server)"
    sleep 3
done

echo "********************************************************"
echo "Starting student service"
echo "********************************************************"

java -jar /tmp/local/studentservice/student-service.jar

