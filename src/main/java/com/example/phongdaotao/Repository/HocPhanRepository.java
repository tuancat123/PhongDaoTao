package com.example.phongdaotao.Repository;

import com.example.phongdaotao.Entity.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HocPhanRepository extends JpaRepository<HocPhan, Integer>{

    //List<HocPhan> findByNhomId(int nhomId);
    List<HocPhan> findByNhomKienThuc_Id(int nhomId);

    @Query("SELECT h FROM HocPhan h WHERE LOWER(h.tenHp) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(h.maHp) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<HocPhan> searchByKeyword(@Param("keyword") String keyword);






}
