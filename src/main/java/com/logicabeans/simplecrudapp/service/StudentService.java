package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<Student> findAllStudent();
    Student findStudentById(String studentId);
    Student addStudent(Student student);
    Student update(Student student, String studentId);
    Student deleteById(Student student, String studentId);


}
