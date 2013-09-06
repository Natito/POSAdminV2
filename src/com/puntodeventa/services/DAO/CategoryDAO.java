/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.mvc.Model.Category;
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
public class CategoryDAO {
    static final Logger LOG = Logger.getLogger(CategoryDAO.class.getName());
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
    * Metodo que devuelve una categoria
    */
   
   public Category selectCategory(String id_category){
       LOG.log(Level.INFO, "selectCategory()");
       Category category = null;
       try{
           this.iniciaOperacion();
           category = (Category) session.get(Category.class, id_category);
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return category;
   }

   public List<Category> listCategory(){
       LOG.log(Level.INFO, "listCategory()");
       List<Category> listCategory = null;
       try{
           this.iniciaOperacion();
           final SQLQuery sql = session.createSQLQuery("SELECT * FROM vt.CATEGORY ORDER BY ID_CATEGORY").addEntity(Category.class);
           listCategory = sql.list();
       }finally{
           session.close();
       }
       return listCategory;
   }
   
}
