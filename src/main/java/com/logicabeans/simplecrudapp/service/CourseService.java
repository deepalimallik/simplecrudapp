package com.logicabeans.simplecrudapp.service;

import com.logicabeans.simplecrudapp.model.Course;
import java.util.List;

public interface CourseService {

    List<Course> findAll();
   Course findCourseById(Long courseId);
    Course addCourse(Course course);
    void update(Course course, Long courseId);
    void deleteById(Course course, Long courseId);

}
