/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.DataSource;

import com.puntodeventa.global.report.bean.CompraProduct;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Nato
 */
public class CompraProductDS implements JRDataSource{
    private List<CompraProduct> listCompra = new ArrayList<>();
    private int indexCompraList = -1;

    
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()) {
            case "folio_c":
                valor = listCompra.get(indexCompraList).getFolio_c();
                break;
            case "fecha":
                valor = listCompra.get(indexCompraList).getFecha();
                break;
            case "id_proveedor":
                valor = listCompra.get(indexCompraList).getId_proveedor();
                break;
            case "proveedor":
                valor = listCompra.get(indexCompraList).getProveedor();
                break;
            case "id_usuario":
                valor = listCompra.get(indexCompraList).getId_usuario();
                break;
            case "usuario":
                valor = listCompra.get(indexCompraList).getUsuario();
                break;
            case "id_product":
                valor = listCompra.get(indexCompraList).getId_product();
                break;
            case "product":
                valor = listCompra.get(indexCompraList).getProduct();
                break;
            case "descripcion":
                valor = listCompra.get(indexCompraList).getDescripcion();
                break;
            case "p_compra":
                valor = listCompra.get(indexCompraList).getP_compra();
                break;
            case "cantidad":
                valor = listCompra.get(indexCompraList).getCantidad();
                break;
            case "totCantidad":
                valor = listCompra.get(indexCompraList).getTotCantidad();
                break;
        }
        return valor;
    }
    
    @Override
    public boolean next() throws JRException {
        return ++ indexCompraList < listCompra.size();
    }
    
    public void addCompraList(CompraProduct compraProduct){
        this.listCompra.add(compraProduct);
    }
    
    public void cleanBean(){
        this.listCompra.clear();
        this.indexCompraList = -1;
    }
    
}
