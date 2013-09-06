/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.AccesoForms;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.services.DAO.AccesoFormsDAO;
import java.util.List;

/**
 *
 * @author Nato
 */
public class AccesoFormsLogic {
    AccesoFormsDAO accesoFormsDAO = new AccesoFormsDAO();
    
    public List<AccesoForms> selectFormByCveUser(int id_usuario) {
        List<AccesoForms> listForms;
        listForms = accesoFormsDAO.selectFormByCveUser(id_usuario);
        return listForms;
    }
    
    public Long saveForms(AccesoForms accesoForms) {
        Long id;
        id = accesoFormsDAO.saveForms(accesoForms);
        return id;
    }
    
    public void updateForms(AccesoForms accesoForms)  {
        accesoFormsDAO.updateForms(accesoForms);
    }
    
    public void SaveUpdateForms(AccesoForms accesoForms) {
        accesoFormsDAO.SaveUpdateForms(accesoForms);
    }
    
    public String getAcceso(int id_usuario, String ClassName) {
        List<AccesoForms> listAccesoForms;
        String msj = null;
        try {
            listAccesoForms = accesoFormsDAO.selectFormByCveUser(id_usuario);
            for (AccesoForms af : listAccesoForms) {
                if (ClassName.toUpperCase().equals(af.getCveForma().toUpperCase())) {
                    if (af.getAcceso().equals("N")) {
                        msj = (TagHelper.getTag("frmAllForm.acceso"));
                    }else{
                        msj = null;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        return msj;
    }
}
