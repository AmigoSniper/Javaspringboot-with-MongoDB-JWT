package com.bezkoder.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pelanggan")
public class PelangganModel {
    @Id
    private String id;
    private String nama;
    private String no;
    private String jeniskelamin;
    private String alamat;

    public PelangganModel() {

    }

    public PelangganModel(String nama, String no, String jeniskelamin, String alamat) {
        this.nama = nama;
        this.no = no;
        this.jeniskelamin = jeniskelamin;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "Pelanggan{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", Nomer HP='" + no + '\'' +
                ", Jensi Kelamin ='" + jeniskelamin +
                ", alamat='" + alamat + '\'' +
                '}';
    }

}
