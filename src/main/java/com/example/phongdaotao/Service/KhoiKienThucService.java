package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.KhoiKienThuc;
import com.example.phongdaotao.Repository.KhoiKienThucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KhoiKienThucService {

    @Autowired
    private KhoiKienThucRepository repository;

    public List<KhoiKienThuc> getAll() {
        return repository.findAll();
    }

    public KhoiKienThuc getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void save(KhoiKienThuc nkt) {
        repository.save(nkt);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    // Thống kê số tín chỉ
    public List<Map<String, Object>> thongKeSoTinChi() {
        List<Object[]> rawData = repository.thongKeSoTinChi();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rawData) {
            Map<String, Object> map = new HashMap<>();
            int batBuoc = ((Number) row[1]).intValue();
            int tuChon = ((Number) row[2]).intValue();
            int tong = batBuoc + tuChon;

            map.put("tenNhom", row[0]);
            map.put("soTinChiBatBuoc", batBuoc);
            map.put("soTinChiTuChon", tuChon);
            map.put("tongSoTinChi", tong);
            result.add(map);
        }

        return result;
    }

}
