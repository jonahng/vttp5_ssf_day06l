package com.jonah.vttp5_ssf_day06l.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonah.vttp5_ssf_day06l.model.Student;
import com.jonah.vttp5_ssf_day06l.service.StudentRestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRestService studentRestService;

    @GetMapping("")
    public String studentForm(Model model) {
        Student s = new Student();
        model.addAttribute("student", s);
        return "studentform";
    }
    
    @PostMapping("")
    public String postStudentForm(@ModelAttribute Student entity) {
        //TODO: process POST request
        
        return "redirect:/students/list";
    }
    
    @GetMapping("/list")
    public String getMethodName(Model model) {
        List<Student> students = new ArrayList<>();
        students = studentRestService.getAllStudents();
        model.addAttribute(students);
        return "studentlist";
    }
    
    
}
