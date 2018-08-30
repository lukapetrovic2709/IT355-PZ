/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 1uksha
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "restorani")
public class Restoran implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idRestorana")
    private int idRestorana;
    
    @Column(name = "nazivRestorana")
    private String nazivRestorana;
    
    @Column(name = "radnoVreme")
    private String radnoVreme;
    
    @Column(name = "vrsteKuhunja")
    private String vrsteKuhunja;
    
    @Column(name = "lokacijaRestorana")
    private String lokacijaRestorana;

    public int getIdRestorana() {
        return idRestorana;
    }

    public void setIdRestorana(int idRestorana) {
        this.idRestorana = idRestorana;
    }

    public String getNazivRestorana() {
        return nazivRestorana;
    }

    public void setNazivRestorana(String nazivRestorana) {
        this.nazivRestorana = nazivRestorana;
    }

    public String getRadnoVreme() {
        return radnoVreme;
    }

    public void setRadnoVreme(String radnoVreme) {
        this.radnoVreme = radnoVreme;
    }

    public String getVrsteKuhunja() {
        return vrsteKuhunja;
    }

    public void setVrsteKuhunja(String vrsteKuhunja) {
        this.vrsteKuhunja = vrsteKuhunja;
    }

    public String getLokacijaRestorana() {
        return lokacijaRestorana;
    }

    public void setLokacijaRestorana(String lokacijaRestorana) {
        this.lokacijaRestorana = lokacijaRestorana;
    }

    
    @Override
    public String toString() {
        return  nazivRestorana;
    }
    
    
    
}
