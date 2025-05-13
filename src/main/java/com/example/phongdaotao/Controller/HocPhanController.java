package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.HocPhan;
import com.example.phongdaotao.Entity.KhoiKienThuc;
import com.example.phongdaotao.Service.HocPhanService;
import com.example.phongdaotao.Service.KhoiKienThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HocPhanController {

    @Autowired
    private HocPhanService hocPhanService;
    @Autowired
    private KhoiKienThucService khoiKienThucService;

    @GetMapping("/hocphan")
    public String showHocPhanList(Model model) {
        List<HocPhan> list = hocPhanService.getAllHocPhan();
        List<KhoiKienThuc> nhomList = khoiKienThucService.getAll(); // cần service này
        model.addAttribute("hocphanList", list);
        model.addAttribute("nhomList", nhomList);
        return "hocphan";
    }

    @GetMapping("/hocphan/nhom")
    public String getHocPhanTheoNhom(@RequestParam("nhomId") int nhomId, Model model) {
        List<HocPhan> list = hocPhanService.getHocPhanTheoNhom(nhomId);
        List<KhoiKienThuc> nhomList = khoiKienThucService.getAll();
        model.addAttribute("hocphanList", list);
        model.addAttribute("nhomList", nhomList);
        return "hocphan";
    }


    // Hiển thị form thêm mới
    @GetMapping("/hocphan/add")
    public String showAddForm(Model model) {
        model.addAttribute("hocphan", new HocPhan());
        return "add-hocphan";
    }

    // Lưu học phần (thêm hoặc cập nhật)
    @PostMapping("/hocphan/save")
    public String saveHocPhan(@ModelAttribute("hocphan") HocPhan hocPhan) {
        hocPhanService.saveHocPhan(hocPhan);
        return "redirect:/hocphan";
    }

    // Hiển thị form sửa
    @GetMapping("/hocphan/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        if (hocPhan == null) {
            return "redirect:/hocphan";
        }
        model.addAttribute("hocphan", hocPhan);
        return "add-hocphan"; // dùng chung form với thêm
    }

    // Xóa học phần
    @GetMapping("/hocphan/delete/{id}")
    public String deleteHocPhan(@PathVariable("id") int id) {
        hocPhanService.deleteHocPhanById(id);
        return "redirect:/hocphan";
    }

    @GetMapping("/hocphan/search")
    public String searchHocPhan(@RequestParam("keyword") String keyword, Model model) {
        List<HocPhan> list = hocPhanService.searchHocPhan(keyword);
        List<KhoiKienThuc> nhomList = khoiKienThucService.getAll();
        model.addAttribute("hocphanList", list);
        model.addAttribute("nhomList", nhomList);
        model.addAttribute("keyword", keyword);
        return "hocphan";
    }



}


