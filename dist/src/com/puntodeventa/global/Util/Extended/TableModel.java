/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Util.Extended;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class TableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int Column) {
        return false;
    }
}
