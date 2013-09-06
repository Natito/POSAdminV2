/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Util;

import java.text.DecimalFormat;
import java.util.Calendar;
import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author Nato
 */
public class ManejaFechas {
    
    // Devuelve fecha seleccionada del JComboCalendar en formato dd/mm/yyyy
    public String getDateCombo(JCalendarCombo miJDate){
        DecimalFormat sdf = new DecimalFormat("00");
        int anio = miJDate.getCalendar().get(Calendar.YEAR);
        int mes = miJDate.getCalendar().get(Calendar.MONTH)+1;
        int dia = miJDate. getCalendar(). get(Calendar.DATE);
        return sdf.format(dia)+"/"+sdf.format(mes)+"/"+anio;
    }
}
