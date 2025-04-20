package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.KeHoachDayHoc;
import com.example.phongdaotao.Service.KeHoachDayHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kehoachdayhoc")
public class KeHoachDayHocController {

    @Autowired
    private KeHoachDayHocService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("keHoachList", service.getAll());
        return "kehoachdayhoc";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("keHoach", new KeHoachDayHoc());
        return "add-kehoachdayhoc";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("keHoach", service.getById(id));
        return "add-kehoachdayhoc";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("keHoach") KeHoachDayHoc khdh) {
        service.save(khdh);
        return "redirect:/kehoachdayhoc";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/kehoachdayhoc";
    }
}
