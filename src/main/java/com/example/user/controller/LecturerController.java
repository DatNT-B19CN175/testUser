package com.example.user.controller;

import com.example.user.entity.Lecturer;
import com.example.user.service.LecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LecturerController {
    private LecturerService lecturerService;

    public LecturerController (LecturerService lecturerService){
        this.lecturerService=lecturerService;
    }

    @GetMapping("/lecturer")
    public String getAllLecturer(Model model){
        List<Lecturer> lecturerList = lecturerService.getAllLecturer();
        model.addAttribute("lecturers",lecturerList);
        return "lecturerList";
    }
}
