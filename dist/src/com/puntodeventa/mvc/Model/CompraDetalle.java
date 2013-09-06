package com.puntodeventa.mvc.Model;

import com.puntodeventa.global.Entity.Compra;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Nato
 */
@Entity
@Table(name="vt.Compra_Detalle")
public class CompraDetalle implements Serializable {    
    
    @ManyToOne
    private Compra compra;    
    @Column(name="id_product")
    private String id_product;
    @Column(name="cantidad")
    private int cantidad;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="id")
    private long id;    
    
    

    public CompraDetalle() {
    }    

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
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
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    
}
