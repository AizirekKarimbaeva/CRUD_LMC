package com.peaksoft.controller;

import com.peaksoft.entity.*;
import com.peaksoft.service.CompanyService;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping
    public String courses(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "course/courses";
    }

    @GetMapping("/addCourse")
    public String add(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("companies", companyService.getAllCompany());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String save(@ModelAttribute("course") Course course) {
        courseService.addCourse(course, course.getCompanyId());
        return "redirect:/courses";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getById(id);
        model.addAttribute("course", course);
        model.addAttribute("companies",companyService.getAllCompany());
        return "course/updateCourse";
    }
    @PatchMapping("/{id}")
    public String updateCourse(@PathVariable("id")Long id,@ModelAttribute("course")Course course){
        courseService.updateCourse(id,course,course.getCompanyId());
        return "redirect:/courses";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Course course = courseService.getById(id);
        courseService.deleteCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/groups/{id}")
    public String getGroups(@PathVariable("id") Long id, Model model) {
        List<Group> groups = courseService.getGroupsByCourseId(id);
        model.addAttribute("groups", groups);
        return "course/groups";
    }
    @GetMapping("/teacher/{id}")
    public String teachers(@PathVariable("id")Long id, Model model){
        List<Teacher> teachers = courseService.getTeachersByCourseId(id);
        model.addAttribute("teachers",teachers);
        return "course/teachers";
    }
}