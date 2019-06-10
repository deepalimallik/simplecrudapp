package com.logicabeans.simplecrudapp.model;

import javax.persistence.*;

@Entity(name = "")
@Table(name="course")
public class Course {

    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String courseId;

    @Column(name="course_name")
    private String courseName;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseId, String courseName, Student student, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.student = student;
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
