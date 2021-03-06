/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Entity.Compra;
import com.puntodeventa.global.Entity.Product;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.Util;
import com.puntodeventa.global.Util.ValidacionForms;
import com.puntodeventa.global.printservice.printService;
import com.puntodeventa.mvc.Controller.AccesoFormsLogic;
import com.puntodeventa.mvc.Controller.ProductLogic;
import com.puntodeventa.mvc.Controller.UsuarioLogic;
import com.puntodeventa.mvc.Model.CompraDetalle;
import com.puntodeventa.services.DAO.CompraDAO;
import com.puntodeventa.services.DAO.ProveedorDAO;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nato
 */
public class jfrmCompra extends javax.swing.JInternalFrame {

    CompraDAO compraDAO = new CompraDAO();
    static ProveedorDAO proveedorDAO = new ProveedorDAO();
    static UsuarioLogic userLogic = new UsuarioLogic();
    AccesoFormsLogic accesoFormsLogic = new AccesoFormsLogic();
    DefaultTableModel modelo = new DefaultTableModel();
    static ValidacionForms valForm = new ValidacionForms();
    static int vActivo;
    private String NameClass = this.getClass().getSimpleName();

    /**
     * Creates new form jfrmCompra
     */
    public jfrmCompra() {
        getInitAcceso(getUser().getId_usuario());
    }

    private void getInitAcceso(int id_usuario) {
        String msj = accesoFormsLogic.getAcceso(id_usuario, NameClass);
        if (msj != null) {
            valForm.msjInfo(msj);
            dispose();
        } else {
           initComponents();
            valForm.centerFrame(this);            
            if (true == this.getTitleTable()) {
                jtxtId_Product.requestFocus();
            }
        }
    }

