/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Proveedor;
import com.puntodeventa.global.Util.ValidacionForms;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nato
 */
public class ProveedorDAO {
    static final Logger LOG = Logger.getLogger(ProveedorDAO.class.getName());
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
   
   //Metodo Guarda Proveedor
   public BigInteger saveProveedor(Proveedor proveedor){
       LOG.log(Level.INFO, "saveProveedor()");
       BigInteger cve_proveedor;
       try{
           this.iniciaOperacion();
           cve_proveedor = (BigInteger)session.save(proveedor);           
           tx.commit();           
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return cve_proveedor;
   }
   
   /**
    * Actualiza los datos de la tabla Proveedor
    */
   public void updateProveedor(Proveedor proveedor) throws HibernateException{
       LOG.log(Level.INFO, "updateProveedor()");
       try{
           this.iniciaOperacion();
           session.update(proveedor);
           tx.commit();
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
   }
   
   /**
    * Metodo que devuelve un Proveedor
    */
   
   public Proveedor selectProveedor(BigInteger cve_proveedor){
       LOG.log(Level.INFO, "selectProveedor()");
       Proveedor proveedor = null;
       try{
           this.iniciaOperacion();
           proveedor = (Proveedor) session.get(Proveedor.class, cve_proveedor);
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return proveedor;
   }
    
}
