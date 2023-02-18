package com.peaksoft.controller;

import com.peaksoft.entity.Company;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Student;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("companies")
public class CompanyController {
    private  final CompanyService companyService;

 @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public  String companies(Model model){
        model.addAttribute("companies",companyService.getAllCompany());
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String add(Model model){
        model.addAttribute("company",new Company());
        return "company/addCompany";
    }
    @PostMapping("/saveCompany")
    public String save(@ModelAttribute("company")Company company){
        companyService.addCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id,Model model){
        Company company = companyService.getById(id);
        model.addAttribute("company",company);
        return "company/updateCompany";
    }
    @PatchMapping("/{id}")
    public String updateCompany(@PathVariable("id")Long id,@ModelAttribute("company")Company company){
       companyService.updateCompany(id,company);
       return "redirect:/companies";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        Company company = companyService.getById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/courses/{id}")
    public String getCourses(@PathVariable("id")Long id,Model model){
        List<Course>courses = companyService.getCoursesByCompanyId(id);
        model.addAttribute("courses",courses);
        return "company/courses";
    }
    @GetMapping("/getStudent/{id}")
    public String students(@PathVariable("id") Long id, Model model){
        List<Student>students = companyService.getStudentsByCompanyId(id);
        model.addAttribute("students",students);
        return "company/getStudent";
    }
}
