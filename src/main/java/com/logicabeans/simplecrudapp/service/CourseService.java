package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course findCourseById(String courseId);
    Course addCourse(Course course);
    Course update(Course course, String courseId);
    Course deleteById(Course course, String courseId);

}
