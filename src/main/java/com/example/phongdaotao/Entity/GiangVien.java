package com.example.phongdaotao.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "ctdt_giangvien")
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "maGiangvien")
    private String maGv;

    @Column(name = "hoTen")
    private String hoTen;

//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "soDienThoai")
//    private String soDienThoai;

    @Column(name = "hocVi")
    private String hocVi;

    @Column(name = "hocHam")
    private String hocHam;

    @Column(name = "trinhDo")
    private String trinhDo;

    @Column(name = "donViCongTac")
    private String donViCongTac;

    @Column(name = "trangThai")
    private String trangThai;



    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSoDienThoai() {
//        return soDienThoai;
//    }
//
//    public void setSoDienThoai(String soDienThoai) {
//        this.soDienThoai = soDienThoai;
//    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getDonViCongTac() {
        return donViCongTac;
    }

    public void setDonViCongTac(String donViCongTac) {
        this.donViCongTac = donViCongTac;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
