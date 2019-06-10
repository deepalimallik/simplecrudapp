package com.logicabeans.simplecrudapp.daoImpl;

import com.logicabeans.simplecrudapp.dao.StudentDAO;
import com.logicabeans.simplecrudapp.model.Student;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {


    @PersistenceContext
    private EntityManager entityManager;
//
//    private final SessionFactory sessionFactory;
//    Session session = null;
//   // private final TeacherDAO teacherDAO;
//
//
//    public StudentDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//        session = sessionFactory.openSession();
//        //this.teacherDAO = teacherDAO;
//    }

    @Override
    public List<Student> findAllStudent() {
       return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
//        return session.createQuery("FROM student", Student.class).getResultList();
    }

   @Override
    public Student findStudentById(String studentId) {
      return entityManager.find(Student.class, studentId);
    }

    @Override
    public void addStudent(Student student) {

         entityManager.persist(student);
    }

    @Override
    public void update(Student student, String studentId) {
        /*CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Student> update = criteriaBuilder.createCriteriaUpdate(Student.class);
        Root studentRoot = update.from(Student.class);
        update.set(studentRoot.get("studentName"), criteriaBuilder;
        update.where()*/

       /* EntityTransaction updateTransaction = entityManager.getTransaction();
        updateTransaction.begin();
        Query query = entityManager.createQuery("UPDATE Student student SET student.studentName ='deepali'" + "WHERE student.studentId= :id");
        query.setParameter("studentName",dto.getStudentName());
        int updateCount = query.executeUpdate();
        if (updateCount > 0) {
            System.out.println("Done");
        }
        updateTransaction.commit();*/



    /*  Student student1 = findStudentById(student.getStudentId());
      student1.setStudentName(student.getStudentName());
      student1.setStudentAddress(student.getStudentAddress());
      student1.setStudentEmail(student.getStudentEmail());
      student1.setTeacher(student.getTeacher());
      entityManager.flush();
*/

//    entityManager.createQuery("UPDATE Student s SET s.studentName = ");
    }

    @Override
    public void deleteById(String studentId) {
        entityManager.remove(findStudentById(studentId));
    }
}
