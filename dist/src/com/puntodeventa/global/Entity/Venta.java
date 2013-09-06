package com.puntodeventa.global.Entity;


import java.sql.Timestamp;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author USER
 */
@Entity
@Table(name = "vt.Ventas")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_folio")
    private long idFolio = -1;
    
    @Column(name = "fecha")
    private Timestamp fecha;
    
    @Column(name = "Id_usuario")
    private String idUsuario;
    
    @Column(name = "cve_cliente")
    private int cveCliente;
    
    @Column(name = "cantidad")
    private double cantidad;
    
    @Column(name = "total")
    private double total;

    public Venta(long idFolio, Timestamp fecha, String idUsuario, int cveCliente, double cantidad, double total) {
        this.idFolio = idFolio;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.cveCliente = cveCliente;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Venta() {
    }

    public long getIdFolio() {
        return this.idFolio;
    }

    public void setIdFolio(long idFolio) {
        this.idFolio = idFolio;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(int cveCliente) {
        this.cveCliente = cveCliente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
