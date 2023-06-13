package com.example.demo.b14;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tivi")
public class Tivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mativi")
    private Integer maTivi;

    @Column(name = "tentivi")
    private String tenTivi;

    @Column(name = "nhasanxuat")
    private String nhaSanXuat;

    @Column(name = "kichco")
    private Float kichCo;

    @Column(name = "dophangiai")
    private Integer doPhanGiai;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "giahienhanh")
    private BigDecimal giaHienHanh;

    public Integer getMaTivi() {
        return maTivi;
    }

    public void setMaTivi(Integer maTivi) {
        this.maTivi = maTivi;
    }

    public String getTenTivi() {
        return tenTivi;
    }

    public void setTenTivi(String tenTivi) {
        this.tenTivi = tenTivi;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Float getKichCo() {
        return kichCo;
    }

    public void setKichCo(Float kichCo) {
        this.kichCo = kichCo;
    }

    public Integer getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(Integer doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaHienHanh() {
        return giaHienHanh;
    }

    public void setGiaHienHanh(BigDecimal giaHienHanh) {
        this.giaHienHanh = giaHienHanh;
    }
}
