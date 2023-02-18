package com.peaksoft.service;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();
    void addGroup(Group group,Long courseId);
    void updateGroup(Long id, Group group,Long courseId);
    Group getById(Long id);
    void deleteGroup(Group group);
    List<Student>getStudentsByGroupId(Long id);
    List<Student> search(Long groupId,String studentName);
    List<Course>getCoursesByGroupId(Long id);
}
