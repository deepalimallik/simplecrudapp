package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.dto.TeacherDto;
import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.mapper.TeacherMapper;
import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.service.TeacherService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<TeacherDto> findAll() {
        List<TeacherDto> teacherDtos = teacherDAO.findAll().stream().map(teacher -> TeacherMapper.mapToDto(teacher)).collect(Collectors.toList());
       return teacherDtos;
    }

    @Override
    public TeacherDto findTeacherById(Long teacherId) {
        Teacher teacher = teacherDAO.findTeacherById(teacherId);
        return TeacherMapper.mapToDto(teacher);
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher1 = teacherDAO.addTeacher(TeacherMapper.mapToEntity(teacherDto));
        if(teacher1==null)
        {
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        return TeacherMapper.mapToDto(teacher1);
    }

    @Override
    public void update(TeacherDto teacherDto, Long teacherId) {

        Teacher teacher = TeacherMapper.mapToEntity(teacherDto);
        teacherDAO.update(teacher, teacherId);

    }

    @Override
    public void deleteById(Long teacherId) {
        teacherDAO.deleteById(teacherId);
    }


}
