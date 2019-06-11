package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody @Valid Teacher teacher){
        return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll(){
       List<Teacher> teacherList = teacherService.findAll();

       return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long teacherId){
        Teacher teacher2 = teacherService.findTeacherById(teacherId);
     /*   if(teacher2==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<>(teacher2, HttpStatus.OK);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> update(@RequestBody @Valid Teacher teacher, @PathVariable Long teacherId){

       /* if(teacher3==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }*/
        teacherService.update(teacher,teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Teacher> deleteById(@RequestBody @Valid Teacher teacher, @PathVariable Long teacherId){

       /* if(teacher4==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }*/
        teacherService.deleteById(teacher, teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

