package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.GiangVien;
import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Repository.UserRepository;
import com.example.phongdaotao.Service.PhanCongGiangDayService;
import com.example.phongdaotao.Repository.GiangVienRepository;
import com.example.phongdaotao.Repository.PhanCongGiangDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;
@Controller
public class Home_GvController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GiangVienRepository giangVienRepository;
    @Autowired
    private PhanCongGiangDayRepository phanCongGiangDayRepository;
    @Autowired
    private PhanCongGiangDayService phanCongGiangDayService;
    @GetMapping("/home_GV")
    public String giangVienHome(Model model, Principal principal) {
        String username = principal.getName(); // Lấy username đang đăng nhập
        User user = userRepository.findByUsername(username);

        GiangVien gv = giangVienRepository.findByUserId(user.getId());
        if(gv == null){
            return "redirect:/error";
        }
        int soLop = phanCongGiangDayRepository.countByGiangVienId(gv.getId());
        int tongTiet = phanCongGiangDayService.tinhTongTietGiangDay(gv.getId());
        // Tính theo số tiết lý thuyết + thực hành

        model.addAttribute("giangVienTen", gv.getHoTen());
        model.addAttribute("soLuongPhanCong", soLop);
        model.addAttribute("tongTiet", tongTiet);

        return "home-giangvien";
    }


}
