package com.logicabeans.simplecrudapp.dao;

import com.logicabeans.simplecrudapp.model.Course;

import java.util.List;

public interface CourseDAO {


    List<Course> findAll();
    Course findCourseById(String courseId);
    Course addCourse(Course course);
    Course update(Course course, String courseId);
    Course deleteById(Course course, String courseId);
}
