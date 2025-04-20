package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.KhoiKienThuc;
import com.example.phongdaotao.Repository.KhoiKienThucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
