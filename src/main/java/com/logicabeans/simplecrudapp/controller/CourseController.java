package com.logicabeans.simplecrudapp.controller;

import com.logicabeans.simplecrudapp.model.Course;
import com.logicabeans.simplecrudapp.service.CourseService;
import com.logicabeans.simplecrudapp.utils.RestAPIConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestAPIConstant.REST_COURSE_URL)
public class CourseController {



    private final CourseService courseService;

    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course){

        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<Course>> findAll(){
        List<Course> courseList = courseService.findAll();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
   // @RequestMapping(value = "/{courseId}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCourseById(@PathVariable Long courseId){
        Course course2 = courseService.findCourseById(courseId);
        return new ResponseEntity<>(course2, HttpStatus.OK);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> update(@RequestBody @Valid Course course, @PathVariable Long courseId){
         courseService.update(course, courseId);
        return new ResponseEntity<>( course, HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteById(@RequestBody @Valid Course course, @PathVariable Long courseId){
        courseService.deleteById(course, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
