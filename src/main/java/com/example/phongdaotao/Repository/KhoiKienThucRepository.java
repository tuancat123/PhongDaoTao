package com.example.phongdaotao.Repository;

import com.example.phongdaotao.Entity.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoiKienThucRepository extends JpaRepository<KhoiKienThuc, Integer> {

    @Query("SELECT n.tenNhom, " +
            "SUM(CASE WHEN h.loaiHp = 'Bắt buộc' THEN h.soTinChi ELSE 0 END), " +
            "SUM(CASE WHEN h.loaiHp = 'Tự chọn' THEN h.soTinChi ELSE 0 END) " +
            "FROM HocPhan h JOIN h.nhomKienThuc n " +
            "GROUP BY n.tenNhom")
    List<Object[]> thongKeSoTinChi();

}

