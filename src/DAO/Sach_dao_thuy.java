/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.sach_th;
import java.util.List;

/**
 *
 * @author Phuc
 */
public interface Sach_dao_thuy {
    public List<sach_th> getAllSach ();
    public List<sach_th> getSachByCategory(String category);
    public List<sach_th> getSachByTheloai(String theloai);
    public List<sach_th> getSachBySearch(String searString);
}
