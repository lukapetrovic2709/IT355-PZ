/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic27099.dao;

import it355.lukapetrovic2709.model.Korisnik;
import java.util.List;

/**
 *
 * @author 1uksha
 */
public interface KorisnikDao {
    public Korisnik addKorisnik(Korisnik korisnik);
    public void deleteKorisnik(Korisnik korisnik);
    public List<Korisnik> getAllKorisnici();
    public Korisnik getUserById(int id);
}
