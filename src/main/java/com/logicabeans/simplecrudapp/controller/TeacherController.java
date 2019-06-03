package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody @Valid Teacher teacher){
        Teacher teacher1 = teacherService.addTeacher(teacher);
        if(teacher1==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(teacher1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll(){
       List<Teacher> teacherList = teacherService.findAll();
       if(teacherList==null || teacherList.size()==0){
          return new ResponseEntity<>(teacherList, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable String teacherId){
        Teacher teacher2 = teacherService.findTeacherById(teacherId);
        if(teacher2==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher2, HttpStatus.OK);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> update(@RequestBody @Valid Teacher teacher, @PathVariable String teacherId){
        Teacher teacher3 = teacherService.update(teacher, teacherId);
        if(teacher3==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(teacher3, HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Teacher> deleteById(@RequestBody @Valid Teacher teacher, @PathVariable String teacherId){
        Teacher teacher4 = teacherService.deleteById(teacher, teacherId);
        if(teacher4==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(teacher4, HttpStatus.OK);
    }
}

