package com.logicabeans.simplecrudapp.daoImpl;

import com.logicabeans.simplecrudapp.dao.StudentDAO;
import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.model.Teacher;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {


    @PersistenceContext
    private EntityManager entityManager;


    private TeacherDAO teacherDAO;

    public StudentDAOImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }


    @Override
    public List<Student> findAllStudent() {
       return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

    }

   @Override
    public Student findStudentById(Long studentId) {
      return entityManager.find(Student.class, studentId);
    }

    @Override
    public Student addStudent(Student student) {

      if(student.getTeacher()!=null){
          Teacher teacher = teacherDAO.findTeacherById(student.getTeacher().getTeacherId());
          if(teacher!=null){
              student.setTeacher(teacher);
          }
        }

         entityManager.persist(student);
         return student;
    }

    @Override
    public void update(Student student, Long studentId) {

        Student student1 = entityManager.find(Student.class, studentId);
        if(student.getStudentName()!=null) {
            student1.setStudentName(student.getStudentName());
        }
        if(student.getStudentAddress()!=null) {
            student1.setStudentAddress(student.getStudentAddress());
        }
        if(student.getStudentEmail()!=null) {
            student1.setStudentEmail(student.getStudentEmail());
        }
        if(student.getTeacher()!=null) {

            Teacher teacher = teacherDAO.findTeacherById(student.getTeacher().getTeacherId());
            if(teacher!=null){
                student1.setTeacher(teacher);
            }
        }
        entityManager.persist(student1);

    }

    @Override
    public void deleteById(Long studentId) {
        entityManager.remove(findStudentById(studentId));
    }
}
