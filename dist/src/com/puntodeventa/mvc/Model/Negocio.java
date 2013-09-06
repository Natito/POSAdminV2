/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Model;

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
@Table(name="vt.Negocio")
public class Negocio implements Serializable {
    @Id
    @Column(name="Id_negocio")
    private String id_negocio;
    @Column(name="Negocio")
    private String negocio;

    public Negocio() {
    }

    public Negocio(String id_negocio, String negocio) {
        this.id_negocio = id_negocio;
        this.negocio = negocio;
    }

    /**
     * @return the id_negocio
     */
    public String getId_negocio() {
        return id_negocio;
    }

    /**
     * @param id_negocio the id_negocio to set
     */
    public void setId_negocio(String id_negocio) {
        this.id_negocio = id_negocio;
    }

    /**
     * @return the negocio
     */
    public String getNegocio() {
        return negocio;
    }

    /**
     * @param negocio the negocio to set
     */
    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }
    
    
    
}
