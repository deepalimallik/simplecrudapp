package com.logicabeans.simplecrudapp.dao;

import com.logicabeans.simplecrudapp.model.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAllStudent();
    Student findStudentById(Long studentId);
    Student addStudent(Student student);
    void update(Student student, Long studentId);
    void deleteById(Long studentId);
}
