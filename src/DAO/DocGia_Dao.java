/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Docgia;
import java.util.List;

/**
 *
 * @author Phuc
 */
public interface DocGia_Dao {
    public List<Docgia> getAllDocgiar();
    public int addDocgia (Docgia dg);
    public int deleteDocgia (String madocgia);
    public int unlock (String madocgia);
    public int updateDocgia (Docgia dg);
    public Docgia searchDg (String madocgia);
    public int getOneDocgia(String madocgia);
}
