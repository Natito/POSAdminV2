package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Corte;
import com.puntodeventa.global.Entity.Sesion;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.report.bean.VentaProduct;
import com.puntodeventa.mvc.Controller.VentaLogic;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class CorteDAO {

    LogHelper objLog = new LogHelper("CorteDAO");
    private Session session;
    private Transaction tx;

    //Metodo: Inicializa la operacion para procesos en la base de datos
    private void iniciaOperacion() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
        } catch (HibernateException ex) {
            objLog.Log(ex.getMessage());
        }
    }

    // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
    private void manejaException(HibernateException he) throws HibernateException {
        tx.rollback();
        objLog.Log(he.getMessage());
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos. Error: " + he.getMessage());
    }

    //Metodo guarda corte
    public int saveCorte(Corte corte) {
        int idFolio = 0;
        try {
            this.iniciaOperacion();
            idFolio = Integer.parseInt(session.save(corte).toString());
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return idFolio;
    }

    /**
     * Actualiza los datos de la tabla Ventas
     */
    public void updateCorte(Corte corte) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(corte);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Corte
     */
    public void deleteCorte(Corte corte) {
        try {
            this.iniciaOperacion();
            session.delete(corte);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un objeto Corte
     */
    public Corte selectCorte(int idCorte) {
        Corte corte = null;
        try {
            this.iniciaOperacion();
            corte = (Corte) session.get(Corte.class, corte);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return corte;
    }
}