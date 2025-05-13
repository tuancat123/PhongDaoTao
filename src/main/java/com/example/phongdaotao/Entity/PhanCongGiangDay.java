package com.example.phongdaotao.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_phanconggiangday")
public class PhanCongGiangDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nhomId")
    private int nhomId;
    @Column(name= "giangVienId")
    private int giangVienId;
    @Column(name= "vaiTro")
    private String vaiTro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getNhomId(){
        return nhomId;
    }
    public void setNhomId(int nhomId){
        this.nhomId = nhomId;
    }
    public int getGiangVienId(){
        return giangVienId;
    }
    public void setGiangVienId(int giangVienId){
        this.giangVienId = giangVienId;
    }
    public String getVaiTro(){
        return vaiTro;
    }
    public void setVaiTro(String vaiTro){
        this.vaiTro = vaiTro;
    }

}

