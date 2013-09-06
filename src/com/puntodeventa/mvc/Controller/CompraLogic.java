/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.mvc.Model.CompraDetalle;
import com.puntodeventa.services.DAO.CompraDAO;

/**
 *
 * @author Nato
 */
public class CompraLogic {
    
    public boolean isSavedCompraDetalle(CompraDetalle compraDetalle){
        CompraDAO compraDAO = null;
        compraDAO.saveCompraDetalle(compraDetalle);
        return true;
    }
}
