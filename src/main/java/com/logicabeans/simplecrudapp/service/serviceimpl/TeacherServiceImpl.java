package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.repository.TeacherRepository;
import com.logicabeans.simplecrudapp.service.TeacherService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(String teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow(() -> new DataNotFoundException("Teacher Not found"));
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        if(teacher==null)
        {
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher, String teacherId) {
        if(teacher==null || teacherId==null){
            throw  new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }

        Optional<Teacher> teacher1 = teacherRepository.findById(teacherId);
        if(!teacher1.isPresent()){
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        teacher1.get().setTeacherName(teacher.getTeacherName());
        teacher1.get().setAddress(teacher.getAddress());
        teacher1.get().setEmail(teacher.getEmail());
        teacher1.get().setPhoneNumber(teacher.getPhoneNumber());


        return teacherRepository.save(teacher1.get());
    }

    @Override
    public Teacher deleteById(Teacher teacher, String teacherId) {
        if(teacherId==null){
            throw new DataNotFoundException(ExceptionConstant.TEACHER_NOT_FOUND);
        }
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        teacherRepository.delete(teacherOptional.get());
        return teacherOptional.get();
    }

}
