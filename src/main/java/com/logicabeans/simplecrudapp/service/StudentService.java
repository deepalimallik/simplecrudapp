package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Student;
import java.util.List;



public interface StudentService {

    List<Student> findAllStudent();
    Student findStudentById(Long studentId);
    Student  addStudent(Student student);
    void update(Student student, Long studentId);
    void deleteById(Student student, Long studentId);


}
