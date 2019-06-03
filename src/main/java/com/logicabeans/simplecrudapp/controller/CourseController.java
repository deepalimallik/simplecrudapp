package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Course;
import com.logicabeans.simplecrudapp.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course){
        Course course1 = courseService.addCourse(course);
        if(course1==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course1, HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<Course>> findAll(){
        List<Course> courseList = courseService.findAll();
        if(courseList==null){
            return new ResponseEntity<>(courseList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> findCourseById(@PathVariable String courseId){
        Course course2 = courseService.findCourseById(courseId);
        if(course2==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course2, HttpStatus.OK);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> update(@RequestBody @Valid Course course, @PathVariable String courseId){
        Course course3 = courseService.update(course, courseId);
        if(course3==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course3, HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Course> deleteById(@RequestBody @Valid Course course, @PathVariable String courseId){
        Course course4 = courseService.deleteById(course, courseId);
        if(course4==null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(course4, HttpStatus.OK);
    }
}
