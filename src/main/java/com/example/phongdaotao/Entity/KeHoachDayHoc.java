package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ctdt_keHoachDayHoc")
public class KeHoachDayHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ctdtId")
    private int ctdtId;

    @Column(name = "hocPhanId")
    private int hocPhanId;

    @Column(name = "hocKy")
    private int hocKy;

    @Column(name = "namHoc")
    private int namHoc;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCtdtId() {
        return ctdtId;
    }

    public void setCtdtId(int ctdtId) {
        this.ctdtId = ctdtId;
    }

    public int getHocPhanId() {
        return hocPhanId;
    }

    public void setHocPhanId(int hocPhanId) {
        this.hocPhanId = hocPhanId;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }
}

