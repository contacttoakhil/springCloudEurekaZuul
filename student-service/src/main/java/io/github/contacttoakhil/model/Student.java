package io.github.contacttoakhil.model;

import java.util.List;

public class Student {

    private Integer id;
    private String name;
    private StudentType type;
    private List<Course> courses;

    public Student() {
    }

    public Student(Integer id, String name, StudentType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentType getType() {
        return type;
    }

    public void setType(StudentType type) {
        this.type = type;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", courses=" + courses +
                '}';
    }
}

