/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;

import com.puntodeventa.global.Entity.Corte;
import com.puntodeventa.global.report.bean.CorteCaja;
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
public class printCorte {
/*
    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;
    static VentaDAO ventaDAO = new VentaDAO();
    
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    
    public boolean getPrintCorte(String id_folio) {
        try {
            byte[] pdfBuffer;
            List<Corte> listCorte;
            listCorte = ventaDAO.getVentaId(id_folio);
                        

            Map param = new HashMap();
            param.put("logo", pathImage + "splash1.jpg");
            //param.put("fecha_ini", fechaIni);

            for (VentaProduct v : listVentaProduct) {
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

            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/corte_caja.jasper";

            Reporte = (JasperReport) JRLoader.loadObject(archivo);
            JasperPrint jasperPrint = (JasperPrint) JasperFillManager.fillReport(Reporte, param, ventaProductDS);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("D:\\vPuntoVenta/ventas/" + id_folio + ".pdf"));
            exporter.exportReport();

            return true;
        } catch (JRException ex) {
            return false;
        }
    }    
    */
}
