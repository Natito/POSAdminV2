/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt.Formularios")
public class Formularios implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="id_forma")
    private int id_forma;
    @Column(name="cve_forma")
    private String cve_forma;
    @Column(name="descripcion")
    private String descripcion;

    public Formularios() {
    }

    

    /**
     * @return the id_forma
     */
    public int getId_forma() {
        return id_forma;
    }

    /**
     * @param id_forma the id_forma to set
     */
    public void setId_forma(int id_forma) {
        this.id_forma = id_forma;
    }

    /**
     * @return the cve_forma
     */
    public String getCve_forma() {
        return cve_forma;
    }

    /**
     * @param cve_forma the cve_forma to set
     */
    public void setCve_forma(String cve_forma) {
        this.cve_forma = cve_forma;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
