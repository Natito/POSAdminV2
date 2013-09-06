/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.bean;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Fortunato Hernandez Hernandez
 */
@Entity
public class ListProduct implements Serializable {
    @Id
    private String id_product;
    private String product;
    private String descripcion;
    private Double p_compra;
    private Double p_venta;
    private int cantidad;
    private String category;
    private String negocio;
    private String fecha_actualiza;
    private String fecha;

    public ListProduct() {
    }

    public ListProduct(String id_product, String product, String descripcion, Double p_compra, Double p_venta, int cantidad, String category, String negocio, String fecha_actualiza, String fecha) {
        this.id_product = id_product;
        this.product = product;
        this.descripcion = descripcion;
        this.p_compra = p_compra;
        this.p_venta = p_venta;
        this.cantidad = cantidad;
        this.category = category;
        this.negocio = negocio;
        this.fecha_actualiza = fecha_actualiza;
        this.fecha = fecha;
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
     * @return the p_venta
     */
    public Double getP_venta() {
        return p_venta;
    }

    /**
     * @param p_venta the p_venta to set
     */
    public void setP_venta(Double p_venta) {
        this.p_venta = p_venta;
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
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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

    /**
     * @return the fecha_actualizada
     */
    public String getFecha_actualiza() {
        return fecha_actualiza;
    }

    /**
     * @param fecha_actualiza the fecha_actualizada to set
     */
    public void setFecha_actualiza(String fecha_actualizada) {
        this.fecha_actualiza = fecha_actualizada;
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
    
    
}
