/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nguye
 */
public class BanDoc {
    private String maTK = "";
    private String mathau = "";
    private String tenNguoiDung = "";
    private String ngaySinh = "";
    private String gioiTinh = "";
    private String email = "";
    private String sdt = "";
    private int status;
    private int soLuongMuon;
    
    public BanDoc() {
        
    }

    public String getMaTK() {
        return maTK;
    }

    public String getMathau() {
        return mathau;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public int getStatus() {
        return status;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public void setMathau(String mathau) {
        this.mathau = mathau;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }
    
    
}
