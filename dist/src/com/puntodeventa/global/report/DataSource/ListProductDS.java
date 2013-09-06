/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.DataSource;


import com.puntodeventa.global.report.bean.ListProduct;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Fortunato Hernandez Hernandez
 */

public class ListProductDS implements JRDataSource{
    private List<ListProduct> listProduct = new ArrayList<ListProduct>();
    private int indexProductList = -1;
    

    
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        
        if("id_product".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getId_product();
        }else if ("product".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getProduct();
        }else if ("descripcion".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getDescripcion();            
        }else if ("p_compra".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getP_compra();            
        }else if ("p_venta".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getP_venta();            
        }else if ("cantidad".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getCantidad();            
        }else if ("category".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getCategory();            
        }else if ("fecha_actualizada".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getFecha_actualiza();
        }else if ("fecha".equals(jrf.getName())){
            valor = listProduct.get(indexProductList).getFecha();
        }
        return valor;
    }
    
    public boolean next() throws JRException {
        return ++ indexProductList < listProduct.size();
    }   
    
    public void addListProduct(ListProduct listProduct){
        this.listProduct.add(listProduct);
    }
    
    public void cleanBean(){
        this.listProduct.clear();
        this.indexProductList = -1;
    }
    
}
