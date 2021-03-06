package com.puntodeventa.mvc.Controller;

import com.puntodeventa.global.Entity.VentaDetalle;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.services.DAO.VentaDetalleDAO;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class VentadDetalleLogic {

    VentaDetalleDAO ventaDetalleDAO = new VentaDetalleDAO();
    LogHelper objLog = new LogHelper("VentadDetalleLogic");

    public boolean saveVentaDetalle(ArrayList<VentaDetalle> ventaDetalle) {
        boolean returnValue;
        try {
            ventaDetalleDAO.saveVentaDetalle(ventaDetalle);
            returnValue = true;
        } catch (Exception e) {
            returnValue = false;
            objLog.Log(e.getMessage());
        }
        return returnValue;

    }
}