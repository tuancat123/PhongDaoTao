package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.HocPhan;
import com.example.phongdaotao.Repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    public List<HocPhan> getAllHocPhan() {
        return hocPhanRepository.findAll();
    }

    // Lưu học phần (thêm mới hoặc cập nhật)
    public void saveHocPhan(HocPhan hocPhan) {hocPhanRepository.save(hocPhan);}

    // Lấy học phần theo ID (phục vụ sửa)
    public HocPhan getHocPhanById(int id) {return hocPhanRepository.findById(id).orElse(null);}

    // Xóa học phần theo ID
    public void deleteHocPhanById(int id) {hocPhanRepository.deleteById(id);}

//    public List<HocPhan> getHocPhanTheoNhom(int nhomId) {
//        return hocPhanRepository.findByNhomId(nhomId);
//    }

}

