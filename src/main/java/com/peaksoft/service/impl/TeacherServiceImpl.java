package com.peaksoft.service.impl;

import com.peaksoft.dao.CourseDao;
import com.peaksoft.dao.GroupDao;
import com.peaksoft.dao.TeacherDao;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;
    private final CourseDao courseDao;
    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao, CourseDao courseDao) {
        this.teacherDao = teacherDao;
        this.courseDao = courseDao;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }



    @Override
    public void addTeacher(Teacher teacher, Long courseId) {
        Course course = courseDao.getById(courseId);
        teacher.setCourse(course);
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher, Long courseId) {
        Course course = courseDao.getById(courseId);
        teacher.setCourse(course);
        teacherDao.updateTeacher(id, teacher);
    }
    @Override
    public Teacher getById(Long id) {
        return teacherDao.getById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
     teacherDao.deleteTeacher(teacher);
    }

    @Override
    public List<Student> sizeOfStudents(Long id) {
        return teacherDao.sizeOfStudents(id);
    }
}
