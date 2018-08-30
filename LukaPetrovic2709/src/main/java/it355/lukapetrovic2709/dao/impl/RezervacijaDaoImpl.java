/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.dao.impl;

import it355.lukapetrovic27099.dao.RezervacijaDao;
import it355.lukapetrovic2709.model.Rezervacija;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 1uksha
 */
@Repository("rezervacijaDao")
public class RezervacijaDaoImpl implements RezervacijaDao{
   @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());
 
    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;
 
    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }  

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Rezervacija addRezervaciju(Rezervacija rez) {
        return (Rezervacija)getSession().merge(rez);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Rezervacija> getAllRezervacije() {
        List<Rezervacija> rezervacije = (List<Rezervacija>) getSession().createCriteria(Rezervacija.class).list();
        return rezervacije;
    }

    @Override
    @Transactional
    public int getBrojRezervacija() {
        String sql = "SELECT COUNT(*) FROM rezervacija";
        Number count = (Number) getSession().createSQLQuery(sql).uniqueResult();
        return Integer.parseInt(count.toString());
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public void deleteRezervaciju(Rezervacija rez) {
        getSession().delete(rez);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Rezervacija getRezervacijaPoId(int idRezervacije) {
        Rezervacija soba = (Rezervacija) getSession().createCriteria(Rezervacija.class).add(Restrictions.eq("idRezervacije", idRezervacije))
        .uniqueResult();
        return soba;
    }
}
