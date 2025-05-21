package com.example.phongdaotao.Entity;

import java.util.List;

public class PhanCongThongKe {
    private String maCB;
    private String hoTenGV;
    private int namSinh;
    private String hocVi;
    private String tenHocPhan;
    private String maHp;
    private int soTinChi;
    private int soTiet;
    private int soLop;
    private List<Integer> giangDayHocKy; // ví dụ [1,2] nếu dạy kỳ 1 và 2
    private int tongTietGiangDay;
    private String congTacKhac;
    private double tongCLC;
    private double tongCongTac;

    // Getters and Setters
    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getHoTenGV() {
        return hoTenGV;
    }

    public void setHoTenGV(String hoTenGV) {
        this.hoTenGV = hoTenGV;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public int getSoLop() {
        return soLop;
    }

    public void setSoLop(int soLop) {
        this.soLop = soLop;
    }

    public List<Integer> getGiangDayHocKy() {
        return giangDayHocKy;
    }

    public void setGiangDayHocKy(List<Integer> giangDayHocKy) {
        this.giangDayHocKy = giangDayHocKy;
    }

    public int getTongTietGiangDay() {
        return tongTietGiangDay;
    }

    public void setTongTietGiangDay(int tongTietGiangDay) {
        this.tongTietGiangDay = tongTietGiangDay;
    }

    public String getCongTacKhac() {
        return congTacKhac;
    }

    public void setCongTacKhac(String congTacKhac) {
        this.congTacKhac = congTacKhac;
    }

    public double getTongCLC() {
        return tongCLC;
    }

    public void setTongCLC(double tongCLC) {
        this.tongCLC = tongCLC;
    }

    public double getTongCongTac() {
        return tongCongTac;
    }

    public void setTongCongTac(double tongCongTac) {
        this.tongCongTac = tongCongTac;
    }
}

