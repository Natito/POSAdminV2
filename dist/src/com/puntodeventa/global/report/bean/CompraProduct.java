/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.bean;

import java.math.BigInteger;

/**
 *
 * @author Nato
 */
public class CompraProduct {
    private BigInteger folio_c;
    private String fecha;
    private BigInteger id_proveedor;
    private String proveedor;
    private BigInteger id_usuario;
    private String usuario;
    private String id_product;
    private String product;
    private String descripcion;
    private Double p_compra;
    private int cantidad;
    private int totCantidad;

    public CompraProduct() {
    }

    public CompraProduct(BigInteger folio_c, String fecha, BigInteger id_proveedor, String proveedor, BigInteger id_usuario, String usuario, String id_product, String product, String descripcion, Double p_compra, int cantidad, int totCantidad) {
        this.folio_c = folio_c;
        this.fecha = fecha;
        this.id_proveedor = id_proveedor;
        this.proveedor = proveedor;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.id_product = id_product;
        this.product = product;
        this.descripcion = descripcion;
        this.p_compra = p_compra;
        this.cantidad = cantidad;
        this.totCantidad = totCantidad;
    }

    /**
     * @return the folio_c
     */
    public BigInteger getFolio_c() {
        return folio_c;
    }

    /**
     * @param folio_c the folio_c to set
     */
    public void setFolio_c(BigInteger folio_c) {
        this.folio_c = folio_c;
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
     * @return the proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the id_usuario
     */
    public BigInteger getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(BigInteger id_usuario) {
        this.id_usuario = id_usuario;
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

    /**
     * @return the p_compra
     */
    public Double getP_compra() {
        return p_compra;
    }

    /**
     * @param p_compra the p_compra to set
     */
    public void setP_compra(Double p_compra) {
        this.p_compra = p_compra;
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
     * @return the totCantidad
     */
    public int getTotCantidad() {
        return totCantidad;
    }

    /**
     * @param totCantidad the totCantidad to set
     */
    public void setTotCantidad(int totCantidad) {
        this.totCantidad = totCantidad;
    }

    
}
