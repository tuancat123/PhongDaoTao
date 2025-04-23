package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.KhoiKienThuc;
import com.example.phongdaotao.Service.KhoiKienThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/khoikienthuc")
public class KhoiKienThucController {

    @Autowired
    private KhoiKienThucService service;

    @GetMapping
    public String listNhomKienThuc(Model model) {
        model.addAttribute("khoiKienThucList", service.getAll());
        return "khoikienthuc";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nkt", new KhoiKienThuc());
        return "add-KhoiKienThuc";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("nkt", service.getById(id));
        return "add-KhoiKienThuc";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("nkt") KhoiKienThuc nkt) {
        service.save(nkt);
        return "redirect:/khoikienthuc";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/khoikienthuc";
    }

    @GetMapping("/thongke")
    public String thongKeSoTinChi(Model model) {
        model.addAttribute("thongKeList", service.thongKeSoTinChi());
        return "thongke-tinchi";
    }

}
