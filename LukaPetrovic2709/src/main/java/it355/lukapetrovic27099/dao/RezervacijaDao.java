/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic27099.dao;

import it355.lukapetrovic2709.model.Rezervacija;
import java.util.List;

/**
 *
 * @author 1uksha
 */
public interface RezervacijaDao {
    public Rezervacija addRezervaciju(Rezervacija rez);
    
    public void deleteRezervaciju(Rezervacija rez);
    
    public List<Rezervacija> getAllRezervacije();
    
    public int getBrojRezervacija();
    
    public Rezervacija getRezervacijaPoId(int idRezervacije);
}
