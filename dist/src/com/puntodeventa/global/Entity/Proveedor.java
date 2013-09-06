/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt.Proveedor")
public class Proveedor implements Serializable{
    @Id
    @Column(name="cve_proveedor")
    private BigInteger cve_proveedor;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono")
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(BigInteger cve_proveedor, String nombre, String direccion, String telefono) {
        this.cve_proveedor = cve_proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * @return the cve_proveedor
     */
    public BigInteger getCve_proveedor() {
        return cve_proveedor;
    }

    /**
     * @param cve_proveedor the cve_proveedor to set
     */
    public void setCve_proveedor(BigInteger cve_proveedor) {
        this.cve_proveedor = cve_proveedor;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
