package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.GiangVien;
import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Service.GiangVienService;
import com.example.phongdaotao.Service.HocPhanService;
import com.example.phongdaotao.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private HocPhanService hocPhanService;

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showDashboard(Model model) {
        model.addAttribute("hocPhanCount", hocPhanService.countHocPhan());
        model.addAttribute("giangVienCount", giangVienService.countGiangVien());
        model.addAttribute("userCount", userService.countUsers());
        return "index";
    }

    @GetMapping("/index")
    public String adminPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !"Admin".equals(user.getVaiTro())) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/home-giangvien")
    public String giangVienPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !"Giảng viên".equals(user.getVaiTro())) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "home-giangvien";
    }

    @GetMapping("home-giangvien/thongtin")
    public String thongTinGiangVien(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "thongtin";
    }
}
