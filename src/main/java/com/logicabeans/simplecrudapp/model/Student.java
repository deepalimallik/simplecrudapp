package com.logicabeans.simplecrudapp.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_email")
    private String studentEmail;

    @Column(name="student_address")
    private String studentAddress;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Student() {
    }

    public Student(Long studentId, String studentName, String studentEmail, String studentAddress, Teacher teacher) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
        this.teacher = teacher;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
