/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yazid.models.makanan;

/**
 *
 * @author ma39i
 */
public class Makanan {
    private int id;
    private String namaMakanan;
    private String jenisMakanan;
    private int rating;
    private float jumlahKalori;

    public Makanan(int id, String namaMakanan, String jenisMakanan, int rating, float jumlahKalori) {
        this.id = id;
        this.namaMakanan = namaMakanan;
        this.jenisMakanan = jenisMakanan;
        this.rating = rating;
        this.jumlahKalori = jumlahKalori;
    }

    public int getId() {
        return id;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public int getRating() {
        return rating;
    }

    public float getJumlahKalori() {
        return jumlahKalori;
    }
    
    
}
