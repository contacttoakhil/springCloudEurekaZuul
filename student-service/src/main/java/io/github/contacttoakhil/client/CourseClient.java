package io.github.contacttoakhil.client;

import io.github.contacttoakhil.model.Course;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("course-service")
public interface CourseClient {

    @RequestMapping(method = RequestMethod.GET, value = "/courses/student/{studentId}")
    List<Course> getCourses(@PathVariable("studentId") Integer studentId);

}
