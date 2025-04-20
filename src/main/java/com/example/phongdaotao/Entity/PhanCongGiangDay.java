package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_phanconggiangday")
public class PhanCongGiangDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String namHoc;
    private String maHocPhan;
    private String maGiangVien;
    private String maNhomLop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getMaNhomLop() {
        return maNhomLop;
    }

    public void setMaNhomLop(String maNhomLop) {
        this.maNhomLop = maNhomLop;
    }
}

