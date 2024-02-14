package com.example.user.repository;

import com.example.user.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LecturerRepo extends JpaRepository<Lecturer, Long> {
    @Query(value = "SELECT * from lecturer", nativeQuery = true)
    List<Lecturer> getAllLecturer();
}
