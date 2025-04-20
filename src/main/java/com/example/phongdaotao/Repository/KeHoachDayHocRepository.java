package com.example.phongdaotao.Repository;

import com.example.phongdaotao.Entity.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, Integer> {
}
