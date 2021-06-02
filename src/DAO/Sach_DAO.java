/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KHP2T
 */
public class Sach_DAO {
    
    
    public List<Sach> getDSSach(){
        List<Sach> s = new ArrayList<Sach>();
        
        Connection connection = KetNoiSQL.getConnection();
        
        String sql = "SELECT * FROM Sach";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Sach sach = new Sach();
                
                sach.setMaSach(rs.getString("maSach"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setMaDMSach(rs.getString("maDMSach"));
                sach.setMaTheLoai(rs.getString("maTheLoai"));
                sach.setTacGia(rs.getString("tacGia"));
                sach.setNXB(rs.getString("NXB"));
                sach.setNamXuatBan(rs.getInt("namXuatBan"));
                sach.setSoLuongCon(rs.getInt("soLuongCon"));
                sach.setTomTatND(rs.getString("tomTatND"));
                //sach.setAnh(rs.getString("anhSach"));
                
                s.add(sach);
                
            }
        }catch (SQLException e){
            
        }
        return s;
    }
    public void addSach(Sach sach){
        Connection connection = KetNoiSQL.getConnection();
        String sql = "INSERT INTO Sach VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sach.getMaSach());
            preparedStatement.setString(2, sach.getTenSach()); 
            preparedStatement.setString(3, sach.getMaDMSach());
            preparedStatement.setString(4, sach.getMaTheLoai()); 
            preparedStatement.setString(5, sach.getTacGia());
            preparedStatement.setString(6, sach.getNXB()); 
            preparedStatement.setString(7, String.valueOf(sach.getNamXuatBan()));
            preparedStatement.setString(8, String.valueOf(sach.getSoLuongCon())); 
            preparedStatement.setString(9, sach.getTomTatND()); 
            ///preparedStatement.setString(10, sach.getAnh()); 
            
            preparedStatement.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    public void updateSach(Sach sach){
        Connection connection = KetNoiSQL.getConnection();
        String sql = "UPDATE Sach SET tenSach = ?, maDMSach = ?, maTheLoai = ?, TacGia = ?, NXB = ?, namXuatBan = ?, soLuongCon = ?, tomTatND = ? WHERE maSach = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1, sach.getMaSach());
            preparedStatement.setString(1, sach.getTenSach());
            preparedStatement.setString(2, sach.getMaDMSach()); 
            preparedStatement.setString(3, sach.getMaTheLoai());
            preparedStatement.setString(4, sach.getTacGia());
            preparedStatement.setString(5, sach.getNXB()); 
            preparedStatement.setString(6, String.valueOf(sach.getNamXuatBan()));
            preparedStatement.setString(7, String.valueOf(sach.getSoLuongCon())); 
            preparedStatement.setString(8, sach.getTomTatND()); 
            //preparedStatement.setString(8, sach.getAnh()); 
            preparedStatement.setString(9, sach.getMaSach());
            
            preparedStatement.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
     public void deleteSach(String maSach){
        Connection connection = KetNoiSQL.getConnection();
        String sql = "DELETE Sach WHERE maSach LIKE '%" + maSach + "%'";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        }catch(Exception e){
            
        }
    }
     
    public List<Sach> setListSach(ResultSet rs) throws SQLException {
        List<Sach> s = new ArrayList<Sach>();
        while(rs.next()){
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("maSach"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setMaDMSach(rs.getString("maDMSach"));
                sach.setMaTheLoai(rs.getString("maTheLoai"));
                sach.setTacGia(rs.getString("tacGia"));
                sach.setNXB(rs.getString("NXB"));
                sach.setNamXuatBan(rs.getInt("namXuatBan"));
                sach.setSoLuongCon(rs.getInt("soLuongCon"));
                sach.setTomTatND(rs.getString("tomTatND"));
                s.add(sach);
            }
        return s;
    }
     
     public List<Sach> getAllSachByOne(String searching, String type) {
        Connection con = KetNoiSQL.getConnection();
        List<Sach> s = new ArrayList<Sach>();
        String sql = "select * from Sach, DanhMucSach where tenDMSach = ? and Sach.maDMSach = DanhMucSach.maDMSach";
        if(type.equalsIgnoreCase("theloai")) 
            sql = "select * from Sach, TheLoai where tenTheLoai = ?"
              + " and Sach.maTheLoai = TheLoai.maTheLoai";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, searching);
            ResultSet rs = ps.executeQuery();
            s = setListSach(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }
     
     public List<Sach> getAllSachByBoth(String danhmuc, String theloai) {
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from Sach, DanhMucSach, TheLoai where tenDMSach = ? and tenTheLoai = ?"
              + "and Sach.maDMSach = DanhMucSach.maDMSach and Sach.maTheLoai = TheLoai.maTheLoai";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, danhmuc);
            ps.setString(2, theloai);
            ResultSet rs = ps.executeQuery();
            return setListSach(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
    public Sach getSachByMS(String masach) {
        Connection con = KetNoiSQL.getConnection();
        String sql = "select * from Sach where maSach = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, masach);
            ResultSet rs = ps.executeQuery();
            Sach sach = new Sach();
            rs.next();
            sach.setMaSach(rs.getString("maSach"));
            sach.setTenSach(rs.getString("tenSach"));
            sach.setMaDMSach(rs.getString("maDMSach"));
            sach.setMaTheLoai(rs.getString("maTheLoai"));
            sach.setTacGia(rs.getString("TacGia"));
            sach.setNXB(rs.getString("NXB"));
            sach.setNamXuatBan(rs.getInt("namXuatBan"));
            sach.setSoLuongCon(rs.getInt("soLuongCon"));
            sach.setTomTatND(rs.getString("tomTatND"));
            return sach;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String getDMSach(String maDM) {
        Connection con = KetNoiSQL.getConnection();
        String sql = "select tenDMSach from DanhMucSach where maDMSach = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maDM);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("tenDMSach");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
    public String getDMTheLoai(String maTheLoai) {
        Connection con = KetNoiSQL.getConnection();
        String sql = "select tenTheLoai from TheLoai where maTheLoai = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTheLoai);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("tenTheLoai");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
