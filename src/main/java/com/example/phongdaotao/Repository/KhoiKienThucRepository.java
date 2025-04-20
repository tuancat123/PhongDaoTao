package com.example.phongdaotao.Repository;

import com.example.phongdaotao.Entity.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoiKienThucRepository extends JpaRepository<KhoiKienThuc, Integer> {
}

