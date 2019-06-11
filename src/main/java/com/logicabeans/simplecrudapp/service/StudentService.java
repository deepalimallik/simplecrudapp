package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<Student> findAllStudent();
    Student findStudentById(Long studentId);
    Student  addStudent(Student student);
    void update(Student student, Long studentId);
    void deleteById(Student student, Long studentId);


}
