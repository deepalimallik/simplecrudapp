package com.logicabeans.simplecrudapp.dto;

import com.logicabeans.simplecrudapp.model.Student;

public class CourseDto {

    private Long courseId;

    private String courseName;

    private Student student;

    public CourseDto() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
