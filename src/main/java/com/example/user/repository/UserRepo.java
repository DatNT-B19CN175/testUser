package com.example.user.repository;

import com.example.user.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //đánh dấu nó là một bean của Spring có liên quan đến tầng truy cập dữ liệu.
@Transactional //đảm bảo rằng mọi phương thức được định nghĩa trong interface này sẽ thực hiện trong transaction
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * from user",nativeQuery = true)
    List<User> getAllUser();

    @Modifying //được sử dụng để chỉ định rằng phương thức này sẽ thực hiện các thay đổi trong cơ sở dữ liệu
    @Query(value = "INSERT INTO user (id, name, hometown) VALUES (:id, :name, :hometown)", nativeQuery = true)
    void insertUser(@Param("id") Long id, @Param("name") String name, @Param("hometown") String hometown);

    @Modifying
    @Query(value = "SELECT * from user WHERE id = :id", nativeQuery = true)
    List<User> findUserByID(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM user WHERE id = :id", nativeQuery = true)
    void deleteUser(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE user SET id=:id, name=:name, hometown=:hometown WHERE id=:id",nativeQuery = true)
    void updateUser(@Param("id")Long id, @Param("name") String name, @Param("hometown") String hometown);

    //@Query được sử dụng để xác định một truy vấn dựa trên ngôn ngữ truy vấn để lấy hoặc cập nhật dữ liệu từ cơ sở dữ liệu
    //@Param được sử dụng để ánh xạ tham số của phương thức repository với các tham số trong truy vấn được xác định bởi @Query.
    //nativeQuery = true có nghĩa là bạn đang sử dụng một truy vấn SQL native thay vì JPQL (Java Persistence Query Language)
}
