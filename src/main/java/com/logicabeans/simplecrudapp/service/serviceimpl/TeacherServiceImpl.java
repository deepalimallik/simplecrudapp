package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.repository.TeacherRepository;
import com.logicabeans.simplecrudapp.service.TeacherService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

   /* private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }*/

    @Autowired
    private TeacherDAO teacherDAO;

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
      /*  if(teacher==null || teacherId==null){
            throw  new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }

        Optional<Teacher> teacher1 = teacherRepository.findById(teacherId);
        if(!teacher1.isPresent()){
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        teacher1.get().setTeacherName(teacher.getTeacherName());
        teacher1.get().setAddress(teacher.getAddress());
        teacher1.get().setEmail(teacher.getEmail());
        teacher1.get().setPhoneNumber(teacher.getPhoneNumber());*/


      //  return teacherRepository.save(teacher1.get());
         teacherDAO.update(teacher, teacherId);
    }

    @Override
    public void deleteById(Teacher teacher, Long teacherId) {
       /* if(teacherId==null){
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        teacherRepository.delete(teacherOptional.get());
        return teacherOptional.get();*/

       teacherDAO.deleteById(teacher,teacherId);
    }


}
