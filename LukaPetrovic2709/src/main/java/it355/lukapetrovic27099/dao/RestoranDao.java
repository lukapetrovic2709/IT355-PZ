/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic27099.dao;

import it355.lukapetrovic2709.model.Restoran;
import java.util.List;

/**
 *
 * @author 1uksha
 */
public interface RestoranDao {
    public Restoran addRestoran(Restoran restoran);
    public void deleteRestoran(Restoran restoran);
    public List<Restoran> getAllRestorani();
    public int getBrojRestorana();
    public Restoran getRestoranPoId(int idRestorana);
}
