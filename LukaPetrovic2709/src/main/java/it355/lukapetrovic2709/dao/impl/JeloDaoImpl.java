/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.dao.impl;

import it355.lukapetrovic27099.dao.JeloDao;
import it355.lukapetrovic2709.model.Jelo;
import it355.lukapetrovic2709.model.Korisnik;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@Repository("jeloDao")
@Service
public class JeloDaoImpl implements JeloDao{
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
    public Jelo addJelo(Jelo jelo) {
        return (Jelo) getSession().merge(jelo);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void deleteJelo(Jelo jelo) {
        getSession().delete(jelo);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Jelo> getAllJela() {
        List<Jelo> jela = (List<Jelo>) getSession().createCriteria(Jelo.class).list();
        return jela; 
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public Jelo getJeloById(int idJela) {
        Jelo jela = (Jelo) getSession().createCriteria(Jelo.class).add(Restrictions.eq("idJela", idJela))
                .uniqueResult();
        return jela;
    }
}
