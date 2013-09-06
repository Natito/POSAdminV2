package com.puntodeventa.global.Util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author Fortunato Hdez Hdez
 */
public class ValidacionForms {
    
    // Mensaje: Variables del tipo de mensaje
    static int INFO = JOptionPane.INFORMATION_MESSAGE,
               ERR = JOptionPane.ERROR_MESSAGE,
               WARN = JOptionPane.WARNING_MESSAGE,
               OPT = JOptionPane.YES_NO_OPTION,
               QUE = JOptionPane.QUESTION_MESSAGE;
           
    // Metodo: Obtiene la hora actual del equipo(sistema)
    public String horaActual(){
        Date hora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(hora);
    }
    
     // Metodo: Obtiene la fecha actual del equipo(sistema)
    public String fechaActual(){
        Date hora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(hora);
    }
        
    // Metodo: Valida la entrada de datos a numerico
    public void soloNumeros(KeyEvent evt){
        char caracter = evt.getKeyChar();
        if (((caracter < '0')||(caracter > '9'))&&(caracter != KeyEvent.VK_9)){
            evt.consume(); //Ignora el evento de teclado
        }
    }
    
    // Metodo: Valida la entrada de datos a alfabeto a-z , A-Z
    public void soloLetras(KeyEvent evt){
        int k = (int)evt.getKeyChar();
        if (k > 47 && k < 58){
            k = (int)evt.getKeyChar() + 1;
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
    }
    
    // Metodo: Permite validar la longitud de la caja de texto
     public void longitudCaga(JTextField jtxtName,int tamanio, KeyEvent evt){
        int val = jtxtName.getText().length();
        int aux = tamanio -1;
        if(val > aux ){
            evt.consume();
        }
    }         
        
    /**     
     * Limpia todo las filas de la tabla
     */
    public void cleanTable(JTable myTabla, DefaultTableModel myModelo){
        int row = myTabla.getRowCount();
        if(row > 0){
            for(int i = 0; i < row; row--){
                myModelo.removeRow(i);
            }
        }
    }
    
    public void anchoColumTable(JTable myTabla) {
        // Asignamos ancho de columnas de un JTable
        int[] anchos = {5, 150, 10, 10, 10};
        for (int i = 0; i < myTabla.getColumnCount(); i++) {
            myTabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    
    /**
     * Metodo para limpiar las listas deplegables
     * Elimina los elementos de la lista, excepto el primero
     * @param myCombo name the JComboBox
     */
    public boolean cleanJCombo(JComboBox myCombo){
        int itemCount = myCombo.getItemCount();
        for(int i = 1; i < itemCount; itemCount --){
            myCombo.removeItemAt(i);
        }
        return true;
    } 
    
    // Metodo para limpiar un grupo de JTextField de un Panel   
    public void cleanTextField(JPanel myJPanel){
        Component[] componentes =myJPanel.getComponents(); 
        for(int i=0; i<componentes.length;i++) { 
            if(componentes[i] instanceof JTextField) {
                ((JTextField)componentes[i]).setText("");
            } 
        } 
    }        
    
    /**
     * Metodo que permite editar componentes JTextField de un JPanel
     */
    public void editableTextFields(JPanel jpane, Boolean ban) {
        Component[] componentes =jpane.getComponents(); 
        for(int i=0; i<componentes.length;i++) { 
            if(componentes[i] instanceof JTextField) { 
                ((JTextField)componentes[i]).setEditable(ban);
            } 
        } 
    }
    
    public void editableJCalendarCombo(JPanel jpane, Boolean ban) {
        Component[] componentes =jpane.getComponents(); 
        for(int i=0; i<componentes.length;i++) { 
            if(componentes[i] instanceof JCalendarCombo) { 
                ((JCalendarCombo)componentes[i]).setEnabled(ban);
            } 
        } 
    }
    
    /**
     * Method: Pide Contrasenia de desbloquear usuario del sistema
     * Devuelve un String
     */
    public String pidePassword(){
        JPasswordField pass = new JPasswordField();
        pass.requestFocus();        
        JOptionPane.showMessageDialog(null, pass, "Password", INFO);
        pass.requestFocus();
        return pass.getText();
    }
    
    /*
     * Convierte Minus a Mayus en evento KeyPressed de un JTextField
     */
    public void convertMayus(JTextField jtxtName){
        jtxtName.setText(jtxtName.getText().toUpperCase());        
        jtxtName.getText().toUpperCase();
    }
    
    /**
     * Method: Muestra un Pane de mensaje de Informacion
     * @params message
     */
    public void msjInfo(String message){
        JOptionPane.showMessageDialog(null, message, "Informacion", INFO);
    }
    
    /**
     * Method: Muestra un Pane de mensaje de error
     * @param message
     */
    public void msjErr(String message){
        JOptionPane.showMessageDialog(null, message, "Error", ERR);
    }
    
    /*
     * Method: Muestra un mensaje de advertencia
     * @params message
     */
    public void msjWarn(String message){
        JOptionPane.showMessageDialog(null, message, "Advertencia", WARN);
    }
    
    /*
     * Mensaje de opcion/confirmacion Aceptar-Cancelar
     * Devuelve cero(0) si la opcion es Aceptar
     * Devuelve dos(2) si la opcion es Cancelar
     */    
    public int msjOption(String message, String title){
        int op = JOptionPane.showConfirmDialog(null, message, title, OPT);
        return op;
    }
    
    /**
     * Centraliza el formulario en la Pantalla principal
     */
    public boolean centerFrame(JInternalFrame myFrame) {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setLocation((pantalla.width - myFrame.getPreferredSize().width)/2, (pantalla.height - myFrame.getPreferredSize().height)/2);
        return true;
    }
    
    public  synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));        
        return ((int) diferencia);
    }
}