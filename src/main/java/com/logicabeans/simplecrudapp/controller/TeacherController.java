package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.service.TeacherService;
import com.logicabeans.simplecrudapp.utils.RestAPIConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestAPIConstant.REST_TEACHER_URL)
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll(){
       List<Teacher> teacherList = teacherService.findAll();

       return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<?> findTeacherById(@PathVariable Long teacherId){
        Teacher teacher2 = teacherService.findTeacherById(teacherId);
        return new ResponseEntity<>(teacher2, HttpStatus.OK);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<?> update(@RequestBody @Valid Teacher teacher, @PathVariable Long teacherId){

        teacherService.update(teacher,teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<?> deleteById(@RequestBody @Valid Teacher teacher, @PathVariable Long teacherId){

        teacherService.deleteById(teacher, teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

