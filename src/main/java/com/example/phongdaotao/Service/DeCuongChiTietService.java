package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.DeCuongChiTiet;
import com.example.phongdaotao.Repository.DeCuongChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeCuongChiTietService {
    @Autowired
    private DeCuongChiTietRepository repository;
    public DeCuongChiTietService(DeCuongChiTietRepository repository) {this.repository = repository;}

    public List<DeCuongChiTiet> getAll() {
        return repository.findAll();
    }
    public void save(DeCuongChiTiet entity) {
        repository.save(entity);
    }
    public DeCuongChiTiet getById(int id) {
        return repository.findById(id).orElse(null);
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
