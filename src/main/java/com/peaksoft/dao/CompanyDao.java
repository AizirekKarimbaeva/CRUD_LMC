package com.peaksoft.dao;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;

import java.util.List;

public interface CompanyDao {
    List<Company>getAllCompany();
    void addCompany(Company company);
    void updateCompany(Long id, Company company);
    Company getById(Long id);
    void deleteCompany(Company company);
    List<Course>getCoursesByCompanyId(Long id);
    List<Student>getStudentsByCompanyId(Long id);
}
