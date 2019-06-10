package com.logicabeans.simplecrudapp.repository;

import com.logicabeans.simplecrudapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository  extends JpaRepository<Course, String>{

}
