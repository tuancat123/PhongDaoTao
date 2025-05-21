package com.example.phongdaotao.Repository;
import com.example.phongdaotao.Entity.PhanCongGiangDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhanCongGiangDayRepository extends JpaRepository<PhanCongGiangDay, Integer> {

    int countByGiangVienId(Integer giangVienId);

    List<PhanCongGiangDay> findByGiangVienId(Integer giangVienId);
}
