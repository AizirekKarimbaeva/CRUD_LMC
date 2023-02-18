package com.peaksoft.dao;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();
    void addStudent(Student student);
    void updateStudent(Long id, Student student);
    Student getById(Long id);
    void deleteStudent(Student student);
    List<Group> getGroupById(Long id);


}
