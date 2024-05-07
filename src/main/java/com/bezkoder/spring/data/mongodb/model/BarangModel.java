package com.bezkoder.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "barang")
public class BarangModel {
    @Id
    private String id;
    private String nama;
    private String deskripsi;
    private int stock;
    private double harga;
    private String kategori;

    public BarangModel() {
    }

    public BarangModel(String nama, String deskripsi, int stock, double harga, String kategori) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.stock = stock;
        this.harga = harga;
        this.kategori = kategori;
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

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Produk{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", harga=" + harga +
                ", stok=" + stock +
                ", kategori='" + kategori + '\'' +
                '}';
    }

}
