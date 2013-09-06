/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Proveedor;
import com.puntodeventa.services.DAO.ProveedorDAO;
import java.math.BigInteger;

/**
 *
 * @author Nato
 */
public class ProveedorLogic {
    static ProveedorDAO proveedorDAO = new ProveedorDAO();
    
        
    public Proveedor getProveedor(BigInteger cve_proveedor){
        Proveedor proveedor = null;
        proveedor = proveedorDAO.selectProveedor(cve_proveedor);
        return proveedor;
    }
}
