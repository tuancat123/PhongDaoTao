package com.example.phongdaotao.Service;


import com.example.phongdaotao.Entity.User;
import com.example.phongdaotao.Entity.GiangVien;
import com.example.phongdaotao.Repository.UserRepository;
import com.example.phongdaotao.Repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void saveUser(User user) {userRepository.save(user);}

    // Xóa người dùng theo ID
    public void deleteUserById(int id) {userRepository.deleteById(id);}


    // Lấy người dùng theo ID (phục vụ edit)
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    // Cập nhật người dùng
    public void updateUser(User user) {userRepository.save(user); }

    public List<User> getUsersNotAssignedToGiangVien() {
        List<User> allUsers = userRepository.findAll();
        List<Integer> usedUserIds = giangVienRepository.findAll()
                .stream()
                .map(GiangVien::getUserId)
                .collect(Collectors.toList());

        return allUsers.stream()
                .filter(user -> !usedUserIds.contains(user.getId()))
                .collect(Collectors.toList());
    }

    public long countUsers(){
        return userRepository.count();
    }
}