    private Usuario getUser() {
        Usuario usuario;
        usuario = userLogic.getUserSerializable();
        return usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbpCompra = new javax.swing.JTabbedPane();
        jpnAddProduct = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtxtId_Product = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtProduct = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtPrecioCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtPrecioVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jbtnCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jbtnRCompra = new javax.swing.JButton();
        jbtnBuscaArt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblProduct = new javax.swing.JTable();
        jbtnAgregar = new javax.swing.JButton();
        jlblCantidad = new javax.swing.JLabel();

        setClosable(true);
        setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Codigo:");

        jtxtId_Product.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtId_Product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtId_ProductKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtId_ProductKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Producto:");

        jtxtProduct.setEditable(false);
        jtxtProduct.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtProductKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Descripcion:");

        jtxtDescripcion.setEditable(false);
        jtxtDescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDescripcionActionPerformed(evt);
            }
        });
        jtxtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDescripcionKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Precio Compra:");

        jtxtPrecioCompra.setEditable(false);
        jtxtPrecioCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtPrecioCompraKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Precio Venta:");

        jtxtPrecioVenta.setEditable(false);
        jtxtPrecioVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtPrecioVentaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Cantidad:");

        jtxtCantidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyTyped(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Compras (2).png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Agregue Articulos de su Inventario Realizando una Nueva Compra");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnRCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnRCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Compras (1).png"))); // NOI18N
        jbtnRCompra.setText("Realizar Compra");
        jbtnRCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRCompraActionPerformed(evt);
            }
        });

        jbtnBuscaArt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnBuscaArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jbtnBuscaArt.setText("Buscar");
        jbtnBuscaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscaArtActionPerformed(evt);
            }
        });

        jtblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto / Descripcion", "P / Compra", "P / Venta", "Cantidad"
            }
        ));
        jtblProduct.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblProduct);

        jbtnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Compras (1).png"))); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jlblCantidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlblCantidad.setText("0");
        jlblCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpnAddProductLayout = new javax.swing.GroupLayout(jpnAddProduct);
        jpnAddProduct.setLayout(jpnAddProductLayout);
        jpnAddProductLayout.setHorizontalGroup(
            jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAddProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnAddProductLayout.createSequentialGroup()
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnRCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnAddProductLayout.createSequentialGroup()
                        .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtDescripcion)
                            .addComponent(jtxtProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnAddProductLayout.createSequentialGroup()
                                .addComponent(jtxtId_Product, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnBuscaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnAddProductLayout.createSequentialGroup()
                                .addComponent(jtxtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnAddProductLayout.createSequentialGroup()
                        .addGap(0, 789, Short.MAX_VALUE)
                        .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnAddProductLayout.setVerticalGroup(
            jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnAddProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtId_Product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtPrecioCompra)
                    .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtPrecioVenta)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnAddProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnRCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(169, 169, 169))
        );

        jtbpCompra.addTab("Realizar Nueva Compra", jpnAddProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpCompra)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnRCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRCompraActionPerformed
        try {
            if (jtblProduct.getRowCount() > 0) {
                int msg = valForm.msjOption("Desea realizar la compra ahora?", "Realizar compra");
                if (msg == 0) {
                    BigInteger cve_proveedor = BigInteger.valueOf(0);
                    Usuario usuario;
                    usuario = Util.getCurrentUser();

                    System.out.println("Nombre: " + usuario.getNombre());
                    Compra com = new Compra(
                            cve_proveedor,
                            valForm.fechaActual(),
                            Integer.parseInt(jlblCantidad.getText()),
                            usuario);
                    long folio_c = compraDAO.saveCompra(com);
                    System.out.println("Folio: " + folio_c);

                    for (int i = 0; i < this.jtblProduct.getRowCount(); i++) {

                        CompraDetalle cd = new CompraDetalle();
                        cd.setCompra(com);
                        cd.setId_product(jtblProduct.getValueAt(i, 0).toString());
                        cd.setCantidad(Integer.parseInt(jtblProduct.getValueAt(i, 4).toString()));
                        compraDAO.saveCompraDetalle(cd);
                    }
                    printService.impresion();
                    valForm.cleanTable(jtblProduct, modelo);
                    valForm.msjInfo("Compra realizada correctamente...");
                }
            } else {
                valForm.msjWarn("Agregue al menos un articulo. Lista vacia");
            }
        } catch (Exception ex) {
            System.out.println("Error al guardar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbtnRCompraActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        valForm.cleanTable(jtblProduct, modelo);
        valForm.cleanTextField(jpnAddProduct);
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jtxtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyTyped
        valForm.longitudCaga(jtxtCantidad, 4, evt);
        valForm.soloNumeros(evt);
    }//GEN-LAST:event_jtxtCantidadKeyTyped

    private void jtxtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPrecioVentaKeyTyped
        valForm.longitudCaga(this.jtxtPrecioVenta, 10, evt);
    }//GEN-LAST:event_jtxtPrecioVentaKeyTyped

    private void jtxtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPrecioCompraKeyTyped
        valForm.longitudCaga(this.jtxtPrecioCompra, 10, evt);
    }//GEN-LAST:event_jtxtPrecioCompraKeyTyped

    private void jtxtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDescripcionKeyTyped
        valForm.longitudCaga(this.jtxtDescripcion, 45, evt);
    }//GEN-LAST:event_jtxtDescripcionKeyTyped

    private void jtxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDescripcionActionPerformed
    }//GEN-LAST:event_jtxtDescripcionActionPerformed

    private void jtxtProductKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtProductKeyTyped
        valForm.longitudCaga(this.jtxtProduct, 45, evt);
    }//GEN-LAST:event_jtxtProductKeyTyped

    private void jtxtId_ProductKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtId_ProductKeyTyped
        valForm.longitudCaga(this.jtxtId_Product, 25, evt);
        valForm.soloNumeros(evt);
    }//GEN-LAST:event_jtxtId_ProductKeyTyped

    private void jbtnBuscaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscaArtActionPerformed
        try {
            if ("".equals(this.jtxtId_Product.getText())) {
                valForm.msjWarn("Ingrese el codigo del producto");
                this.jtxtId_Product.requestFocus();
            } else {
                ProductLogic pl = new ProductLogic();
                Product pro = pl.getProduct(this.jtxtId_Product.getText());
                if (null == pro) {
                    valForm.msjErr("No se ha encontrado ningun registro");
                    jtxtId_Product.requestFocus();
                } else {
                    this.jtxtProduct.setText(pro.getProduct());
                    this.jtxtDescripcion.setText(pro.getDescripcion());
                    this.jtxtPrecioCompra.setText(Double.toString(pro.getP_compra()));
                    this.jtxtPrecioVenta.setText(Double.toString(pro.getP_venta()));
                    this.jtxtCantidad.requestFocus();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbtnBuscaArtActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        try {
            if (!jtxtId_Product.getText().equals("") && !jtxtProduct.getText().equals("") && !jtxtCantidad.getText().equals("")) {
                if (Integer.parseInt(jtxtCantidad.getText()) <= 0) {
                    valForm.msjInfo("La cantidad ingresada no es valida...");
                } else {
                    modelo.addRow(new Object[]{this.jtxtId_Product.getText(),
                                this.jtxtProduct.getText() + " " + this.jtxtDescripcion.getText(),
                                this.jtxtPrecioCompra.getText(),
                                this.jtxtPrecioVenta.getText(),
                                this.jtxtCantidad.getText()});
                    int cantidad = 0;
                    for (int i = 0; i < jtblProduct.getRowCount(); i++) {
                        cantidad = cantidad + Integer.parseInt(this.jtblProduct.getValueAt(i, 4).toString());
                    }
                    this.jlblCantidad.setText("" + cantidad);
                    valForm.cleanTextField(jpnAddProduct);
                    this.jtxtId_Product.requestFocus();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jtxtId_ProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtId_ProductKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.jbtnBuscaArt.doClick();
        }
    }//GEN-LAST:event_jtxtId_ProductKeyPressed

    private void jtxtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.jbtnAgregar.doClick();
        }
    }//GEN-LAST:event_jtxtCantidadKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscaArt;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnRCompra;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JPanel jpnAddProduct;
    private javax.swing.JTable jtblProduct;
    private javax.swing.JTabbedPane jtbpCompra;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtId_Product;
    private javax.swing.JTextField jtxtPrecioCompra;
    private javax.swing.JTextField jtxtPrecioVenta;
    private javax.swing.JTextField jtxtProduct;
    // End of variables declaration//GEN-END:variables

    private boolean getTitleTable() {
        modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Codigo");
        modelo.addColumn("Prodcuto / Descripcion");
        modelo.addColumn("P / Compra");
        modelo.addColumn("P / Venta");
        modelo.addColumn("Cantidad");
        jtblProduct.setModel(modelo);
        return true;
    }
}
