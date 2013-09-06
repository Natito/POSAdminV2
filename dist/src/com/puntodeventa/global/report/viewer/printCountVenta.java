/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.report.DataSource.CountVentaDS;
import com.puntodeventa.global.report.bean.CountVenta;
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
public class printCountVenta {

    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;
    static VentaDAO ventaDAO = new VentaDAO();
    static CountVentaDS countVentaDS = new CountVentaDS();
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    static CountVenta listCountVenta;

    public boolean getCountVenta(String fecha_i, String fecha_f, Usuario usuario) {
        try {

            List<CountVenta> listventaProduct;
            //listventaProduct = ventaDAO.getCountVenta(fecha_i, fecha_f, usuario);            
            listventaProduct = ventaDAO.getCountVenta(usuario, fecha_i, fecha_f);

            Map param = new HashMap();
            //param.put("logo", pathImage + "splash1.jpg");
            param.put("fecha_i", fecha_i);
            param.put("fecha_f", fecha_f);
            param.put("usuario", usuario.getNombre());

            if (null != listventaProduct) {
                for (CountVenta c : listventaProduct) {
                    listCountVenta = new CountVenta(
                            c.getUsuario(),
                            c.getId_product(),
                            c.getProduct(),
                            c.getCantidad(),
                            c.getSubtotal());

                    countVentaDS.addCountVentaList(listCountVenta);
                }
                String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/CountVenta.jasper";

                Reporte = (JasperReport) JRLoader.loadObject(archivo);
                JasperPrint jasperPrint = (JasperPrint) JasperFillManager.fillReport(Reporte, param, countVentaDS);
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("D:\\vPuntoVenta/CountVenta/countSale.pdf"));
                exporter.exportReport();
                countVentaDS.cleanBean();
                return true;
            }else{
                return false;
            }                
        } catch (JRException ex) {
            Logger.getLogger(printProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean getVentaByCategory(String dataCategory, String fecha_i, String fecha_f, Usuario usuario) {
        try {
            List<CountVenta> listventaProduct;
            //listventaProduct = ventaDAO.getVentaByCategory(usuario, fecha_i, fecha_f, dataCategory);
            listventaProduct = ventaDAO.getSaleByCategory(dataCategory, usuario, fecha_i, fecha_f);
            Map param = new HashMap();
            param.put("fecha_i", fecha_i);
            param.put("fecha_f", fecha_f);
            param.put("usuario", usuario.getNombre());
            System.out.println("Usuario: " + usuario.getNombre());

            if (null != listventaProduct) {
                for (CountVenta c : listventaProduct) {
                    System.out.println("Id_product: " + c.getId_product() + " - " + c.getProduct());
                    listCountVenta = new CountVenta(
                            c.getUsuario(),
                            c.getId_product(),
                            c.getProduct(),
                            c.getCantidad(),
                            c.getSubtotal());

                    countVentaDS.addCountVentaList(listCountVenta);
                }
                
                String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/CountVenta.jasper";

                Reporte = (JasperReport) JRLoader.loadObject(archivo);
                JasperPrint jasperPrint = (JasperPrint) JasperFillManager.fillReport(Reporte, param, countVentaDS);
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                System.out.println("Path: " + TagHelper.getTag("path.ventaByCategory") + "countSale.pdf");
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(TagHelper.getTag("path.ventaByCategory") + "countSale.pdf"));
                //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("D:\\vPuntoVenta/CountVenta/countSale.pdf"));
                exporter.exportReport();
                countVentaDS.cleanBean();
                return true;
            }else{
                System.out.println("La lista no contiene elementos");
                return false;
            }                
        } catch (JRException ex) {
            System.out.println(TagHelper.getTag("JRException.whenopenfile. Error: " + ex.getMessage()));
            return false;
        }
    }
}
