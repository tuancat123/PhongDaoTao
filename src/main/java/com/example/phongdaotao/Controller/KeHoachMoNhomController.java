package com.example.phongdaotao.Controller;

import org.springframework.ui.Model;
import com.example.phongdaotao.Entity.KeHoachMoNhom;
import com.example.phongdaotao.Service.KeHoachMoNhomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kehoachmonhom")
public class KeHoachMoNhomController {

    @Autowired
    private KeHoachMoNhomService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("keHoachMoNhomList", service.getAll());
        return "kehoachmonhom";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("keHoach", new KeHoachMoNhom());
        return "add-kehoachmonhom";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("keHoach", service.getById(id));
        return "add-kehoachmonhom";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("keHoach") KeHoachMoNhom keHoach) {
        service.save(keHoach);
        return "redirect:/kehoachmonhom";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/kehoachmonhom";
    }
}

