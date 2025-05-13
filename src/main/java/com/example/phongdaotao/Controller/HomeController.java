package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Service.GiangVienService;
import com.example.phongdaotao.Service.HocPhanService;
import com.example.phongdaotao.Service.UserService;
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
}
