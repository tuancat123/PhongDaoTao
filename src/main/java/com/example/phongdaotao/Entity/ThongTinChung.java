package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_thongTinChung")
public class ThongTinChung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maCtdt", unique = true, length = 50)
    private String maCtdt;

    @Column(name = "tenCtdt", nullable = false, length = 255)
    private String tenCtdt;

    @Column(name = "nganh", length = 100)
    private String nganh;

    @Column(name = "maNganh", length = 50)
    private String maNganh;

    @Column(name = "khoaQuanLy", length = 100)
    private String khoaQuanLy;

    @Column(name = "heDaoTao", length = 50)
    private String heDaoTao;

    @Column(name = "trinhDo", length = 50)
    private String trinhDo;

    @Column(name = "tongTinChi")
    private Integer tongTinChi;

    @Column(name = "thoiGianDaoTao", length = 50)
    private String thoiGianDaoTao;

    @Column(name = "namBanHanh")
    private Integer namBanHanh;

    @Column(name = "trangThai", length = 20)
    private String trangThai;

    // Getters & Setters (có thể dùng Lombok để gọn hơn)
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMaCtdt(){
        return maCtdt;
    }

    public void setMaCtdt(String maCtdt){
        this.maCtdt = maCtdt;
    }

    public String getTenCtdt(){
        return tenCtdt;
    }

    public void setTenCtdt(String tenCtdt){
        this.tenCtdt = tenCtdt;
    }

    public String getNganh(){
        return nganh;
    }

    public void setNganh(String nganh){
        this.nganh = nganh;
    }

    public String getMaNganh(){
        return maNganh;
    }

    public void setMaNganh(String maNganh){
        this.maNganh = maNganh;
    }

    public String getKhoaQuanLy(){
        return khoaQuanLy;
    }

    public void setKhoaQuanLy(String khoaQuanLy){
        this.khoaQuanLy = khoaQuanLy;
    }

    public String getHeDaoTao(){
        return heDaoTao;
    }

    public void setHeDaoTao(String heDaoTao){
        this.heDaoTao = heDaoTao;
    }

    public String getTrinhDo(){
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo){
        this.trinhDo = trinhDo;
    }

    public Integer getTongTinChi(){
        return tongTinChi;
    }

    public void setTongTinChi(Integer tongTinChi){
        this.tongTinChi = tongTinChi;
    }

    public String getThoiGianDaoTao(){
        return thoiGianDaoTao;
    }

    public void setThoiGianDaoTao(String thoiGianDaoTao){
        this.thoiGianDaoTao = thoiGianDaoTao;
    }

    public Integer getNamBanHanh(){
        return namBanHanh;
    }

    public void setNamBanHanh(Integer namBanHanh){
        this.namBanHanh = namBanHanh;
    }

    public String getTrangThai(){
        return trangThai;
    }

    public void setTrangThai(String trangThai){
        this.trangThai = trangThai;
    }
}
