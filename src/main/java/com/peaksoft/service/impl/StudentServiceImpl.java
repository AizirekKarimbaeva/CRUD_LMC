package com.peaksoft.service.impl;

import com.peaksoft.dao.GroupDao;
import com.peaksoft.dao.StudentDao;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
    private final GroupDao groupDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao, GroupDao groupDao) {
        this.studentDao = studentDao;
        this.groupDao = groupDao;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public void addStudent(Student student, Long groupId) {
        Group group = groupDao.getById(groupId);
        student.setGroup(group);
        studentDao.addStudent(student);
    }
    @Override
    public void updateStudent(Long id, Student student,Long groupId) {
        Group group = groupDao.getById(groupId);
        student.setGroup(group);
        studentDao.updateStudent(id,student);
    }

    @Override
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Override
    public void deleteStudent(Student student) {
     studentDao.deleteStudent(student);
    }

    @Override
    public List<Group> getGroupById(Long id) {
        return studentDao.getGroupById(id);
    }
}
