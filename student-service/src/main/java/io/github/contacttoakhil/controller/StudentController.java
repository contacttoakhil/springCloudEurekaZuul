package io.github.contacttoakhil.controller;

import io.github.contacttoakhil.client.CourseClient;
import io.github.contacttoakhil.model.Course;
import io.github.contacttoakhil.model.Student;
import io.github.contacttoakhil.model.StudentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private CourseClient courseClient;

    protected Logger logger = Logger.getLogger(StudentController.class.getName());

    private List<Student> students;

    public StudentController() {
        populateStudents();
    }

    @RequestMapping("/students/name/{name}")
    public List<Student> findByLastName(@PathVariable("name") String name) {
        logger.info(String.format("StudentController.findByLastName(%s)", name));
        return students.stream().filter(it -> it.getName().equals(name)).collect(Collectors.toList());
    }

    @RequestMapping("/students")
    public List<Student> findAll() {
        logger.info("StudentController.findAll()");
        return students;
    }

    @RequestMapping("/students/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        logger.info(String.format("StudentController.findById(%s)", id));
        Student student = students.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
        List<Course> course =  courseClient.getCourses(id);
        student.setCourses(course);
        return student;
    }

    private void populateStudents() {
        students = new ArrayList<>();
        students.add(new Student(1, "John Smith", StudentType.NON_EXCHANGE));
        students.add(new Student(2, "Cherry Morgan", StudentType.NON_EXCHANGE));
        students.add(new Student(3, "Ronaldo Cohan", StudentType.NON_EXCHANGE));
        students.add(new Student(4, "Ram Kumar", StudentType.EXCHANGE));
        students.add(new Student(5, "Yusuf Menon", StudentType.EXCHANGE));
    }

}
