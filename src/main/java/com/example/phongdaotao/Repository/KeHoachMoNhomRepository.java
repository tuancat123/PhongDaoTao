package com.example.phongdaotao.Repository;
import com.example.phongdaotao.Entity.KeHoachMoNhom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeHoachMoNhomRepository extends JpaRepository<KeHoachMoNhom, Integer>{
}
