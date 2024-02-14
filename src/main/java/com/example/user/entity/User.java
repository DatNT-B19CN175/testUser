package com.example.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //chỉ ra class User là 1 entity tương ứng với 1 bảng trong CSDL
public class User {
    @Id //xác định trường id là khóa chính (primary key) của bảng user
    @GeneratedValue(strategy = GenerationType.IDENTITY) //giá trị trường id sẽ tự động tăng lên khi thêm 1 user mới mà không cần nhập
    private Long id;
    private String name;
    private String hometown;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
