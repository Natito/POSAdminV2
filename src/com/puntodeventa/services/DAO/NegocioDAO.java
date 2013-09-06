/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.mvc.Model.Negocio;
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
public class NegocioDAO {
    static final Logger LOG = Logger.getLogger(NegocioDAO.class.getName());
    ValidacionForms vali = new ValidacionForms();
    private Session session;
    private Transaction tx;
    
    
   //Metodo: Inicializa la operacion para procesos en la base de datos
   private void iniciaOperacion() throws HibernateException{
       session = HibernateUtil.getSessionFactory().openSession();
       tx = session.beginTransaction();
   }
   
   // Metodo: Obtenemos el error  que podria ocacionar an cada metodo
   private void manejaException(HibernateException he)throws HibernateException{
       tx.rollback();
       throw new HibernateException ("Ocurrio un error en la capa de acceso a datos. Error: " + he.getMessage());
   }
      
   /**
    * Metodo que devuelve un product
    */
   
   public Negocio selectNegocio(String id_negocio){
       LOG.log(Level.INFO, "selectNegocio()");
       Negocio negocio = null;
       try{
           this.iniciaOperacion();
           negocio = (Negocio) session.get(Negocio.class, id_negocio);
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return negocio;
   }

   public List<Negocio> listNegocio(){
       LOG.log(Level.INFO, "listNegocio");
       List<Negocio> listNegocio = null;
       try{
           this.iniciaOperacion();
           final SQLQuery sql = session.createSQLQuery("SELECT * FROM vt.NEGOCIO ORDER BY ID_NEGOCIO").addEntity(Negocio.class);
           listNegocio = sql.list();
       }finally{
           session.close();
       }
       return listNegocio;
   }
    
}
