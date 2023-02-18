package com.peaksoft.dao.impl;

import com.peaksoft.dao.GroupDao;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Group> getAllGroup() {
        return entityManager.createQuery("from Group ").getResultList();
    }

    public void addGroup(Group group) {
        entityManager.persist(group);
    }

    @Override
    public void updateGroup(Long id, Group group) {
        Group group1 = entityManager.find(Group.class, id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        entityManager.merge(group1);
    }

    @Override
    public Group getById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public void deleteGroup(Group group) {
        entityManager.remove(entityManager.contains(group) ? group : entityManager.merge(group));
    }


    @Override
    public List<Course> getCoursesByGroupId(Long id) {
        List<Course> courses = entityManager.createQuery("select c from Course c JOIN  " +
                        "c.groups gr WHERE gr.id = ?1")
                .setParameter(1, id).getResultList();
        return courses;
    }

    @Override
    public List<Student> getStudentsByGroupId(Long id) {
        List<Student> students = entityManager.createQuery("select s from Student s join s.group gr where gr.id=?1").setParameter(1, id).getResultList();
        return students;
    }

    @Override
    public List<Student> search(Long groupId, String studentName) {
        List<Student> students = entityManager.createQuery("select  g from Group g join g.students stu where " +
                "stu.firstName =?1 and g.id =?2").setParameter(1, studentName).setParameter(2,groupId).getResultList();
        return students;
    }
}


