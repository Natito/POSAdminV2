/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.Formularios;
import com.puntodeventa.services.DAO.FormulariosDAO;
import java.util.List;

/**
 *
 * @author Nato
 */
public class FormularioLogic {
    FormulariosDAO formsDAO = new FormulariosDAO();
    
    public String saveForms(Formularios formularios){
        String id_forma;
        id_forma = formsDAO.saveForms(formularios);
        return id_forma;
    }
    
    public void updateForms(Formularios formulario){
        formsDAO.updateForms(formulario);
    }
    
    public Formularios getFormulario(String cve_forma){
        Formularios forms;
        forms = formsDAO.getByCveForms(cve_forma);
        return forms;
    }
    
    public List<Formularios> getAllFormularios(){
        List<Formularios> listForms;
        listForms = formsDAO.getAllForms();
        return listForms;
    }
}
