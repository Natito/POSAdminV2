/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt.Accesos_forms")
public class AccesoForms implements Serializable{
    @Id
    @Column(name="Id")
    private int id;
    @Column(name="cve_forma")
    private String cve_forma; 
    @Column(name="acceso")
    private String acceso;
    @Column(name="id_usuario")
    private int id_usuario;

    public AccesoForms() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cve_forma
     */
    public String getCveForma() {
        return cve_forma;
    }

    /**
     * @param cve_forma the formulario to set
     */
    public void setCveForma(String cve_forma) {
        this.cve_forma = cve_forma;
    }

    /**
     * @return the acceso
     */
    public String getAcceso() {
        return acceso;
    }

    /**
     * @param acceso the acceso to set
     */
    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    

}
