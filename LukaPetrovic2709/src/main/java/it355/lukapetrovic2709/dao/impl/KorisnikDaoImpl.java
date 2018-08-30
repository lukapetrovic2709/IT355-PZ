/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.dao.impl;

import it355.lukapetrovic27099.dao.KorisnikDao;
import it355.lukapetrovic2709.model.Korisnik;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 1uksha
 */
@Repository("korisnikDao")
@Service
public class KorisnikDaoImpl implements KorisnikDao{

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

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
    @Override
    @Transactional
    public Korisnik addKorisnik(Korisnik korisnik) {
        Query query = getSession().
                createQuery("FROM Korisnik where username = :username"); //provera da li username postoji
        query.setParameter("username", korisnik.getUsername());

        if (query.uniqueResult() != null) {
            throw new RuntimeException();

        } else {
            return (Korisnik) getSession().merge(korisnik);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void deleteKorisnik(Korisnik korisnik) {
        getSession().delete(korisnik);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public Korisnik getUserById(int idKorisnika) {
        Korisnik k = (Korisnik) getSession().createCriteria(Korisnik.class).add(Restrictions.eq("idKorisnika", idKorisnika))
                .uniqueResult();
        return k;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Korisnik> getAllKorisnici() {
       List<Korisnik> rezervacije = (List<Korisnik>) getSession().createCriteria(Korisnik.class).list();
        return rezervacije; 
    }
    
}
