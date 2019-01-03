package io.github.contacttoakhil.model;

public class Course {
    private Integer id;
    private Integer studentId;
    private String courseName;

    public Course() { }

    public Course(Integer id, Integer studentId, String courseName) {
        this.id = id;
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
