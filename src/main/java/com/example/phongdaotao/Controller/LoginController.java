package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // Hiển thị form login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        // Kiểm tra user tồn tại
        for (User user : userService.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // ✅ Đăng nhập thành công
                return "redirect:/";
            }
        }

        // ❌ Đăng nhập thất bại
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
        return "login";
    }
}
