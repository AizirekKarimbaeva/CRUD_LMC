package com.peaksoft.dao;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroup();
    void addGroup(Group group);
    void updateGroup(Long id, Group group);
    Group getById(Long id);
    void deleteGroup(Group group);
    List<Course>getCoursesByGroupId(Long id);
    List<Student>getStudentsByGroupId(Long id);

    List<Student> search(Long groupId,String studentName);

}
