/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KHP2T
 */
public class KetNoiSQL {
    public static Connection getConnection() {
      String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
//            String dbUrl = "jdbc:jtds:sqlserver://Phuc-PC:1433/QuanLyThuVien6;user:sa;password:12345678";
//            String dbUrl = "jdbc:jtds:sqlserver://THUYHANG:1433/QuanLyThuVien6";
            String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-NQLGPFV:1433/QuanLyThuVien6";
            return DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
 
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
 
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
}
