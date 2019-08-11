package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.dto.TeacherDto;
import com.logicabeans.simplecrudapp.model.Teacher;
import java.util.List;


public interface TeacherService {

    List<TeacherDto> findAll();
    TeacherDto findTeacherById(Long teacherId);
    TeacherDto addTeacher(TeacherDto teacherDto);
    void update(TeacherDto teacherDto, Long teacherId);
    void deleteById( Long teacherId);

}
