/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.BanDoc_DAO;
import Model.BanDoc;
import java.util.List;

/**
 *
 * @author nguye
 */
public class BanDoc_Service {
    private BanDoc_DAO banDoc_DAO;
    public BanDoc_Service() {
        banDoc_DAO = new BanDoc_DAO();
    }
    
    public List<BanDoc> getDSBanDocForFind() {
            return banDoc_DAO.getDSBanDocForFind();
        }
}
