/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import com.puntodeventa.global.printservice.printService;
import com.puntodeventa.global.report.DataSource.VentaProductDS;
import com.puntodeventa.global.report.bean.VentaProduct;
import com.puntodeventa.services.DAO.VentaDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nato
 */
public class printVentaProduct {
    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;    
    static VentaDAO ventaDAO = new VentaDAO();    
    static VentaProductDS ventaProductDS = new VentaProductDS();
    static VentaProduct listV;
    
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    
    public boolean getPrintVentaList(String fechaIni, String fechaFin){
        try {
            List<VentaProduct> listVentaProduct;
            listVentaProduct = ventaDAO.getListVenta(fechaIni, fechaFin);
            
            Map param = new HashMap();
            param.put("logo", pathImage + "splash1.jpg");
            param.put("fecha_ini", fechaIni);
            param.put("fecha_fin", fechaFin);
            
            for(VentaProduct v: listVentaProduct){
                
                listV = new VentaProduct(
                        v.getId_folio(),
                        v.getFecha(),
                        v.getId_usuario(),
                        v.getUsuario(),
                        v.getId_product(),
                        v.getProducto(),
                        v.getDescripcion(),
                        v.getP_venta(),
                        v.getCantidad(),
                        v.getSubtotal(),
                        v.getTotCantidad(),
                        v.getTotal());
                ventaProductDS.addVentaList(listV);
            }
            
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/ventaProduct.jasper";
            Reporte = (JasperReport) JRLoader.loadObject(archivo);
            impresion= JasperFillManager.fillReport(Reporte, param, ventaProductDS);
            jviewer = new JasperViewer(impresion,false);
            jviewer.setTitle("Historial del Ventas del " + fechaIni + " al " + fechaFin);
            jviewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            jviewer.setVisible(true);  
            ventaProductDS.cleanBean();
            return true;
        } catch (JRException ex) {
            Logger.getLogger(printProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public boolean getPrintVentaId(String id_folio){
        try {
            byte[] pdfBuffer;
            List<VentaProduct> listVentaProduct;
            listVentaProduct = ventaDAO.getVentaId(id_folio);
            
            Map param = new HashMap();
            param.put("logo", pathImage + "splash1.jpg");
            //param.put("fecha_ini", fechaIni);
            
            for(VentaProduct v: listVentaProduct){                
                listV = new VentaProduct(
                        v.getId_folio(),
                        v.getFecha(),
                        v.getId_usuario(),
                        v.getUsuario(),
                        v.getId_product(),
                        v.getProducto(),
                        v.getDescripcion(),
                        v.getP_venta(),
                        v.getCantidad(),
                        v.getSubtotal(),
                        v.getTotCantidad(),
                        v.getTotal());
                ventaProductDS.addVentaList(listV);
            }
            
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/ventaId.jasper";            
            
            Reporte = (JasperReport) JRLoader.loadObject(archivo);            
            JasperPrint jasperPrint = (JasperPrint)JasperFillManager.fillReport(Reporte, param, ventaProductDS);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("D:\\vPuntoVenta/ventas/"+id_folio+".pdf"));
            exporter.exportReport();
            ventaProductDS.cleanBean();
            return true;
        } catch (JRException ex) {
            Logger.getLogger(printProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
