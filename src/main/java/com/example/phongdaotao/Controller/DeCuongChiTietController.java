package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.DeCuongChiTiet;
import com.example.phongdaotao.Service.DeCuongChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/decuongchitiet")
public class DeCuongChiTietController {

    @Autowired
    private DeCuongChiTietService service;

    @GetMapping
    public String listDeCuongChiTiet(Model model) {
        model.addAttribute("DeCuongChiTietList", service.getAll());
        return "decuongchitiet";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dcct", new DeCuongChiTiet());
        return "add-decuongchitiet";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditForm(@PathVariable int id, Model model) {
        model.addAttribute("dcct", service.getById(id));
        return "add-decuongchitiet";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("dcct") DeCuongChiTiet dcct) {
        service.save(dcct);
        return "redirect:/decuongchitiet";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/decuongchitiet";
    }
}
