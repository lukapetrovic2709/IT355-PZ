/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it355.lukapetrovic2709.dao.impl;

import it355.lukapetrovic27099.dao.RestoranDao;
import it355.lukapetrovic2709.model.Restoran;
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
@Repository("restoranDao")
public class RestoranDaoImpl implements RestoranDao{
    
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
    @Override
    @Transactional
    public List<Restoran> getAllRestorani() {
        List<Restoran> restorani = (List<Restoran>) getSession().createCriteria(Restoran.class).list();
        return restorani;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public Restoran getRestoranPoId(int idRestorana) {
        Restoran rest = (Restoran) getSession().createCriteria(Restoran.class).add(Restrictions.eq("idRestorana", idRestorana))
        .uniqueResult();
        return rest;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public Restoran addRestoran(Restoran restoran) {
        return (Restoran) getSession().merge(restoran);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void deleteRestoran(Restoran restoran) {
        getSession().delete(restoran);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public int getBrojRestorana() {
        String sql = "SELECT COUNT(*) FROM restorani";
        Number count = (Number) getSession().createSQLQuery(sql).uniqueResult();
        return Integer.parseInt(count.toString());
    }
    
}
