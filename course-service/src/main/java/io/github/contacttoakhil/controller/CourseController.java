package io.github.contacttoakhil.controller;

import io.github.contacttoakhil.CourseApplication;
import io.github.contacttoakhil.model.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class CourseController {
    private List<Course> courses;

    protected Logger logger = Logger.getLogger(CourseApplication.class.getName());

    public CourseController() {
        populateCourses();
    }

    @RequestMapping("/courses/{number}")
    public Course findByName(@PathVariable("name") String name) {
        logger.info(String.format("CourseApplication.findByNumber(%s)", name));
        return courses.stream().filter(c -> c.getCourseName().equals(name)).findFirst().get();
    }

    @RequestMapping("/courses/student/{studentId}")
    public List<Course> findByStudent(@PathVariable("studentId") Integer studentId) {
        logger.info(String.format("CourseApplication.findByStudent(%s)", studentId));
        return courses.stream().filter(it -> it.getStudentId().intValue()==studentId.intValue()).collect(Collectors.toList());
    }

    @RequestMapping("/courses")
    public List<Course> findAll() {
        logger.info("CourseApplication.findAll()");
        return courses;
    }

    private void populateCourses() {
        courses = new ArrayList<>();
        courses.add(new Course(1, 1, "Database"));
        courses.add(new Course(2, 2, "Computer Architecture"));
        courses.add(new Course(3, 1, "Computer Networks"));
        courses.add(new Course(4, 2, "Artificial Intelligence"));
        courses.add(new Course(5, 3, "Pattern Recognition"));
        courses.add(new Course(6, 4, "Natural Language Processing"));
        courses.add(new Course(7, 1, "Neural Networks"));
        courses.add(new Course(8, 2, "Operational Research"));
        courses.add(new Course(9, 3, "Probability"));
        courses.add(new Course(10, 4, "Statistics"));
    }

}
