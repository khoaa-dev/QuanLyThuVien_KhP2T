
package Service;

import DAO.Sach_DAO;
import Model.Sach;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author KHP2T
 */
public class Sach_Service {
     private Sach_DAO sDAO;
    public Sach_Service(){
        sDAO = new Sach_DAO();
    }
    
    public List<Sach> getDSSach(){
        return sDAO.getDSSach();
    }
    
    public void addSach(Sach sach){
        sDAO.addSach(sach);
        JOptionPane.showMessageDialog(null, "Đã thêm thành công!");
    }
    
    public void updateSach(Sach sach){
        sDAO.updateSach(sach);
        JOptionPane.showMessageDialog(null, "Đã sửa thành công!");
    }
    
    public void deleteSach(String maSach){
        sDAO.deleteSach(maSach);
        JOptionPane.showMessageDialog(null, "Đã xóa thành công!");
    }
    
    public List<Sach> getAllSachByOne(String searching, String type) {
        return sDAO.getAllSachByOne(searching, type);
    }
    
    
    
    public List<Sach> getAllSachByBoth(String danhmuc, String theloai) {
        return sDAO.getAllSachByBoth(danhmuc, theloai);
    }
    
    public Sach getSachByMS(String masach) {
        return sDAO.getSachByMS(masach);
    }
    
        public String getDMSach(String maDM) {
        return sDAO.getDMSach(maDM);
    }
    
    public String getTheLoai(String maTheLoai) {
        return sDAO.getDMTheLoai(maTheLoai);
    }
}
