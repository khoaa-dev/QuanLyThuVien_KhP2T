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
public class Docgia {
    private String maTk;
    private String tenTk;
    private String ngaySinh;
    private int gioiTinh;
    private String email;
    private String sdt;

    public Docgia(String maTk, String tenTk, String ngaySinh, int gioitinh, String email, String sdt) {
        this.maTk = maTk;
        this.tenTk = tenTk;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioitinh;
        this.email = email;
        this.sdt = sdt;
    }

    public Docgia() {
        
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    
    public String getMaTk() {
        return maTk;
    }

    public String getTenTk() {
        return tenTk;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMaTk(String maTk) {
        this.maTk = maTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
