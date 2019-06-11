package com.logicabeans.simplecrudapp.daoImpl;

import com.logicabeans.simplecrudapp.dao.StudentDAO;
import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.model.Student;
import com.logicabeans.simplecrudapp.model.Teacher;
import com.logicabeans.simplecrudapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {


    @PersistenceContext
    private EntityManager entityManager;
/*
    @Autowired
    private TeacherRepository teacherRepository;
    */

    private TeacherDAO teacherDAO;

    public StudentDAOImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }
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
    public Student findStudentById(Long studentId) {
      return entityManager.find(Student.class, studentId);
    }

    @Override
    public Student addStudent(Student student) {
      /*  if(student.getTeacher()!=null) {
            Optional<Teacher> teacher = teacherRepository.findById(student.getTeacher().getTeacherId());
            if(teacher.isPresent()){
                student.setTeacher(teacher.get());
            }*/
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


    //check if student exists

 /*  entityManager.createQuery("UPDATE Student SET student_name = :name, student_address = :address, student_email= :email WHERE student_id = :id")
           .setParameter("name", student.getStudentName())
           .setParameter("address", student.getStudentAddress())
           .setParameter("email", student.getStudentEmail())
           .setParameter("id", studentId)
           .executeUpdate();*/

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
          /* Optional<Teacher> teacher = teacherRepository.findById(student.getTeacher().getTeacherId());
            if(teacher.isPresent()){
                student1.setTeacher(teacher.get());
            }*/
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
