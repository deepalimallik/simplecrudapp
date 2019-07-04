package com.logicabeans.simplecrudapp.model;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_id", nullable = false, updatable = false)
    private Long teacherId;

    @Column(name="teacher_name")
    private String teacherName;

    @Column(name="teacher_address")
    private String address;

    @Column(name="teacher_email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    public Teacher() {
    }

    public Teacher(Long teacherId, String teacherName, String address, String email, String phoneNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
