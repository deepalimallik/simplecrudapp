package com.logicabeans.simplecrudapp.dao;

import com.logicabeans.simplecrudapp.model.Course;

import java.util.List;

public interface CourseDAO {


    List<Course> findAll();
    Course findCourseById(Long courseId);
    Course addCourse(Course course);
    void update(Course course, Long courseId);
    void deleteById(Course course, Long courseId);
}
