/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt.Compra")
public class Compra implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="folio_c")    
    private long folio_c;
    @Column(name="id_proveedor")
    private BigInteger id_proveedor;
    @Column(name="fecha")
    private String fecha;
    @Column(name="cantidad")
    private int cantidad;
    @ManyToOne
    private Usuario usuario;
    

    public Compra() {
    }

    public Compra(BigInteger id_proveedor, String fecha, int cantidad, Usuario usuario) {
        this.id_proveedor = id_proveedor;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }

    /**
     * @return the folio_c
     */
    public long getFolio_c() {
        return folio_c;
    }

    /**
     * @param folio_c the folio_c to set
     */
    public void setFolio_c(long folio_c) {
        this.folio_c = folio_c;
    }

    /**
     * @return the id_proveedor
     */
    public BigInteger getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(BigInteger id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
        
}
