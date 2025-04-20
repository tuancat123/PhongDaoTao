package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "ctdt_kehoachmonhom")
public class KeHoachMoNhom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String maNhom;

    private String hocPhanId;
    private String namHoc;

    private int hocKy;
    private int siSo;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private String trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNhomLop() {
        return maNhom;
    }
    public void setMaNhomLop(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getHocPhanId() {
        return hocPhanId;
    }
    public void setHocPhanId(String hocPhanId) {
        this.hocPhanId = hocPhanId;
    }

    public String getNamHoc() {
        return namHoc;
    }
    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getHocKy(){return hocKy;}
    public void setHocKy(int hocKy){this.hocKy = hocKy;}

    public int getSiSo() {
        return siSo;
    }
    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public Date getThoiGianBatDau(){return thoiGianBatDau;}
    public void setThoiGianBatDau(Date thoiGianBatDau){this.thoiGianBatDau = thoiGianBatDau;}

    public Date getThoiGianKetThuc(){return thoiGianKetThuc;}
    public void setThoiGianKetThuc(Date thoiGianKetThuc){this.thoiGianKetThuc = thoiGianKetThuc;}

    public String getTrangThai(){return trangThai;}
    public void setTrangThai(String trangThai){this.trangThai = trangThai;}
}


