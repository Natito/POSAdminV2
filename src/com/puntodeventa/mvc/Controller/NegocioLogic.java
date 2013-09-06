/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.mvc.Model.Negocio;
import com.puntodeventa.services.DAO.NegocioDAO;
import java.util.List;

/**
 *
 * @author Nato
 */
public class NegocioLogic {
    static NegocioDAO negocioDAO = new NegocioDAO();
    
    public List getNegocio(){
        List<Negocio> listNegocio;
        listNegocio = negocioDAO.listNegocio();
        return listNegocio;
    }
    
}
