package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_decuongchitiet")
public class DeCuongChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String hocPhanId;

    @Column(columnDefinition = "TEXT")
    private String mucTieu;

    @Column(columnDefinition = "TEXT")
    private String noiDung;

    @Column(columnDefinition = "TEXT")
    private String phuongPhapGiangDay;

    @Column(columnDefinition = "TEXT")
    private String taiLieuThamKhao;

    @Column(columnDefinition = "TEXT")
    private String TrangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHocPhanId() {
        return hocPhanId;
    }

    public void setHocPhanId(String hocPhanId) {
        this.hocPhanId = hocPhanId;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTaiLieuThamKhao() {
        return taiLieuThamKhao;
    }

    public void setTaiLieuThamKhao(String taiLieuThamKhao) {
        this.taiLieuThamKhao = taiLieuThamKhao;
    }

    public String getPhuongPhapGiangDay() { return phuongPhapGiangDay; }

    public void setPhuongPhapGiangDay(String phuongPhapGiangDay) { this.phuongPhapGiangDay = phuongPhapGiangDay; }

    public String getMucTieu() { return mucTieu; }

    public void setMucTieu(String mucTieu) { this.mucTieu = mucTieu; }

    public String getTrangThai() { return TrangThai; }

    public void setTrangThai(String trangThai) { TrangThai = trangThai; }
}

