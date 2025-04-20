package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.ThongTinChung;
import com.example.phongdaotao.Service.ThongTinChungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/thongtinchung")
public class ThongTinChungController {

    @Autowired
    private ThongTinChungService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("listThongTinChung", service.getAll());
        return "thongtinchung";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("ttc", new ThongTinChung());
        return "add-thongtinchung";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("ttc", service.getById(id));
        return "add-thongtinchung";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("ttc") ThongTinChung ttc) {
        service.save(ttc);
        return "redirect:/thongtinchung";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/thongtinchung";
    }
}
