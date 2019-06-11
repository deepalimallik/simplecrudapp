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
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){

        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> studentList = studentService.findAllStudent();

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

   @GetMapping("/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long studentId){
        Student student2 = studentService.findStudentById(studentId);
        return ResponseEntity.ok(student2);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> update(@RequestBody  Student student, @PathVariable Long studentId){
         studentService.update(student, studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Student> deleteById(@RequestBody @Valid Student student, @PathVariable Long studentId){
        studentService.deleteById(student, studentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
