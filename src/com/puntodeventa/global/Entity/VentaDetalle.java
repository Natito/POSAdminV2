package com.puntodeventa.global.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author USER
 */
@Entity
@Table(name = "vt.Venta_detalle")
public class VentaDetalle implements Serializable {

    public VentaDetalle(int ID_FOLIO, String ID_PRODUCT, int CANTIDAD, int SUBTOTAL) {
        this.ID_FOLIO = ID_FOLIO;
        this.ID_PRODUCT = ID_PRODUCT;
        this.CANTIDAD = CANTIDAD;
        this.SUBTOTAL = SUBTOTAL;
    }

    public VentaDetalle() {
    }
    
    @Column(name = "Id_folio")
    @Id
    private int ID_FOLIO;
    @Column(name = "Id_folio")
    @Id
    private String ID_PRODUCT;
    @Column(name = "Id_folio")
    @Id
    private int CANTIDAD;
    @Column(name = "Id_folio")
    @Id
    private double SUBTOTAL;

    public int getID_FOLIO() {
        return ID_FOLIO;
    }

    public void setID_FOLIO(int ID_FOLIO) {
        this.ID_FOLIO = ID_FOLIO;
    }

    public String getID_PRODUCT() {
        return ID_PRODUCT;
    }

    public void setID_PRODUCT(String ID_PRODUCT) {
        this.ID_PRODUCT = ID_PRODUCT;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public double getSUBTOTAL() {
        return SUBTOTAL;
    }

    public void setSUBTOTAL(double SUBTOTAL) {
        this.SUBTOTAL = SUBTOTAL;
    }
}