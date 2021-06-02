
package DAO;

import Model.sach_th;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sach_Dao_implement implements Sach_dao_thuy{

    @Override
    public List<sach_th> getAllSach() {
        String sql = "select * from Sach";
        List<sach_th> allSach = new ArrayList<>();
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                allSach.add(new sach_th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return allSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<sach_th> getSachByCategory(String category) {
        String sql = "select * from Sach where maDMSach = ?";
        List<sach_th> allSach = new ArrayList<>();
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            pre.setString(1, category);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                allSach.add(new sach_th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return allSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<sach_th> getSachByTheloai(String theloai) {
        String sql = "select * from Sach where maTheLoai = ?";
        List<sach_th> allSach = new ArrayList<>();
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            pre.setString(1, theloai);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                allSach.add(new sach_th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return allSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public List<sach_th> getSachBySearch(String searchString) {
        String sql = "select * from Sach where tenSach like ?";
        List<sach_th> searchSach = new ArrayList<>();
        try {
            PreparedStatement pre = KetNoiSQL.getConnection().prepareStatement(sql);
            pre.setString(1, searchString);
            ResultSet sach = pre.executeQuery();
            while(sach.next()) {
                searchSach.add(new sach_th(sach.getString(2), sach.getString(5), sach.getString(6), sach.getInt(8)));
            }
            return searchSach;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_Dao_implement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
