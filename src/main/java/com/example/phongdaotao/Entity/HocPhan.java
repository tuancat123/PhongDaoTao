package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_hocphan")
public class HocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maHp", nullable = false, length = 50)
    private String maHp;

    @Column(name = "tenHp", nullable = false, length = 255)
    private String tenHp;

    @Column(name = "soTinChi")
    private int soTinChi;

    @Column(name = "soTietLyThuyet")
    private int soTietLyThuyet;

    @Column(name = "soTietThucHanh")
    private int soTietThucHanh;

    @Column(name = "nhomId")
    private Integer nhomId;

    @Column(name = "loaiHp", length = 50)
    private String loaiHp;

    @Column(name = "hocPhanTienQuyet", length = 255)
    private String hocPhanTienQuyet;




    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getSoTietThucHanh() {
        return soTietThucHanh;
    }

    public void setSoTietThucHanh(int soTietThucHanh) {
        this.soTietThucHanh = soTietThucHanh;
    }

    public Integer getNhomId() {
        return nhomId;
    }

    public void setNhomId(Integer nhomId) {
        this.nhomId = nhomId;
    }

    public String getLoaiHp() {
        return loaiHp;
    }

    public void setLoaiHp(String loaiHp) {
        this.loaiHp = loaiHp;
    }

    public String getHocPhanTienQuyet() {
        return hocPhanTienQuyet;
    }

    public void setHocPhanTienQuyet(String hocPhanTienQuyet) {
        this.hocPhanTienQuyet = hocPhanTienQuyet;
    }
}
