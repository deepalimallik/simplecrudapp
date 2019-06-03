package com.logicabeans.simplecrudapp.service.serviceimpl;

import com.logicabeans.simplecrudapp.exception.DataNotFoundException;
import com.logicabeans.simplecrudapp.model.Course;
import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.repository.CourseRepository;
import com.logicabeans.simplecrudapp.service.CourseService;
import com.logicabeans.simplecrudapp.utils.ExceptionConstant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(String courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new DataNotFoundException("Course not found"));
    }

    @Override
    public Course addCourse(Course course) {
        if (course == null) {
            throw new DataNotFoundException(ExceptionConstant.COURSE_NOT_FOUND);
        }
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course, String courseId) {
        if (course == null || courseId == null) {
            throw new DataNotFoundException(ExceptionConstant.COURSE_NOT_FOUND);
        }

        Optional<Course> course1 = courseRepository.findById(courseId);
        if (!course1.isPresent()) {
            throw new DataNotFoundException(ExceptionConstant.COURSE_NOT_FOUND);
        }

        course1.get().setCourseName(course.getCourseName());
        course1.get().setStudent(course.getStudent());

        return courseRepository.save(course1.get());
    }


    @Override
    public Course deleteById(Course course, String courseId) {
        if (courseId == null) {
            throw new DataNotFoundException(ExceptionConstant.STUDENT_NOT_FOUND);
        }
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        courseRepository.delete(courseOptional.get());
        return courseOptional.get();

    }

}
