/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Compra;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.report.bean.CompraProduct;
import com.puntodeventa.mvc.Model.CompraDetalle;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class CompraDAO {
    static final Logger LOG = Logger.getLogger(CompraDAO.class.getName());
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
   
   //Metodo Guarda Compra
   public long saveCompra(Compra compra){
       LOG.log(Level.INFO, "saveCompra()");
       long folio_c = 0;
       try{
           this.iniciaOperacion();
           folio_c = (Long)session.save(compra);
           tx.commit();
           System.out.println("Datos guardados");
       }catch(HibernateException he){
           System.out.println("Error al guardar: " + he.getMessage());
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }       
       return folio_c;
   }
   
   //Metodo Guarda CompraDetalle
   public void saveCompraDetalle(CompraDetalle compraDetalle){
       LOG.log(Level.INFO, "saveCompraDetalle()");
       try{
           this.iniciaOperacion();
           session.save(compraDetalle);
           tx.commit();           
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
   }
   
   
   /*
     * Query para Reporte de Venta Detallada
     */
    
    public List<CompraProduct>getListCompra(String pfechaIni, String pfechaFin){
       LOG.log(Level.INFO, "getListVenta()");       
       List<CompraProduct> listCompra = null;
       String qry = " select FOLIO_C, "
               + "to_char(a.fecha, 'dd-Mon-yyyy') FECHA,  "
               + "A.ID_PROVEEDOR,  "
               + "e.nombre proveedor,  "
               + "a.USUARIO_id_usuario,  "
               + "d.nombre usuario,  "
               + "b.id_product,  "
               + "c.product producto,  "
               + "c.descripcion,  "
               + "sum(c.p_compra), "
               + "sum(B.CANTIDAD),  "
               + "A.CANTIDAD TOTCANTIDAD "
               + "from vt.compra a, vt.compra_detalle b, vt.product c, vt.vt_usuarios d, proveedor e  "
               + "where A.FOLIO_C = b.compra_folio_c  "
               + "and B.ID_PRODUCT = C.ID_PRODUCT  "
               + "and A.USUARIO_ID_USUARIO = D.ID_USUARIO  "
               + "and A.ID_PROVEEDOR = E.CVE_PROVEEDOR  "
               + "and A.FECHA BETWEEN '"+ pfechaIni +"' and '" + pfechaFin + "' "
               + "group by a.folio_c, to_char(a.fecha, 'dd-Mon-yyyy'),  "
               + "A.ID_PROVEEDOR,  "
               + "e.nombre,  "
               + "a.USUARIO_id_usuario,  "
               + "d.nombre,  "
               + "b.id_product,  "
               + "c.product,  "
               + "c.descripcion, "
               + "c.p_compra, "
               + "B.CANTIDAD, "
               + "A.CANTIDAD "
               + "order by a.folio_c";
       try{
           this.iniciaOperacion();
           final SQLQuery sql = session.createSQLQuery(qry);
           listCompra = getRecordCompraProduct(sql.list());
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return listCompra;
   }
    
    private List<CompraProduct> getRecordCompraProduct(List list){
       List<CompraProduct> nlist = new ArrayList<>();
       for (int i = 0; i < list.size(); i++) {
           Object[] item = (Object[]) list.get(i);
           CompraProduct c = new CompraProduct();
           c.setFolio_c(new BigInteger(item[0].toString()));
           c.setFecha(item[1].toString());
           c.setId_proveedor(new BigInteger(item[2].toString()));
           c.setProveedor(item[3].toString());
           c.setId_usuario(new BigInteger(item[4].toString()));
           c.setUsuario(item[5].toString());
           c.setId_product(item[6].toString());
           c.setProduct(item[7].toString());
           c.setDescripcion(item[8].toString());
           c.setP_compra(new Double(item[9].toString()));
           c.setCantidad(Integer.parseInt(item[10].toString()));
           c.setTotCantidad(Integer.parseInt(item[11].toString()));
           nlist.add(c);
       }
       return nlist;
   }
   
}
