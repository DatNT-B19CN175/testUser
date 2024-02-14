package com.example.user.controller;

import com.example.user.entity.Student;
import com.example.user.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController (StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/student")
    public String getAllStudent (Model model){
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("students",studentList);
        return "studentList";
    }
}
