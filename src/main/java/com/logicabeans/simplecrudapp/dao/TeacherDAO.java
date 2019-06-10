package com.logicabeans.simplecrudapp.dao;

import com.logicabeans.simplecrudapp.model.Teacher;

import java.util.List;

public interface TeacherDAO {

    List<Teacher> findAll();
    Teacher findTeacherById(String teacherId);
    Teacher addTeacher(Teacher teacher);
    Teacher update(Teacher teacher, String teacherId);
    Teacher deleteById(Teacher teacher, String teacherId);
}
