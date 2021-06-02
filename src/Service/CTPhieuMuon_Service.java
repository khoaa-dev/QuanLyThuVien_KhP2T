/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ChiTietPM_DAO;
import Model.ChiTietPhieuMuon;
import java.util.List;

/**
 *
 * @author nguye
 */
public class CTPhieuMuon_Service {
    private ChiTietPM_DAO ctpmDAO;
    public CTPhieuMuon_Service() {
        ctpmDAO = new ChiTietPM_DAO();
    }
    
    public List<ChiTietPhieuMuon> getDSCHiTietPM(String maPhieuMuon) {
        return ctpmDAO.getDSCHiTietPM(maPhieuMuon);
    }
    
    public void updateChiTietPM(ChiTietPhieuMuon ctpm) {
        ctpmDAO.updateChiTietPM(ctpm);
    }
    
    public void insertChiTietPM(ChiTietPhieuMuon ctpm) {
        ctpmDAO.insertChiTietPM(ctpm);
    }
    
    public void deleteChiTietPM(String idPhieuMuon, String idSach) {
        ctpmDAO.deleteChiTietPM(idPhieuMuon, idSach);
    }
}
