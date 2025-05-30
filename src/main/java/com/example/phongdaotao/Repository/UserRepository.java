package com.example.phongdaotao.Repository;


import com.example.phongdaotao.Entity.GiangVien;
import com.example.phongdaotao.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}

