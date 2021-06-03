/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.PhieuMuon_DAO;
import Model.PhieuMuon;
import java.util.List;

/**
 *
 * @author nguye
 */
public class PhieuMuon_Service {
    private PhieuMuon_DAO pmDAO;
    public PhieuMuon_Service() {
        pmDAO = new PhieuMuon_DAO();
    }
    
    public List<PhieuMuon> getAllDSPhieuMuon() {
        return pmDAO.getAllDSPhieuMuon();
    }
    
    public List<PhieuMuon> getDSPhieuMuon() {
        return pmDAO.getDSPhieuMuon();
    }
    
    public void addPhieuMuon(PhieuMuon phieuMuon) {
        pmDAO.addPhieuMuon(phieuMuon);
    }
    
    public void updatePhieuMuon(PhieuMuon phieuMuon) {
        pmDAO.updatePhieuMuon(phieuMuon);
    }
    
    public String getMaPMInserted() {
        return pmDAO.getMaPMInserted();
    }
}
