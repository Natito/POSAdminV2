/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.bean;

/**
 *
 * @author Nato
 */
public class CountVenta {
    private String usuario;
    private String id_product;    
    private String product;    
    private int cantidad;
    private double subtotal;

    public CountVenta() {
    }

    public CountVenta(String usuario, String id_product, String product, int cantidad, double subtotal) {
        this.usuario = usuario;
        this.id_product = id_product;
        this.product = product;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    
    
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the id_product
     */
    public String getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
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
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
