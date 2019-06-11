package com.logicabeans.simplecrudapp.daoImpl;

import com.logicabeans.simplecrudapp.dao.TeacherDAO;
import com.logicabeans.simplecrudapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeacherDAOImpl implements TeacherDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Teacher> findAll() {
        return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher findTeacherById(Long teacherId) {
        return entityManager.find(Teacher.class, teacherId);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public void update(Teacher teacher, Long teacherId) {
        Teacher teacher1 = entityManager.find(Teacher.class, teacherId);
        if(teacher.getTeacherName()!=null){
            teacher1.setTeacherName(teacher.getTeacherName());
        }
        if(teacher.getAddress()!=null){
            teacher1.setAddress(teacher.getAddress());
        }
        if(teacher.getEmail()!=null){
            teacher1.setEmail(teacher.getEmail());
        }
        if(teacher.getPhoneNumber()!=null){
            teacher1.setPhoneNumber(teacher.getPhoneNumber());
        }
        entityManager.persist(teacher1);
    }

    @Override
    public void deleteById(Teacher teacher, Long teacherId) {
        entityManager.remove(findTeacherById(teacherId));
    }
}
