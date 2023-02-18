package com.peaksoft.dao.impl;

import com.peaksoft.dao.TeacherDao;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Teacher> getAllTeacher() {
        return entityManager.createQuery("from Teacher ").getResultList();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Teacher teacher1 = entityManager.find(Teacher.class, id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        entityManager.merge(teacher1);
    }

    @Override
    public Teacher getById(Long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(entityManager.contains(teacher)?teacher:entityManager.merge(teacher));

    }
    @Override
    public List<Student> sizeOfStudents(Long id) {
        List<Student>students = entityManager.createQuery("select s from Student s join " +
                        " s.group g join g.course c join c.teachers t where t.id=?1")
                .setParameter(1,id).getResultList();
        return students;
    }
}
