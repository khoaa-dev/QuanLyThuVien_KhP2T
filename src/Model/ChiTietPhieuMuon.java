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
public class ChiTietPhieuMuon {
    private String maPM = "";
    private String maSach = "";
    private String ngayThucTra = "";
    private String tinhTrangSach = "";
    private int tienPhat = 0;
    
    public ChiTietPhieuMuon() {
        
    }
    
    public ChiTietPhieuMuon(String maPM, String maSach) {
        this.maPM = maPM;
        this.maSach = maSach;
    }

    public String getMaPM() {
        return maPM;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getNgayThucTra() {
        return ngayThucTra;
    }

    public String getTinhTrangSach() {
        return tinhTrangSach;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setNgayThucTra(String ngayThucTra) {
        this.ngayThucTra = ngayThucTra;
    }

    public void setTinhTrangSach(String tinhTrangSach) {
        this.tinhTrangSach = tinhTrangSach;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }
    
    
}
