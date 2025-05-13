package com.example.phongdaotao.Controller;

import com.example.phongdaotao.Entity.PhanCongGiangDay;
import com.example.phongdaotao.Service.PhanCongGiangDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phanconggiangday")
public class PhanCongController {

    @Autowired
    private PhanCongGiangDayService phanCongGiangDayService;

    @GetMapping
    public String getAll(Model model) {
        List<PhanCongGiangDay> list = phanCongGiangDayService.getAll();
        model.addAttribute("phanCongList", list);
        return "phanconggiangday";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phanCong", new PhanCongGiangDay());
        return "add-phanconggiangday";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("phanCong") PhanCongGiangDay phanCong) {
        phanCongGiangDayService.save(phanCong);
        return "redirect:/phanconggiangday";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        PhanCongGiangDay phanCong = phanCongGiangDayService.getById(id);
        if (phanCong != null) {
            model.addAttribute("phanCong", phanCong);
            return "add-phanconggiangday";
        } else {
            return "redirect:/phanconggiangday";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        phanCongGiangDayService.delete(id);
        return "redirect:/phanconggiangday";
    }

}
