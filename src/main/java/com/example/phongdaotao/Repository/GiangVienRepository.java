package com.example.phongdaotao.Repository;


import com.example.phongdaotao.Entity.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GiangVienRepository extends JpaRepository<GiangVien, Integer> {// Đếm tổng số giảng viên
    long count();

    // Thống kê giảng viên theo khoa
    @Query("SELECT g.khoa, COUNT(g) FROM GiangVien g GROUP BY g.khoa")
    List<Object[]> countByKhoa();



}

