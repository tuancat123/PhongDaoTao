package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Service.UserService;
import jakarta.servlet.http.HttpSession;
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
            HttpSession session,
            Model model
    ) {
        for (User user : userService.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("loggedInUser", user); // Lưu user vào session
                session.setAttribute("userId", user.getId());


                // Điều hướng theo vai trò
                if ("Admin".equals(user.getVaiTro())) {
                    return "redirect:/index";
                } else {
                    return "redirect:/home-giangvien";
                }
            }
        }

        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa toàn bộ session hiện tại
        return "redirect:/login"; // Quay lại trang login
    }


}
