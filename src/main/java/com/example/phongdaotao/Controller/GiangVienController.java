package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.GiangVien;
import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Service.GiangVienService;
import com.example.phongdaotao.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GiangVienController {

    private final GiangVienService service;

    public GiangVienController(GiangVienService service) {
        this.service = service;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/giangvien")
    public String showGiangVienList(Model model) {
        model.addAttribute("giangviens", service.getAllGiangVien());
        return "giangvien";
    }
    // Hiển thị form thêm giảng viên
    @GetMapping("/giangvien/add")
    public String showAddForm(Model model) {
        model.addAttribute("giangvien", new GiangVien());

        // Lấy danh sách user chưa có giảng viên
        List<User> availableUsers = userService.getUsersNotAssignedToGiangVien();
        model.addAttribute("users", availableUsers);

        return "add-giangvien";
    }

    // Lưu giảng viên (thêm mới hoặc cập nhật)
    @PostMapping("/giangvien/add")
    public String saveGiangVien(@ModelAttribute("giangvien") GiangVien giangVien) {
        service.saveGiangVien(giangVien);
        return "redirect:/giangvien";
    }

    // Hiển thị form sửa giảng viên
    @GetMapping("/giangvien/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        GiangVien giangVien = service.getGiangVienById(id);
        if (giangVien == null) {
            // Nếu không tìm thấy, có thể chuyển hướng hoặc báo lỗi
            return "redirect:/giangvien";
        }
        model.addAttribute("giangvien", giangVien);
        return "add-giangvien"; // Dùng lại form thêm
    }

    // Xóa giảng viên
    @GetMapping("/giangvien/delete/{id}")
    public String deleteGiangVien(@PathVariable("id") int id) {
        service.deleteGiangVienById(id);
        return "redirect:/giangvien";
    }


}

