/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import com.puntodeventa.global.report.DataSource.CompraProductDS;
import com.puntodeventa.global.report.bean.CompraProduct;
import com.puntodeventa.services.DAO.CompraDAO;
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
 * @author Nato
 */
public class printCompraProduct {    
    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;    
    static CompraDAO compraDAO = new CompraDAO();
    static CompraProductDS compraProductDS = new CompraProductDS();
    static CompraProduct listC;
    
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    
    public boolean getPrintCompraList(String fechaIni, String fechaFin){
        try {
            List<CompraProduct> listCompraProduct;
            listCompraProduct = compraDAO.getListCompra(fechaIni, fechaFin);
            
            if(listCompraProduct.isEmpty()){
                System.out.println("No hay informacion procesada.");
            }
                Map param = new HashMap();
                param.put("logo", pathImage + "splash1.jpg");
                param.put("fecha_ini", fechaIni);
                param.put("fecha_fin", fechaFin);

                for(CompraProduct c: listCompraProduct){
                    listC = new CompraProduct(
                            c.getFolio_c(),
                            c.getFecha(),
                            c.getId_proveedor(),
                            c.getProveedor(),
                            c.getId_usuario(),
                            c.getUsuario(),
                            c.getId_product(),
                            c.getProduct(),
                            c.getDescripcion(),
                            c.getP_compra(),
                            c.getCantidad(),
                            c.getTotCantidad());

                    compraProductDS.addCompraList(listC);
                }

                String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/compraProduct.jasper";            
                Reporte = (JasperReport) JRLoader.loadObject(archivo);
                impresion= JasperFillManager.fillReport(Reporte, param, compraProductDS);
                jviewer = new JasperViewer(impresion,false);
                jviewer.setTitle("Historial de Compra del " + fechaIni + " al " + fechaFin);
                jviewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                jviewer.setVisible(true);
                compraProductDS.cleanBean();
                return true;
            
        } catch (JRException ex) {
            Logger.getLogger(printProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
