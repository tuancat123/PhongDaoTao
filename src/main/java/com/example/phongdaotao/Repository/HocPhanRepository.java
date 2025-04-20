package com.example.phongdaotao.Repository;

import com.example.phongdaotao.Entity.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HocPhanRepository extends JpaRepository<HocPhan, Integer>{

//    List<HocPhan> findByNhomId(int nhomId); //



}
