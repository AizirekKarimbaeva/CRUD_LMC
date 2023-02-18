package com.peaksoft.service.impl;

import com.peaksoft.dao.CompanyDao;
import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDao companyDao;
     @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public void addCompany(Company company) {
     companyDao.addCompany(company);
    }

    @Override
    public void updateCompany(Long id, Company company) {
       companyDao.updateCompany(id,company);
    }

    @Override
    public Company getById(Long id) {
        return companyDao.getById(id);
    }

    @Override
    public void deleteCompany(Company company) {
    companyDao.deleteCompany(company);
    }

    @Override
    public List<Course> getCoursesByCompanyId(Long id) {
        return companyDao.getCoursesByCompanyId(id);
    }

    @Override
    public List<Student> getStudentsByCompanyId(Long id) {
        return companyDao.getStudentsByCompanyId(id);
    }
}
