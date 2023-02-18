package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.GroupService;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;
    private final GroupService groupService;
    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }
    @GetMapping
    public  String students(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "student/students";
    }
    @GetMapping("/addStudent")
    public String add(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("groups",groupService.getAllGroup());
        return "student/addStudent";
    }
    @PostMapping("/saveStudent")
    public String save(@ModelAttribute("student")Student student){
        studentService.addStudent(student,student.getGroupId());
        return "redirect:/students";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        model.addAttribute("groups",groupService.getAllGroup());
        return "student/updateStudent";
    }
    @PatchMapping("/{id}")
    public String updateStudent(@PathVariable("id")Long id,@ModelAttribute("student")Student student){
        studentService.updateStudent(id,student,student.getGroupId());
        return "redirect:/students";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        Student student = studentService.getById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/groups/{id}")
    public String getGroup(@PathVariable("id")Long id, Model model){
        List<Group> groups = studentService.getGroupById(id);
        model.addAttribute("groups",groups);
        return "groups/groups";
    }
}
