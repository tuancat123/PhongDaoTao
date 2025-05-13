package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.PhanCongGiangDay;
import com.example.phongdaotao.Repository.PhanCongGiangDayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhanCongGiangDayService {
    private PhanCongGiangDayRepository repository;

    public PhanCongGiangDayService(PhanCongGiangDayRepository repository){ this.repository = repository;}

    public List<PhanCongGiangDay> getAll(){
        return repository.findAll();
    }

    public PhanCongGiangDay getById(int id){
        return repository.findById(id).orElse(null);
    }

    public void save(PhanCongGiangDay phancong){
        repository.save(phancong);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
