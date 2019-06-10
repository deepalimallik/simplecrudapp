package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody @Valid Student student){
         studentService.addStudent(student);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> studentList = studentService.findAllStudent();

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

   @GetMapping("/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable String studentId){
        Student student2 = studentService.findStudentById(studentId);

        return new ResponseEntity<>(student2, HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> update(@RequestBody  Student student, String studentId){
         studentService.update(student, studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteById(@RequestBody @Valid Student student, @PathVariable String studentId){
        studentService.deleteById(student, studentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
