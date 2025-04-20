package com.example.phongdaotao.Service;
import com.example.phongdaotao.Entity.KeHoachMoNhom;
import com.example.phongdaotao.Repository.KeHoachMoNhomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeHoachMoNhomService {

    @Autowired
    private KeHoachMoNhomRepository repository;

    public List<KeHoachMoNhom> getAll() {
        return repository.findAll();
    }

    public void save(KeHoachMoNhom keHoach) {
        repository.save(keHoach);
    }

    public KeHoachMoNhom getById(int id) {
        Optional<KeHoachMoNhom> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}