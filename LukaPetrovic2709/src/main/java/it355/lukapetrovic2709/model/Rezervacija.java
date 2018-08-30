/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author 1uksha
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "rezervacija")
public class Rezervacija{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idRezervacije")
    private int idRezervacije;
    
    @Column(name = "datumRezervacije")
    private String datumRezervacije;
    
    @Column(name = "vremeRezervacije")
    private String vremeRezervacije;
    
    @Column(name = "imeKorisnika")
    private String imeKorisnika;
    
    @Column(name = "prezimeKorisnika")
    private String prezimeKorisnika;
    
    @Column(name = "usernameKorisnika")
    private String usernameKorisnika;
    
    @ManyToOne
    @JoinColumn(name = "idRestorana", referencedColumnName = "idRestorana")
    private Restoran restoran;

    public String getVremeRezervacije() {
        return vremeRezervacije;
    }

    public void setVremeRezervacije(String vremeRezervacije) {
        this.vremeRezervacije = vremeRezervacije;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public int getIdRezervacije() {
        return idRezervacije;
    }

    public void setIdRezervacije(int idRezervacije) {
        this.idRezervacije = idRezervacije;
    }

    public String getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(String datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public String getImeKorisnika() {
        return imeKorisnika;
    }

    public void setImeKorisnika(String imeKorisnika) {
        this.imeKorisnika = imeKorisnika;
    }

    public String getPrezimeKorisnika() {
        return prezimeKorisnika;
    }

    public void setPrezimeKorisnika(String prezimeKorisnika) {
        this.prezimeKorisnika = prezimeKorisnika;
    }

    public String getUsernameKorisnika() {
        return usernameKorisnika;
    }

    public void setUsernameKorisnika(String usernameKorisnika) {
        this.usernameKorisnika = usernameKorisnika;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "idRezervacije=" + idRezervacije + ", datumRezervacije=" + datumRezervacije + ", vremeRezervacije=" + vremeRezervacije + ", imeKorisnika=" + imeKorisnika + ", prezimeKorisnika=" + prezimeKorisnika + ", usernameKorisnika=" + usernameKorisnika + ", restoran=" + restoran + '}';
    }
 
    
}
