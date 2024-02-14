package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //đánh dấu nó là một bean của Spring, chịu trách nhiệm cho xử lý các yêu cầu HTTP (view) và tương tác với service và entity
public class UserController {
    private final UserService userService;

    @Autowired //chỉ định dùng constructor này nếu có nhiều constructor khác khi tạo một đối tượng của class đó.
    //giúp đảm bảo rằng UserController có thể tương tác với UserService.
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/userList") //Phương thức này được ánh xạ với yêu cầu HTTP GET (hiển thị) đến đường dẫn "/userList"
    public String getAllUsers(Model model){
        List<User> userList=userService.getAllUsers();
        model.addAttribute("users",userList); //lấy danh sách User từ CSDL rồi chuyển vào mô hình Model
        return "userList"; //trả về view có tên userList.html
    }

    @GetMapping("/addUser") //Phương thức này được ánh xạ với yêu cầu HTTP GET (hiển thị) đến đường dẫn "/addUser"
    public String showFormAddUser(Model model){
        model.addAttribute("user",new User()); //Nó tạo một đối tượng User mới và chuyển nó vào mô hình Model sẽ được sử dụng trong form để nhập thông tin người dùng
        return "addUser"; //trả về view có tên addUser.html
    }

    @PostMapping("/addUser") //Phương thức này được ánh xạ với yêu cầu HTTP POST (thêm) đến đường dẫn "/addUser"
    public String addUser(@ModelAttribute User user){ //ánh xạ dữ liệu từ yêu cầu (request) vào đối tượng User và đặt nó vào tham số user.
        userService.addUser(user); //sau khi User được ánh xạ dữ liệu, nó được chuyển cho userService để thêm người dùng vào cơ sở dữ liệu
        return "redirect:/userList"; // Sau khi thêm, nó chuyển hướng người dùng đến "/userList"
    }

    @GetMapping("/deleteUser/{id}") //Đây là một phương thức được ánh xạ với các yêu cầu HTTP GET đến đường dẫn "/deleteUser/{id}".
    public String showFormDeleteUser(@PathVariable(name = "id") Long id, Model model){
        //@PathVariable(name = "id") Long id: Annotation này trích xuất giá trị của biến đường dẫn {id} và đặt giá trị vào biến id.
        User user = userService.findUserByID(id).get(0); //.get(0) là để lấy phần tử đầu tiên trong danh sách người dùng trả về.
        model.addAttribute("user",user); //Thêm thuộc tính "user" vào model để có thể sử dụng trong template Thymeleaf
        return "deleteUser"; //Chuyển hướng người dùng đến trang "deleteUser" để hiển thị thông tin về người dùng cần xóa.
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id){ //trích xuất giá trị của biến đường dẫn {id} và đặt giá trị vào biến id.
        userService.deleteUser(id); //xóa người dùng với id tương ứng
        return "redirect:/userList"; //chuyển hướng người dùng đến trang "/userList" sau khi xóa người dùng thành công.
    }

    @GetMapping("/updateUser/{id}") //Đây là một phương thức được ánh xạ với các yêu cầu HTTP GET đến đường dẫn "/updateUser/{id}"
    public String showFormUpdateUser(@PathVariable(name = "id") Long id, Model model){ //Trích xuất giá trị của biến đường dẫn {id} và đặt giá trị vào biến id.
        User user = userService.findUserByID(id).get(0); //lấy phần tử đầu tiên trong danh sách người dùng trả về
        model.addAttribute("user", user); //Thêm thuộc tính "user" vào model để có thể sử dụng trong template Thymeleaf
        return "updateUser"; //Chuyển hướng người dùng đến trang "updateUser" để hiển thị thông tin về người dùng cần sửa
    }

    @PostMapping("/updateUser/{id}") //Đây là một phương thức được ánh xạ với các yêu cầu HTTP POST đến đường dẫn "/updateUser/{id}".
    public String updateUser (User user){
        userService.updateUser(user); //cập nhật thông tin người dùng.
        return "redirect:/userList"; // chuyển hướng người dùng đến trang "/userList" sau khi sửa người dùng thành công.
    }
}
