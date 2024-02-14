package com.example.user.repository;

import com.example.user.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * from student",nativeQuery = true)
    List<Student> getAllStudent();
}
