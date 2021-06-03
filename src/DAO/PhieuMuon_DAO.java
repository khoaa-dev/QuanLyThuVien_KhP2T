/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PhieuMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class PhieuMuon_DAO {
    public List<PhieuMuon> getAllDSPhieuMuon() {
        List<PhieuMuon> pmList = new ArrayList<PhieuMuon>();
        
        Connection connection = KetNoiSQL.getConnection();
        
        String sql = "select maPhieuMuon, TaiKhoan.tenNguoiDung, maCanBo, ngayMuon, soNgayMuon, ghiChu, trangThai from PhieuMuon, TaiKhoan where PhieuMuon.maTaiKhoan = TaiKhoan.maTaiKhoan";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();

                pm.setMaPM(rs.getString("maPhieuMuon"));
                pm.setMaTaiKhoan(rs.getString("tenNguoiDung"));
                pm.setMaCanBo(rs.getString("maCanBo"));
                pm.setNgayMuon(rs.getString("ngayMuon"));
                pm.setSoNgayMuon(rs.getInt("soNgayMuon"));
                pm.setGhiChu(rs.getString("ghiChu"));
                pm.setTrangThai(rs.getString("trangThai"));
                
                pmList.add(pm);
            }
        } catch (SQLException e) {
        }

        return pmList;
    }
    public List<PhieuMuon> getDSPhieuMuon() {
        List<PhieuMuon> pmList = new ArrayList<PhieuMuon>();
        
        Connection connection = KetNoiSQL.getConnection();
        
        String sql = "select maPhieuMuon, TaiKhoan.tenNguoiDung, CanBo.tenCanBo, ngayMuon, soNgayMuon, ghiChu, trangThai from PhieuMuon, TaiKhoan, CanBo where PhieuMuon.maCanBo = CanBo.maCanBo and PhieuMuon.maTaiKhoan = TaiKhoan.maTaiKhoan";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();

                pm.setMaPM(rs.getString("maPhieuMuon"));
                pm.setMaTaiKhoan(rs.getString("tenNguoiDung"));
                pm.setMaCanBo(rs.getString("tenCanBo"));
                pm.setNgayMuon(rs.getString("ngayMuon"));
                pm.setSoNgayMuon(rs.getInt("soNgayMuon"));
                pm.setGhiChu(rs.getString("ghiChu"));
                pm.setTrangThai(rs.getString("trangThai"));
                
                pmList.add(pm);
            }
        } catch (SQLException e) {
        }

        return pmList;
    }
    
    public void addPhieuMuon(PhieuMuon phieuMuon) {
        Connection connection = KetNoiSQL.getConnection();
            String sql = "INSERT INTO PhieuMuon VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, phieuMuon.getMaPM());
                preparedStatement.setString(2, phieuMuon.getNgayMuon());
                preparedStatement.setInt(3, phieuMuon.getSoNgayMuon());
                preparedStatement.setString(4, phieuMuon.getMaTaiKhoan());
                preparedStatement.setString(5, phieuMuon.getMaCanBo());
                preparedStatement.setString(6, phieuMuon.getGhiChu());
                preparedStatement.setString(7, phieuMuon.getTrangThai());
                
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
     
    }
    
//    public void insertPM_DocGia(PhieuMuon pm) {
//        Connection con = KetNoiSQL.getConnection();
//        String sql = "insert into PhieuMuon (maPhieuMuon, soNgayMuon, maTaiKhoan) "
//                + "values(?, ?, ?)";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, pm.getMaPM());
//            ps.setInt(2, pm.getSoNgayMuon());
//            ps.setString(3, pm.getMaTaiKhoan());
//            ps.execute();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    
    public void updatePhieuMuon(PhieuMuon phieuMuon) {
        Connection connection = KetNoiSQL.getConnection();
        String sql = "UPDATE PhieuMuon SET ghiChu = ?, trangThai = ?, ngayMuon = ?, maCanBo = ? WHERE maPhieuMuon = ?";
        try {           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phieuMuon.getGhiChu());
            preparedStatement.setString(2, phieuMuon.getTrangThai());
            preparedStatement.setString(3, phieuMuon.getNgayMuon());
            preparedStatement.setString(4, phieuMuon.getMaCanBo());
            preparedStatement.setString(5, phieuMuon.getMaPM());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi");
        }
    }
    
    public String getMaPMInserted() {
        Connection con = KetNoiSQL.getConnection();
        String sql = "select top 1 maPhieuMuon from PhieuMuon order by maPhieuMuon desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("maPhieuMuon");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }    
}
