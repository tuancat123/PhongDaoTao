package com.example.phongdaotao.Service;

import com.example.phongdaotao.Entity.*;
import com.example.phongdaotao.Repository.GiangVienRepository;
import com.example.phongdaotao.Repository.HocPhanRepository;
import com.example.phongdaotao.Repository.KeHoachMoNhomRepository;
import com.example.phongdaotao.Repository.PhanCongGiangDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PhanCongGiangDayService {
    private final PhanCongGiangDayRepository repository;
    private final GiangVienRepository giangVienRepository;
    private final KeHoachMoNhomRepository keHoachMoNhomRepository;
    private final HocPhanRepository hocPhanRepository;

    @Autowired
    public PhanCongGiangDayService(
            PhanCongGiangDayRepository repository,
            GiangVienRepository giangVienRepository,
            KeHoachMoNhomRepository keHoachMoNhomRepository,
            HocPhanRepository hocPhanRepository
    ) {
        this.repository = repository;
        this.giangVienRepository = giangVienRepository;
        this.keHoachMoNhomRepository = keHoachMoNhomRepository;
        this.hocPhanRepository = hocPhanRepository;
    }

    public List<PhanCongGiangDay> getAll(){
        return repository.findAll();
    }

    public PhanCongGiangDay getById(int id){
        return repository.findById(id).orElse(null);
    }

    public void save(PhanCongGiangDay phancong){
        repository.save(phancong);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<PhanCongThongKe> thongKePhanCong() {
        List<PhanCongGiangDay> danhSach = repository.findAll();

        Map<Integer, List<PhanCongGiangDay>> theoGiangVien = danhSach.stream()
                .collect(Collectors.groupingBy(PhanCongGiangDay::getGiangVienId));

        List<PhanCongThongKe> ketQua = new ArrayList<>();

        for (Map.Entry<Integer, List<PhanCongGiangDay>> entry : theoGiangVien.entrySet()) {
            Integer giangVienId = entry.getKey();
            List<PhanCongGiangDay> danhSachGV = entry.getValue();

            // Dữ liệu giảng viên
            GiangVien gv = giangVienRepository.findById(giangVienId).orElse(null);
            if (gv == null) continue;

            for (PhanCongGiangDay pc : danhSachGV) {
                PhanCongThongKe dto = new PhanCongThongKe();
                dto.setMaCB(String.valueOf(gv.getId())); // Hoặc mã riêng nếu có
                dto.setHoTenGV(gv.getHoTen());
                dto.setHocVi(gv.getHocVi());

                // Lấy thông tin học phần từ nhóm
                KeHoachMoNhom nhom = keHoachMoNhomRepository.findById(pc.getNhomId()).orElse(null);
                if (nhom != null) {
                    HocPhan hp = hocPhanRepository.findById(nhom.getHocPhanId()).orElse(null);
                    if (hp != null) {
                        dto.setTenHocPhan(hp.getTenHp());
                        dto.setMaHp(hp.getMaHp());
                        dto.setSoTinChi(hp.getSoTinChi());
                        dto.setSoTiet(hp.getSoTietLyThuyet() + hp.getSoTietThucHanh());
                    }
                    dto.setSoLop(1); // nếu chưa có trường số lớp thì mặc định 1
                }

                // TODO: xử lý học kỳ, tiết, công tác khác nếu có
                dto.setTongTietGiangDay(dto.getSoTiet() * dto.getSoLop());
                dto.setTongCLC(0); // chưa có công thức
                dto.setTongCongTac(dto.getTongTietGiangDay()); // tạm thời = tiết dạy

                ketQua.add(dto);
            }
        }

        return ketQua;
    }

    public int tinhTongTietGiangDay(int giangVienId) {
        List<PhanCongGiangDay> danhSach = repository.findByGiangVienId(giangVienId);
        int tongTiet = 0;

        for (PhanCongGiangDay pc : danhSach) {
            // Lấy nhóm để tìm học phần
            KeHoachMoNhom nhom = keHoachMoNhomRepository.findById(pc.getNhomId()).orElse(null);
            if (nhom != null) {
                HocPhan hp = hocPhanRepository.findById(nhom.getHocPhanId()).orElse(null);
                if (hp != null) {
                    tongTiet += hp.getSoTietLyThuyet() + hp.getSoTietThucHanh();
                }
            }
        }

        return tongTiet;
    }


}
