/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc
 */
public class Thongke_Dao {
//    --- 1. Bạn đọc chưa trả sách
    public ResultSet chuatrasach () {
        String sql = "SELECT b.maTaiKhoan, b.tenNguoiDung\n" +
                    "FROM dbo.PhieuMuon AS a, dbo.TaiKhoan AS b\n" +
                    "WHERE a.maTaiKhoan = b.maTaiKhoan AND a.trangThai = N'Chưa trả'";
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    --- 2. Bạn đọc mượn quá hạn
    public ResultSet quahantra () {
        String sql = "SELECT c.tenNguoiDung, a.ngayMuon, a.soNgayMuon, b.ngayThucTra, ((DAY(b.ngayThucTra) - DAY(a.ngayMuon)) - a.soNgayMuon) AS 'Số ngày quá hạn'\n" +
                    "FROM dbo.PhieuMuon AS a, dbo.ChiTietPhieuMuon AS b, dbo.TaiKhoan AS c\n" +
                    "WHERE a.maPhieuMuon = b.maPhieuMuon AND a.maTaiKhoan = c.maTaiKhoan\n" +
                    "	AND DAY(b.ngayThucTra) - DAY(a.ngayMuon) > a.soNgayMuon";
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    --- 3. Bạn đọc mượn nhiều nhất
    public ResultSet muonnhiunhat () {
        String sql = "SELECT DISTINCT TOP 1 COUNT(a.maTaiKhoan) AS 'Số lần mượn', b.tenNguoiDung\n" +
                    "FROM dbo.PhieuMuon AS a, dbo.TaiKhoan AS b\n" +
                    "WHERE a.maTaiKhoan = b.maTaiKhoan\n" +
                    "GROUP BY b.tenNguoiDung\n" +
                    "ORDER BY [Số lần mượn] DESC";
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
//    --- 4. Sách được mượn nhiều nhất theo ngày
    public ResultSet sachdocnhiunhat () {
        String sql = "SELECT DISTINCT TOP 1 COUNT(a.maSach) AS 'Số lần mượn trong ngày', a.maSach, b.tenSach, c.ngayMuon\n" +
                    "FROM dbo.ChiTietPhieuMuon AS a, dbo.Sach AS b, dbo.PhieuMuon AS c\n" +
                    "WHERE a.maPhieuMuon = c.maPhieuMuon AND a.maSach = b.maSach\n" +
                    "GROUP BY c.ngayMuon, a.maSach, b.tenSach";
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//--- 5. Tổng số sách đượn mượn theo từng tháng
    public ResultSet sachnhatthang () {
        String sql = "SELECT COUNT(a.maSach) AS 'Số sách được mượn trong tháng',MONTH(c.ngayMuon) AS 'Tháng'\n" +
                    "FROM dbo.ChiTietPhieuMuon AS a, dbo.Sach AS b, dbo.PhieuMuon AS c\n" +
                    "WHERE a.maPhieuMuon = c.maPhieuMuon AND a.maSach = b.maSach\n" +
                    "GROUP BY MONTH(c.ngayMuon)";
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//--- 6. Tổng tiền phạt theo tháng
    public ResultSet tienphatthang () {
        String sql = "SELECT MONTH(a.ngayThucTra) AS 'Tháng', SUM(a.tienPhat) AS 'Tổng tiền phạt'\n" +
                    "FROM dbo.ChiTietPhieuMuon AS a, dbo.PhieuMuon AS b\n" +
                    "WHERE a.maPhieuMuon = b.maPhieuMuon \n" +
                    "GROUP BY MONTH(a.ngayThucTra)";
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
