/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Formularios;
import com.puntodeventa.global.Util.ValidacionForms;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nato
 */
public class FormulariosDAO {
    
    static final Logger LOG = Logger.getLogger(FormulariosDAO.class.getName());    
    ValidacionForms vali = new ValidacionForms();
    private HibernateUtil Hutil;
    private Session session;
    private Transaction tx;

    //Metodo: Inicializa la operacion para procesos en la base de datos
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
    private void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos. Error: " + he.getMessage());
    }
    
    //Metodo Guarda Formularios
    public String saveForms(Formularios formularios) {
        LOG.log(Level.INFO, "saveForms()");
        String id_form;
        try {
            this.iniciaOperacion();
            id_form = (String) session.save(formularios);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id_form;
    }

    /**
     * Actualiza los formularios
     */
    public void updateForms(Formularios formularios) throws HibernateException {
        LOG.log(Level.INFO, "updateForms()");
        try {
            this.iniciaOperacion();
            session.update(formularios);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    /**
     * Metodo que devuelve una Forma
     */
    public Formularios getByCveForms(String cve_forma) {
        LOG.log(Level.INFO, "selectForms()");
        Formularios formularios = null;
        try {
            this.iniciaOperacion();
            formularios = (Formularios) session.get(Formularios.class, cve_forma);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return formularios;
    }
    
    public List<Formularios> getAllForms(){
        List<Formularios> listForms = null;
        try{
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery("SELECT * FROM vt.FORMULARIOS ORDER BY CVE_FORMA").addEntity(Formularios.class);
            listForms = sql.list();
        }finally{
            session.close();
        }
        return listForms;
    }
}
