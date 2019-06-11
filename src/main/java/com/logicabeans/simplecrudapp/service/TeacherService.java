package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Teacher;
import java.util.List;


public interface TeacherService {

    List<Teacher> findAll();
    Teacher findTeacherById(Long teacherId);
    Teacher addTeacher(Teacher teacher);
    void update(Teacher teacher, Long teacherId);
    void deleteById(Teacher teacher, Long teacherId);

}
