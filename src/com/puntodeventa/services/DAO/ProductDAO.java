package com.puntodeventa.services.DAO;

import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.report.bean.ListProduct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class ProductDAO {

    static final Logger LOG = Logger.getLogger(ProductDAO.class.getName());
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

    //Metodo Guarda Producto
    public String saveProduct(Product product) {
        LOG.log(Level.INFO, "saveProduct()");
        String id_product;
        try {
            this.iniciaOperacion();
            id_product = (String) session.save(product);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return id_product;
    }

    /**
     * Actualiza los datos de la tabla Product
     */
    public void updateProduct(Product product) throws HibernateException {
        LOG.log(Level.INFO, "updateProduct()");
        try {
            this.iniciaOperacion();
            session.update(product);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Elimina registro de la Tabla Product
     */
    public void deleteProduct(Product product) {
        LOG.log(Level.INFO, "deleteProduct()");
        try {
            this.iniciaOperacion();
            session.delete(product);
            tx.commit();
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo que devuelve un product
     */
    public Product selectProduct(String id_product) {
        LOG.log(Level.INFO, "selectProduct()");
        Product product = null;
        try {
            this.iniciaOperacion();
            product = (Product) session.get(Product.class, id_product);
        } catch (HibernateException he) {
            this.manejaException(he);
            throw he;
        } finally {
            session.close();
        }
        return product;
    }

    public List<Product> listProduct() {
        LOG.log(Level.INFO, "listProduct()");
        List<Product> listProduct = null;
        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery("SELECT * FROM vt.PRODUCT ORDER BY ID_CATEGORY ASC").addEntity(Product.class);
            listProduct = sql.list();
        } finally {
            session.close();
        }
        return listProduct;
    }
    /*
     * Devuelve lista de productos para Reporte ListProduct
     */
    static String qry = " SELECT P.ID_PRODUCT, P.PRODUCT, P.DESCRIPCION, P.P_COMPRA, P.P_VENTA, "
            + " P.CANTIDAD, C.CATEGORY, N.NEGOCIO, P.FECHA_ACTUALIZA, to_char(sysdate,'dd-Mon-yyyy   hh24:mi:ss') FECHA "
            + " FROM VT.PRODUCT P, VT.NEGOCIO N, VT.CATEGORY C "
            + " WHERE P.ID_NEGOCIO = N.ID_NEGOCIO "
            + " AND P.ID_CATEGORY = C.ID_CATEGORY ";

    public List<ListProduct> getListProduct() {
        LOG.log(Level.INFO, "getListProduct()");
        List<ListProduct> listProduct = null;
        try {
            this.iniciaOperacion();
            final SQLQuery sql = session.createSQLQuery(qry).addEntity(ListProduct.class);
            listProduct = sql.list();
        } finally {
            session.close();
        }
        return listProduct;
    }


        
}