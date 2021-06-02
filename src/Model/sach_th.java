/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Phuc
 */
public class sach_th {
    private String tenSach;
    private String tacgia;
    private String nhaSB;
    private int soluong;

    public sach_th(String tenSach, String tacgia, String nhaSB, int soluong) {
        this.tenSach = tenSach;
        this.tacgia = tacgia;
        this.nhaSB = nhaSB;
        this.soluong = soluong;
    }

    public sach_th() {
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public String getNhaSB() {
        return nhaSB;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public void setNhaSB(String nhaSB) {
        this.nhaSB = nhaSB;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
