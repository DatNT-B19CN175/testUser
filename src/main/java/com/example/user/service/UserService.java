package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //chỉ định rằng nó là một bean của Spring được quản lý và nó chịu trách nhiệm cho logic kinh doanh của ứng dụng trong lớp dịch vụ.
public class UserService {
    private final UserRepo userRepo;

    //giúp đảm bảo rằng UserService có thể tương tác với cơ sở dữ liệu thông qua UserRepo.
    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.getAllUser();
    }

    public void addUser (User user){
        userRepo.insertUser(user.getId(), user.getName(), user.getHometown());
    }

    public List<User> findUserByID(Long userID){
        return userRepo.findUserByID(userID);
    }

    public void deleteUser (Long userID){
        userRepo.deleteUser(userID);
    }

    public void updateUser (User user){
        userRepo.updateUser(user.getId(), user.getName(), user.getHometown());
    }
}
