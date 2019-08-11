package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.dao.StudentDAO;
import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.service.StudentService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

   private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDAO.findAllStudent();
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentDAO.findStudentById(studentId);

    }

    @Override
    public Student addStudent(Student student) {
        //create mapper SERVICE
//        Student student1 = studentMapper.dtoToEntity(studentDTO);
        if(student==null){
            throw new DataNotFoundException(ExceptionConstant.STUDENT_NOT_FOUND);
        }
         studentDAO.addStudent(student);
        return  student;
    }


    @Override
    public void update(Student student, Long studentId) {
      studentDAO.update(student, studentId);
    }

    @Override
    public void deleteById(Student student, Long studentId) {
        studentDAO.deleteById(studentId);
    }
}
