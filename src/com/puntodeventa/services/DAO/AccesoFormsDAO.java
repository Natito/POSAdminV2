/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.AccesoForms;
import com.puntodeventa.global.Util.ValidacionForms;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nato
 */
public class AccesoFormsDAO {
    static final Logger LOG = Logger.getLogger(FormulariosDAO.class.getName());    
    ValidacionForms vali = new ValidacionForms();
    private HibernateUtil Hutil;
    private Session session;
    private Transaction tx;
    private Criteria cr;
    
    //Metodo: Inicializa la operacion para procesos en la base de datos
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
    private void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos: " + he.getMessage());        
    }
    
    //Metodo Guarda Accesos
    public Long saveForms(AccesoForms accesoForms) {
        LOG.log(Level.INFO, "saveAccesoForms()");
        Long id;
        try {
            this.iniciaOperacion();
            id = (Long) session.save(accesoForms);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * Actualiza los AccesoForms
     */
    public void updateForms(AccesoForms accesoForms) throws HibernateException {
        LOG.log(Level.INFO, "updateAccesoForms()");
        try {
            this.iniciaOperacion();
            session.update(accesoForms);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    public void SaveUpdateForms(AccesoForms accesoForms) throws HibernateException {
        LOG.log(Level.INFO, "SaveUpdateAccesoForms()");
        try {
            this.iniciaOperacion();
            session.saveOrUpdate(accesoForms);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    public List<AccesoForms> selectFormByCveUser(int id_usuario) {
        List<AccesoForms> listUser = null;
        try {
            this.iniciaOperacion();
            cr = session.createCriteria(AccesoForms.class).add(Restrictions.eq("id_usuario", id_usuario));
            listUser = cr.list();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return listUser;
    }
}
