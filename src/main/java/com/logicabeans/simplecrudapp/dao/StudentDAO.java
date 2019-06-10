package com.logicabeans.simplecrudapp.dao;

import com.logicabeans.simplecrudapp.model.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAllStudent();
    Student findStudentById(String studentId);
    void addStudent(Student student);
    void update(Student student, String studentId);
    void deleteById(String studentId);
}
