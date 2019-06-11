package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.service.TeacherService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findTeacherById(Long teacherId) {
        return teacherDAO.findTeacherById(teacherId);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        if(teacher==null)
        {
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        return teacherDAO.addTeacher(teacher);
    }

    @Override
    public void update(Teacher teacher, Long teacherId) {
         teacherDAO.update(teacher, teacherId);
    }

    @Override
    public void deleteById(Teacher teacher, Long teacherId) {
       teacherDAO.deleteById(teacher,teacherId);
    }


}
