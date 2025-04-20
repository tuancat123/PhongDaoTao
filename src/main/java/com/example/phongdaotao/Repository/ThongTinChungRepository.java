package com.example.phongdaotao.Repository;

import com.example.phongdaotao.Entity.ThongTinChung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinChungRepository extends JpaRepository<ThongTinChung, Integer> {
}
