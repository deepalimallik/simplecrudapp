package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherService {

    List<Teacher> findAll();
    Teacher findTeacherById(String teacherId);
    Teacher addTeacher(Teacher teacher);
    Teacher update(Teacher teacher, String teacherId);
    Teacher deleteById(Teacher teacher, String teacherId);

}
