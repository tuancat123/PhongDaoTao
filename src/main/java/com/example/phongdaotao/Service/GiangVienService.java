package com.example.phongdaotao.Service;


import com.example.phongdaotao.Entity.GiangVien;
import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Repository.GiangVienRepository;
import com.example.phongdaotao.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiangVienService {

    private final GiangVienRepository repository;

    public GiangVienService(GiangVienRepository repository) {
        this.repository = repository;
    }

    public List<GiangVien> getAllGiangVien() {
        return repository.findAll();
    }

    // Lưu hoặc cập nhật giảng viên
    public void saveGiangVien(GiangVien giangVien) {
        repository.save(giangVien);
    }

    // Lấy thông tin giảng viên theo ID
    public GiangVien getGiangVienById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteGiangVienById(int id) {
        repository.deleteById(id);
    }

    public long countAllGiangVien(){
        return repository.count();
    }

    public List<Object[]> countGiangVienByKhoa(){
        return repository.countByKhoa();
    }

    public long countGiangVien(){
        return repository.count();
    }


}

