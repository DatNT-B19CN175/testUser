package com.example.user.service;

import com.example.user.entity.Student;
import com.example.user.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService (StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    public List<Student> getAllStudent(){
        return studentRepo.getAllStudent();
    }
}
