# springCloudEurekaZuul
This is a simple Spring Cloud App based on spring boot 1.x. It makes use of Eureka for service discovery and zuul for 
load balancing. The spring boot 2.0 does not support zuul rather it uses spring gateway.

Some docker files have two sections: one when you are using docker-compose and the other when manually deploying to docker.
Uncomment as per the requirement.

The course and student services should come up only when discovery service is up and thats why we are using [netcat](http://man.openbsd.org/nc) in run.sh files.
It ensures that the sourse/student service will start only when discovery service is up.

## Starting Services Locally
### Discovery Service (Netflix Eureka)
discovery-service> mvn spring-boot:run

Once the service is started we should be able to hit the launch page at: https://localhost:8761. We can also hit using IP e.g. 
if IP is 192.168.0.111 then we can hit http://192.168.0.111:8761/.

### Course Service
course-service>mvn spring-boot:run

When service is up it should register itself with eureka and should be displayed at http://localhost:8761. Also we should be 
able to hit: 
http://localhost:2222/courses

And it should list all course:

```javascript
[
{"id":1,"studentId":1,"courseName":"Database"},
{"id":2,"studentId":2,"courseName":"Computer Architecture"},
{"id":3,"studentId":1,"courseName":"Computer Networks"},
{"id":4,"studentId":2,"courseName":"Artificial Intelligence"},
{"id":5,"studentId":3,"courseName":"Pattern Recognition"},
{"id":6,"studentId":4,"courseName":"Natural Language Processing"},
{"id":7,"studentId":1,"courseName":"Neural Networks"},
{"id":8,"studentId":2,"courseName":"Operational Research"},
{"id":9,"studentId":3,"courseName":"Probability"},
{"id":10,"studentId":4,"courseName":"Statistics"}
]
```

### Student service
student-service> mvn spring-boot:run

When service is up it should be registered and should be displayed at http://localhost:8761/

Also should be able to hit end points.
http://localhost:3333/students

And it should be:

```javascript
[{"id":1,"name":"John Smith","type":"NON_EXCHANGE","courses":null},
{"id":2,"name":"Cherry Morgan","type":"NON_EXCHANGE","courses":null},
{"id":3,"name":"Ronaldo Cohan","type":"NON_EXCHANGE","courses":null},
{"id":4,"name":"Ram Kumar","type":"EXCHANGE","courses":null},
{"id":5,"name":"Yusuf Menon","type":"EXCHANGE","courses":null}]
```

### Gateway service (Netflix Zuul)
gateway-service> mvn spring-boot:run

http://localhost:8765/api/students/students
http://localhost:8765/api/courses/courses
http://localhost:8765/api/students/students/1  (Will use CourseClient to get course details also)

```javascript
{
"id":1,"name":"John Smith","type":"NON_EXCHANGE",
   "courses":[
       {"id":1,"studentId":1,"courseName":"Database"},
       {"id":3,"studentId":1,"courseName":"Computer Networks"},
       {"id":7,"studentId":1,"courseName":"Neural Networks"}
   ]
}
```

We can also start multiple instances e.g. student and course services as below:
course-service> mvn spring-boot:run -Drun.arguments=--server.port=2223
and
student-service> mvn spring-boot:run -Drun.arguments=--server.port=3334

In that case we can also monitor the logs to see that the zuul will also laod balance across these two instances.


## Starting Services in Docker
Every service has a corresponding Dockerfile and the process to start every service is same. For example for discovery service:
- Create an executable jar: mvn clean package
- Create image: docker build -t discovery-service .
- Deploy in docker container: docker run -p 8761:8761 discovery-service where 8761 is the exposed port.

When running in docker containers the localhost refers to the container itself and in these scenarios we need to make proper change
in defaultZone in application.yaml file. We should rather use ip e.g. http://192.168.0.101:8761/eureka


## Starting services using docker-compose.yml file
We can start one instance for every service by creatign executbale jar for every service and then firing the below command:
docker-compose up

This will bring one instance of each service.
