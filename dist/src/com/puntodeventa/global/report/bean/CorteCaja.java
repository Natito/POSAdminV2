/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.bean;

/**
 *
 * @author Nato
 */
public class CorteCaja {

    private String id_folio;
    private String fecha;
    private double efvo_inicial;
    private double total_precioventa;
    private double efvo_caja;
    private int numero_de_ventas;
    private double desviacion;
    private String id_usuario;
    /*
     * folioventa_from 
     * folioventa_to 
     * total_preciocompra 
     * total_corte
     */

    public CorteCaja() {
    }

    /**
     * @return the id_folio
     */
    public String getId_folio() {
        return id_folio;
    }

    /**
     * @param id_folio the id_folio to set
     */
    public void setId_folio(String id_folio) {
        this.id_folio = id_folio;
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
     * @return the efvo_inicial
     */
    public double getEfvo_inicial() {
        return efvo_inicial;
    }

    /**
     * @param efvo_inicial the efvo_inicial to set
     */
    public void setEfvo_inicial(double efvo_inicial) {
        this.efvo_inicial = efvo_inicial;
    }

    /**
     * @return the total_precioventa
     */
    public double getTotal_precioventa() {
        return total_precioventa;
    }

    /**
     * @param total_precioventa the total_precioventa to set
     */
    public void setTotal_precioventa(double total_precioventa) {
        this.total_precioventa = total_precioventa;
    }

    /**
     * @return the efvo_caja
     */
    public double getEfvo_caja() {
        return efvo_caja;
    }

    /**
     * @param efvo_caja the efvo_caja to set
     */
    public void setEfvo_caja(double efvo_caja) {
        this.efvo_caja = efvo_caja;
    }

    /**
     * @return the numero_de_ventas
     */
    public int getNumero_de_ventas() {
        return numero_de_ventas;
    }

    /**
     * @param numero_de_ventas the numero_de_ventas to set
     */
    public void setNumero_de_ventas(int numero_de_ventas) {
        this.numero_de_ventas = numero_de_ventas;
    }

    /**
     * @return the desviacion
     */
    public double getDesviacion() {
        return desviacion;
    }

    /**
     * @param desviacion the desviacion to set
     */
    public void setDesviacion(double desviacion) {
        this.desviacion = desviacion;
    }

    /**
     * @return the id_usuario
     */
    public String getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
