/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import com.puntodeventa.global.report.DataSource.ListProductDS;
import com.puntodeventa.global.report.bean.ListProduct;
import com.puntodeventa.services.DAO.ProductDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fortunato Hernandez Hernandez
 */
public class printProduct {
    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;
    static ProductDAO productDAO = new ProductDAO();
    static ListProductDS listProductDS = new ListProductDS();
    static ListProduct listP;
    
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    
    public boolean getPrintProductList(){
        try {
            List<ListProduct> listProduct = null;
            listProduct = productDAO.getListProduct();
            
            Map param = new HashMap();
            param.put("logo", pathImage + "splash.png");
            
            for(ListProduct p: listProduct){
                listP = new ListProduct(p.getId_product(), 
                        p.getProduct(), 
                        p.getDescripcion(), 
                        p.getP_compra(), 
                        p.getP_venta(), 
                        p.getCantidad(), 
                        p.getCategory(), 
                        p.getNegocio(), 
                        p.getFecha_actualiza(), 
                        p.getFecha());
                listProductDS.addListProduct(listP);
            }
            
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/listProduct.jasper";
            Reporte = (JasperReport) JRLoader.loadObject(archivo);
            impresion= JasperFillManager.fillReport(Reporte, param, listProductDS);
            jviewer = new JasperViewer(impresion,false);
            jviewer.setTitle("Articulos de Abarrotes");
            jviewer.setExtendedState(jviewer.MAXIMIZED_BOTH);            
            jviewer.setVisible(true);  
            listProductDS.cleanBean();
            return true;
        } catch (JRException ex) {
            Logger.getLogger(printProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean getPrintProdToInventoryList(){
        try {
            List<ListProduct> listProduct = null;
            listProduct = productDAO.getListProduct();
            
            Map param = new HashMap();
            param.put("logo", pathImage + "splash.png");
            
            for(ListProduct p: listProduct){
                listP = new ListProduct(p.getId_product(), 
                        p.getProduct(), 
                        p.getDescripcion(), 
                        p.getP_compra(), 
                        p.getP_venta(), 
                        p.getCantidad(), 
                        p.getCategory(), 
                        p.getNegocio(), 
                        p.getFecha_actualiza(), 
                        p.getFecha());
                listProductDS.addListProduct(listP);
            }
            
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/listProdInventario.jasper";
            Reporte = (JasperReport) JRLoader.loadObject(archivo);
            impresion= JasperFillManager.fillReport(Reporte, param, listProductDS);
            jviewer = new JasperViewer(impresion,false);
            jviewer.setTitle("Articulos de Abarrotes");
            jviewer.setExtendedState(jviewer.MAXIMIZED_BOTH);            
            jviewer.setVisible(true);  
            listProductDS.cleanBean();
            return true;
        } catch (JRException ex) {
            Logger.getLogger(printProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
