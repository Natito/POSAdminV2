package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Entity.Venta;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.report.bean.CountVenta;
import com.puntodeventa.global.report.bean.VentaProduct;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class VentaDAO {
    static final Logger LOG = Logger.getLogger(VentaDAO.class.getName());
    ValidacionForms vali = new ValidacionForms();
    ConnectedByHibernate cBH = new ConnectedByHibernate();
    LogHelper objLog = new LogHelper("VentaDAO");
    private String qry;
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

    //Metodo guarda venta
    public int saveVenta(Venta venta) {
        int idFolio = 0;
        try {
            this.iniciaOperacion();
            idFolio = Integer.parseInt(session.save(venta).toString());
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
    public void updateVenta(Venta venta) throws HibernateException {
        try {
            this.iniciaOperacion();
            session.update(venta);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Ventas
     */
    public void deleteVenta(Venta venta) {
        try {
            this.iniciaOperacion();
            session.delete(venta);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un objeto Venta
     */
    public Venta selectVenta(int idVenta) {
        Venta venta = null;
        try {
            this.iniciaOperacion();
            venta = (Venta) session.get(Venta.class, venta);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return venta;
    }
    private static String query = "";

    public List<Venta> listVenta() {
        List<Venta> listVenta = null;

        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(query).addEntity(Venta.class);
            listVenta = sql.list();
        } finally {
        }
        return listVenta;
    }
    
    
    /*
     * Query para Reporte de Venta Detallada de un rango de fecha
     * @Params pfechaIni
     * @Params pfechaFin
     */
    
    public List<VentaProduct>getListVenta(String pfechaIni, String pfechaFin){
       LOG.log(Level.INFO, "getListVenta()");       
       List<VentaProduct> listVenta = null;
       qry = " select  "
               + "A.ID_FOLIO,  "
               + "to_char(a.FECHA,'dd-Mon-yyyy') FECHA,  "
               + "A.USUARIO_ID_USUARIO,  "
               + "d.Nombre usuario,  "
               + "B.ID_PRODUCT,  "
               + "C.PRODUCT PRODUCTO,  "
               + "C.DESCRIPCION,  "
               + "C.P_VENTA, "
               + "sum(B.CANTIDAD) CANTIDAD,  "
               + "sum(B.SUBTOTAL) SUBTOTAL, "
               + "A.CANTIDAD totCantidad, "
               + "A.TOTAL      "
               + "from vt.ventas a, vt.venta_detalle b, vt.product c, vt.vt_usuarios d  "
               + "where a.id_folio = b.venta_id_folio     "
               + "and C.ID_PRODUCT = B.ID_PRODUCT     "
               + "and A.USUARIO_ID_USUARIO = D.ID_USUARIO  "
               + "AND to_char(A.FECHA, 'dd/mm/yyyy') BETWEEN to_date('"+pfechaIni+"', 'dd/mm/yyyy') AND to_date('"+pfechaFin+"', 'dd/mm/yyyy') "
               + "GROUP BY A.ID_FOLIO,  "
               + "to_char(a.FECHA,'dd-Mon-yyyy'),  "
               + "A.USUARIO_ID_USUARIO,  "
               + "d.Nombre,  "
               + "B.ID_PRODUCT,  "
               + "C.PRODUCT,  "
               + "C.DESCRIPCION,  "
               + "C.P_VENTA,A.CANTIDAD, "
               + "A.TOTAL "
               + "ORDER BY A.ID_FOLIO";
       try{
           this.iniciaOperacion();
           final SQLQuery sql = session.createSQLQuery(qry);
           listVenta = getRecordVentaProduct(sql.list());
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return listVenta;
   }
    
    public List<VentaProduct>getVentaId(String id_folio){
       LOG.log(Level.INFO, "getVentaId()");
       List<VentaProduct> listVenta = null;
       qry = " select  "
               + "A.ID_FOLIO,  "
               + "to_char(a.FECHA,'dd-Mon-yyyy') FECHA,  "
               + "A.USUARIO_ID_USUARIO,  "
               + "d.Nombre usuario,  "
               + "B.ID_PRODUCT,  "
               + "C.PRODUCT PRODUCTO,  "
               + "C.DESCRIPCION,  "
               + "C.P_VENTA, "
               + "sum(B.CANTIDAD) CANTIDAD,  "
               + "sum(B.SUBTOTAL) SUBTOTAL, "
               + "A.CANTIDAD totCantidad, "
               + "A.TOTAL      "
               + "from vt.ventas a, vt.venta_detalle b, vt.product c, vt.vt_usuarios d  "
               + "where a.id_folio = b.venta_id_folio     "
               + "and C.ID_PRODUCT = B.ID_PRODUCT     "
               + "and A.USUARIO_ID_USUARIO = D.ID_USUARIO  "
               + "AND A.ID_FOLIO = '" + id_folio + "' "
               + "GROUP BY A.ID_FOLIO,  "
               + "to_char(a.FECHA,'dd-Mon-yyyy'),  "
               + "A.USUARIO_ID_USUARIO,  "
               + "d.Nombre,  "
               + "B.ID_PRODUCT,  "
               + "C.PRODUCT,  "
               + "C.DESCRIPCION,  "
               + "C.P_VENTA,A.CANTIDAD, "
               + "A.TOTAL "
               + "ORDER BY A.ID_FOLIO ";
       try{
           this.iniciaOperacion();
           final SQLQuery sql = session.createSQLQuery(qry);
           listVenta = getRecordVentaProduct(sql.list());
       }catch(HibernateException he){
           this.manejaException(he);
           throw he;
       }finally{
           session.close();
       }
       return listVenta;
   }
   
    
    
    
   private List<VentaProduct> getRecordVentaProduct(List list){
       List<VentaProduct> nlist = new ArrayList<>();
       for (int i = 0; i < list.size(); i++) {
           Object[] item = (Object[]) list.get(i);
           VentaProduct v = new VentaProduct();
           v.setId_folio(new BigInteger(item[0].toString()));
           v.setFecha(item[1].toString());
           v.setId_usuario(new BigInteger(item[2].toString()));
           v.setUsuario(item[3].toString());
           v.setId_product(item[4].toString());
           v.setProducto(item[5].toString());
           v.setDescripcion(item[6].toString());
           v.setP_venta(Double.parseDouble(item[7].toString()));
           v.setCantidad(Integer.parseInt(item[8].toString()));
           v.setSubtotal(Double.parseDouble(item[9].toString()));           
           v.setTotCantidad(Integer.parseInt(item[10].toString()));
           v.setTotal(Double.parseDouble(item[11].toString()));           
           nlist.add(v);
       }
       return nlist;
   }
   
   public List<CountVenta> getVentaByCategory(Usuario usuario, String p_fechaini, String p_fechafin, String p_DataCategory) {
       List<CountVenta> listVtaByCategory = new ArrayList();
       qry = "SELECT "
               + " A.NOMBRE USUARIO, "
               + " X.ID_PRODUCT, "
               + " Z.PRODUCT ||' '|| Z.DESCRIPCION PRODUCT, "
               + " SUM(X.CANTIDAD) CANTIDAD, "
               + " SUM(X.SUBTOTAL) SUBTOTAL "
               + " FROM VT.VENTA_DETALLE X, VT.VENTAS Y, VT.PRODUCT Z, VT.VT_USUARIOS A "
               + " WHERE X.ID_PRODUCT = Z.ID_PRODUCT "
               + " AND X.VENTA_ID_FOLIO = Y.ID_FOLIO "
               + " AND Y.USUARIO_ID_USUARIO = A.ID_USUARIO "
               + " AND ID_CATEGORY IN (2) "
               + " AND TO_CHAR(Y.FECHA, 'DD/MM/YYYY') BETWEEN TO_DATE('" + p_fechaini + "', 'DD/MM/YYYY') AND TO_DATE('" + p_fechafin + "', 'DD/MM/YYYY') "
               + " AND Y.USUARIO_ID_USUARIO IN (SELECT ID_USUARIO FROM VT_USUARIOS) "
               + " GROUP BY X.ID_PRODUCT, Z.PRODUCT, Z.DESCRIPCION, A.NOMBRE ORDER BY A.NOMBRE, Z.PRODUCT ";
       
       System.out.println(qry);
       try{
           this.iniciaOperacion();
           final SQLQuery sql = session.createSQLQuery(qry);
           listVtaByCategory = getRecordVtaByCategory(sql.list());
       }catch(HibernateException e){
           listVtaByCategory = null;
           this.manejaException(e);
           throw e;
       }finally{
           session.close();
       }
       return listVtaByCategory;
   }   
   private List<CountVenta> getRecordVtaByCategory(List list){
       List<CountVenta> nlist = new ArrayList<>();
       for (int i = 0; i < list.size(); i++) {
           Object[] item = (Object[]) list.get(i);
           CountVenta cv = new CountVenta();
           System.out.println("Usuario: " + item[0].toString());
           //System.out.println("Id_product: " + item[1].toString() + " - " + item[2].toString() + " - " + item[3].toString() + " - " + item[4].toString());
           cv.setUsuario(item[0].toString());
           cv.setId_product(item[1].toString());
           cv.setProduct(item[2].toString());
           cv.setCantidad(Integer.parseInt(item[3].toString()));
           cv.setSubtotal(Double.parseDouble(item[4].toString()));
           System.out.println("Id_product: " + cv.getId_product() + " - " + cv.getProduct() + " - " + cv.getCantidad() + " - " + cv.getSubtotal());
       }
       return nlist;
   }
   
   
   public List<CountVenta> getCountVenta(Usuario usuario, String p_fechaini, String p_fechafin) {
       List<CountVenta> listCountVenta = new ArrayList();
        Connection con;
        CallableStatement cs = null;
        ResultSet rs;
        try {
            con = cBH.getConectionJDBC();
            if (null != con) {
                cs = con.prepareCall("BEGIN VT.PUNTO_VENTA.GET_COUNT_VENTA(?,?,?,?); END;");
                cs.setString("P_FECHA_INI", p_fechaini);
                cs.setString("P_FECHA_FIN", p_fechafin);
                cs.registerOutParameter("P_MSJ", OracleTypes.VARCHAR);
                cs.registerOutParameter("C_CountVenta", OracleTypes.CURSOR);
                cs.execute();
                String parametro1 = (String)cs.getString("P_MSJ");
                System.out.println("Parametro1 : " + parametro1);
                
                rs = (ResultSet) cs.getObject("C_CountVenta");
                System.out.println("Cursor: " + rs);
                while (rs.next()) {
                    CountVenta cv = new CountVenta();
                    cv.setUsuario(rs.getString("USUARIO"));
                    cv.setId_product(rs.getString("ID_PRODUCT"));
                    cv.setProduct(rs.getString("PRODUCT"));
                    cv.setCantidad(Integer.parseInt(rs.getString("CANTIDAD")));
                    cv.setSubtotal(Double.parseDouble(rs.getString("SUBTOTAL")));                     
                    listCountVenta.add(cv);
                }
            }            
        } catch (SQLException | NumberFormatException ex) {
            listCountVenta = null;
            System.out.println("Exception: " + ex.getMessage());
            return listCountVenta;
        } finally {
            try {                
                cs.close();
            } catch (SQLException ex) {
                System.out.println("cs.close: " + ex.getMessage());
            }
        }
        return listCountVenta;
    }
   
   public List<CountVenta> getSaleByCategory(String dataCategory, Usuario usuario, String p_fechaini, String p_fechafin) {
       List<CountVenta> listCountVenta = new ArrayList();
        Connection con;
        CallableStatement cs = null;
        ResultSet rs;
        String vUsuario;
        try {
            con = cBH.getConectionJDBC();
            if (null != con) {
                cs = con.prepareCall("BEGIN VT.PUNTO_VENTA.GET_SALE_BY_CATEGORIA(?,?,?,?,?); END;");
                cs.setString("P_DATA_CATEGORY", dataCategory);
                cs.setString("P_FECHAINI", p_fechaini);
                cs.setString("P_FECHAFIN", p_fechafin);                
                cs.registerOutParameter("P_MENSAJE", OracleTypes.VARCHAR);
                cs.registerOutParameter("C_VENTA", OracleTypes.CURSOR);
                cs.execute();
                String vMensaje = (String)cs.getString("P_MENSAJE");
                System.out.println("Mensaje: " + vMensaje);
                
                rs = (ResultSet) cs.getObject("C_VENTA");
                System.out.println("Cursor: " + rs);
                while (rs.next()) {
                    CountVenta cv = new CountVenta();
                    cv.setUsuario(rs.getString("USUARIO"));
                    cv.setId_product(rs.getString("ID_PRODUCT"));
                    cv.setProduct(rs.getString("PRODUCT"));
                    cv.setCantidad(Integer.parseInt(rs.getString("CANTIDAD")));
                    cv.setSubtotal(Double.parseDouble(rs.getString("SUBTOTAL")));                     
                    listCountVenta.add(cv);
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            listCountVenta = null;
            return listCountVenta;
        } finally {
            try {                
                cs.close();
            } catch (SQLException ex) {
                System.out.println("cs.close: " + ex.getMessage());
            }
        }
        return listCountVenta;
    }
}