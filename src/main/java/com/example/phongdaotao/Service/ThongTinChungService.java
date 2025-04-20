package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.ThongTinChung;
import com.example.phongdaotao.Repository.ThongTinChungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongTinChungService {

    @Autowired
    private ThongTinChungRepository repository;

    public List<ThongTinChung> getAll() {
        return repository.findAll();
    }

    public void save(ThongTinChung entity) {
        repository.save(entity);
    }

    public ThongTinChung getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
