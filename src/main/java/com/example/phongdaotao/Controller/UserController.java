package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user"; // user.html
    }

    // Hiển thị form thêm người dùng
    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User()); // tạo object user rỗng
        return "add-user"; // trỏ đến file add-user.html
    }
    // Xử lý khi submit form
    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users"; // quay lại trang danh sách người dùng
    }

    // Xóa người dùng
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    // GET hiển thị form sửa (cũng dùng add-user.html)
    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "add-user";
    }

    // POST lưu hoặc cập nhật
    @PostMapping("/users/saveOrEdit")
    public String saveOrEditUser(@ModelAttribute("user") User user) {
        userService.saveUser(user); // có ID thì update, không có thì insert
        return "redirect:/users";
    }
}

