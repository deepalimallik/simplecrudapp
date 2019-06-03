package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.repository.StudentRepository;
import com.logicabeans.simplecrudapp.service.StudentService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new DataNotFoundException("Student not found"));

    }

    @Override
    public Student addStudent(Student student) {
        if(student==null){
            throw new DataNotFoundException(ExceptionConstant.STUDENT_NOT_FOUND);
        }
        return studentRepository.save(student);
    }


    @Override
    public Student update(Student student, String studentId) {
        if(student==null || studentId==null){
            throw new DataNotFoundException(ExceptionConstant.STUDENT_NOT_FOUND);
        }

        Optional<Student> student1 = studentRepository.findById(studentId);
        if(!student1.isPresent()){
            throw new DataNotFoundException(ExceptionConstant.STUDENT_NOT_FOUND);
        }

        student1.get().setStudentName(student.getStudentName());
        student1.get().setStudentEmail(student.getStudentEmail());
        student1.get().setStudentAddress(student.getStudentAddress());
        student1.get().setTeacher(student.getTeacher());

        return studentRepository.save(student1.get());
    }

    @Override
    public Student deleteById(Student student, String studentId) {
       if(studentId==null){
           throw  new DataNotFoundException(ExceptionConstant.STUDENT_NOT_FOUND);
       }
       Optional<Student> studentOptional = studentRepository.findById(studentId);
       studentRepository.delete(studentOptional.get());
       return studentOptional.get();
    }
}
