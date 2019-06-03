package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student student){
        Student student1 = studentService.addStudent(student);
        if(student1==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> studentList = studentService.findAllStudent();
        if(studentList==null || studentList.size()==0){
            return new ResponseEntity<>(studentList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable String studentId){
        Student student2 = studentService.findStudentById(studentId);
        if(student2 == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student2, HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> update(@RequestBody @Valid Student student, @PathVariable String studentId){
        Student student3 = studentService.update(student, studentId);
        if(student3 == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(student3, HttpStatus.OK);

    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteById(@RequestBody @Valid Student student, @PathVariable String studentId){
        Student student4 = studentService.deleteById(student, studentId);
        if(student4 == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(student4, HttpStatus.OK);
    }
}
