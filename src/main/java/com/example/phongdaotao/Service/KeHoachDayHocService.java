package com.example.phongdaotao.Service;
import com.example.phongdaotao.Entity.KeHoachDayHoc;
import com.example.phongdaotao.Repository.KeHoachDayHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeHoachDayHocService {

    @Autowired
    private KeHoachDayHocRepository repository;

    public List<KeHoachDayHoc> getAll() {
        return repository.findAll();
    }

    public void save(KeHoachDayHoc khdh) {
        repository.save(khdh);
    }

    public KeHoachDayHoc getById(int id) {
        Optional<KeHoachDayHoc> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
