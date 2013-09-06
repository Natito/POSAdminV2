/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.DataSource;

import com.puntodeventa.global.report.bean.CountVenta;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Nato
 */
public class CountVentaDS implements JRDataSource {

    private List<CountVenta> listCountVenta = new ArrayList<>();
    private int indexCountVenta = -1;

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch (jrf.getName()) {
            case "usuario":
                valor = listCountVenta.get(indexCountVenta).getUsuario();
                break;
            case "id_product":
                valor = listCountVenta.get(indexCountVenta).getId_product();
                break;
            case "product":
                valor = this.listCountVenta.get(indexCountVenta).getProduct();
                break;
            case "cantidad":
                valor = this.listCountVenta.get(indexCountVenta).getCantidad();
                break;
            case "subtotal":
                valor = this.listCountVenta.get(indexCountVenta).getSubtotal();
                break;
        }
        return valor;
    }

    @Override
    public boolean next() throws JRException {
        return ++indexCountVenta < listCountVenta.size();
    }

    public void addCountVentaList(CountVenta countVenta) {
        this.listCountVenta.add(countVenta);
    }

    public void cleanBean() {
        this.listCountVenta.clear();
        this.indexCountVenta = -1;
    }
}
