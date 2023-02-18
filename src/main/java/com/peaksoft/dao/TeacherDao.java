package com.peaksoft.dao;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeacher();
    void addTeacher(Teacher teacher);
    void updateTeacher(Long id, Teacher teacher);
    Teacher getById(Long id);
    void deleteTeacher(Teacher teacher);
    List<Student>sizeOfStudents(Long id);

}
