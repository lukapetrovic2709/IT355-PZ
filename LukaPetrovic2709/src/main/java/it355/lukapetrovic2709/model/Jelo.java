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
import javax.persistence.Table;

/**
 *
 * @author 1uksha
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "jela")
public class Jelo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idJela")
    private int idJela;
    
    @Column(name = "nazivJela")
    private String nazivJela;
    
    @Column(name = "sasatojciJela")
    private String sasatojciJela;
    
    @Column(name = "opisJela")
    private String opisJela;
    
    @Column(name = "vremeSpremanja")
    private String vremeSpremanja;
    
    @Column(name = "cenaJela")
    private double cenaJela;

    public String getOpisJela() {
        return opisJela;
    }

    public void setOpisJela(String opisJela) {
        this.opisJela = opisJela;
    }

    
    public int getIdJela() {
        return idJela;
    }

    public void setIdJela(int idJela) {
        this.idJela = idJela;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public String getSasatojciJela() {
        return sasatojciJela;
    }

    public void setSasatojciJela(String sasatojciJela) {
        this.sasatojciJela = sasatojciJela;
    }

    public String getVremeSpremanja() {
        return vremeSpremanja;
    }

    public void setVremeSpremanja(String vremeSpremanja) {
        this.vremeSpremanja = vremeSpremanja;
    }

    public double getCenaJela() {
        return cenaJela;
    }

    public void setCenaJela(double cenaJela) {
        this.cenaJela = cenaJela;
    }

    

    
}
