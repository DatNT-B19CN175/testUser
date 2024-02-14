package com.example.user.service;

import com.example.user.entity.Lecturer;
import com.example.user.repository.LecturerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {
    private LecturerRepo lecturerRepo;

    public LecturerService (LecturerRepo lecturerRepo){
        this.lecturerRepo=lecturerRepo;
    }

    public List<Lecturer> getAllLecturer(){
        return lecturerRepo.getAllLecturer();
    }
}
