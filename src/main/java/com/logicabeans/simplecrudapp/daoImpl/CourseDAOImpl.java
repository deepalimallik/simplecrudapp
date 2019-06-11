package com.logicabeans.simplecrudapp.daoImpl;

import com.logicabeans.simplecrudapp.dao.CourseDAO;
import com.logicabeans.simplecrudapp.dao.StudentDAO;
import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.model.Course;
import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.repository.StudentRepository;
import com.logicabeans.simplecrudapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CourseDAOImpl implements CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private TeacherDAO teacherDAO;
    private StudentDAO studentDAO;

    public CourseDAOImpl(TeacherDAO teacherDAO, StudentDAO studentDAO) {
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findCourseById(Long courseId) {
        return entityManager.find(Course.class,courseId);
    }

    @Override
    public Course addCourse(Course course) {
        Student student = studentDAO.findStudentById(course.getStudent().getStudentId());
        if(student!=null){
            course.setStudent(student);
        }

        Teacher teacher = teacherDAO.findTeacherById(course.getTeacher().getTeacherId());
        if(teacher!=null){
            course.setTeacher(teacher);
        }
        entityManager.persist(course);
        return course;
    }

    @Override
    public void update(Course course, Long courseId) {

        Course course1 = entityManager.find(Course.class, courseId);
        if(course.getCourseName()!=null){
            course1.setCourseName(course.getCourseName());
        }
        if(course.getStudent()!=null){
            Student student = studentDAO.findStudentById(course.getStudent().getStudentId());
            if(student!=null){
                course1.setStudent(student);
            }
        }
        if(course.getTeacher()!=null) {
            Teacher teacher = teacherDAO.findTeacherById(course.getTeacher().getTeacherId());
            if(teacher!=null){
                course1.setTeacher(teacher);
            }
        }
        entityManager.persist(course1);

    }

    @Override
    public void deleteById(Course course, Long courseId) {
    entityManager.remove(findCourseById(courseId));
    }
}
