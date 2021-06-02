/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChiTietPhieuMuon;
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
public class ChiTietPM_DAO {
    public List<ChiTietPhieuMuon> getDSCHiTietPM(String maPhieuMuon) {
        List<ChiTietPhieuMuon> ctpmList = new ArrayList<ChiTietPhieuMuon>();
        
        Connection connection = KetNoiSQL.getConnection();
        
        String sql = "select * from ChiTietPhieuMuon where maPhieuMuon like '%" + maPhieuMuon + "%'";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();

                ctpm.setMaPM(rs.getString("maPhieuMuon"));
                ctpm.setMaSach(rs.getString("maSach"));
                ctpm.setNgayThucTra(rs.getString("ngayThucTra"));
                ctpm.setTinhTrangSach(rs.getString("tinhTrangSach"));
                ctpm.setTienPhat(rs.getInt("tienPhat"));
                
                ctpmList.add(ctpm);
            }
        } catch (SQLException e) {
        }

        return ctpmList;
    }
    
    public void insertChiTietPM(ChiTietPhieuMuon ctpm) {
        Connection connection = KetNoiSQL.getConnection();
        String sql = "INSERT INTO ChiTietPhieuMuon (maPhieuMuon, maSach) VALUES (?, ?)";
        try {           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ctpm.getMaPM());
            preparedStatement.setString(2, ctpm.getMaSach());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateChiTietPM(ChiTietPhieuMuon ctpm) {
        Connection connection = KetNoiSQL.getConnection();
        String sql = "UPDATE ChiTietPhieuMuon SET ngayThucTra = ?, tinhTrangSach = ? WHERE maPhieuMuon = ? and maSach = ?";
        try {           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ctpm.getNgayThucTra());
            preparedStatement.setString(2, ctpm.getTinhTrangSach());
            preparedStatement.setString(3, ctpm.getMaPM());
            preparedStatement.setString(4, ctpm.getMaSach());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    
    public void deleteChiTietPM(String idPhieuMuon, String idSach) {
        Connection connection = KetNoiSQL.getConnection();
        String sql = "DELETE ChiTietPhieuMuon WHERE maSach LIKE '%" + idSach + "%' AND maPhieuMuon LIKE '%" + idPhieuMuon + "%'";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        }catch(Exception e){
            System.out.println("khong xoa dc");
        }
    }
}
