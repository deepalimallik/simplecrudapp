package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.dao.CourseDAO;
import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Course;
import com.logicabeans.simplecrudapp.service.CourseService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;;

@Service
public class CourseServiceImpl implements CourseService {


    private CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }


    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

   @Override
    public Course findCourseById(Long courseId) {
       return  courseDAO.findCourseById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        if (course == null) {
            throw new DataNotFoundException(ExceptionConstant.COURSE_NOT_FOUND);
        }
         courseDAO.addCourse(course);
        return course;
    }

    @Override
    public void update(Course course, Long courseId) {
      courseDAO.update(course,courseId);
    }


    @Override
    public void deleteById(Course course, Long courseId) {
       courseDAO.deleteById(course,courseId);
    }

}
