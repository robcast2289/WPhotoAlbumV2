/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roberto
 */
public class AdminAlbum extends javax.swing.JFrame {

    JLabel midato;
    ListAlbum lstAlbumFrm2;
    ListAlbum lstOrig;
    Album albSelected;
    int intAlbSelected;
    DefaultTableModel dtm;
    Object[] obj;
    DefaultTableModel dtmDetalle;
    Object[] objDetalle;
    boolean formClosed = false;
    /**
     * Creates new form AdminAlbum
     */
    public AdminAlbum() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void setDatos(ListAlbum _dato){
        formClosed = true;
        lstOrig = _dato;
        clearAlbum();
        clearDetail();
        lstAlbumFrm2 = new ListAlbum();
        for(Album _al: _dato.Albumes){
            lstAlbumFrm2.Albumes.add(_al);
        }
        //lstAlbumFrm2.Albumes = _dato.Albumes;
        
        obj = new Object[1];
        dtm = (DefaultTableModel)tblAlbum.getModel();
        for(Album alb: lstAlbumFrm2.Albumes){
            obj[0] = alb.Nombre;
            dtm.addRow(obj);
        }
        
        objDetalle = new Object[1];
        dtmDetalle = (DefaultTableModel)tblFotos.getModel();
        //tblAlbum.set
    }
    
    private Album getSelectedAlbum(String _album){
        Album find = lstAlbumFrm2.Albumes.stream()
                .filter(album -> _album.equals(album.Nombre))
                .findAny()
                .orElse(null);
        return find;
    }
    
    private void clearAlbum(){
        int cantidad = tblAlbum.getRowCount();
        for(int x=0;x<cantidad;x++){
            dtm.removeRow(0);
        }
    }
    
    private void clearDetail(){
        int cantidad = tblFotos.getRowCount();
        for(int x=0;x<cantidad;x++){
            dtmDetalle.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlbum = new javax.swing.JTable();
        addAlbum = new javax.swing.JButton();
        removeAlbum = new javax.swing.JButton();
        txtAlbum = new javax.swing.JTextField();
        lblAlbum = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFotos = new javax.swing.JTable();
        removeFoto = new javax.swing.JButton();
        choosePicture = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Album"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlbumMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlbum);

        addAlbum.setText("Agregar album");
        addAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlbumActionPerformed(evt);
            }
        });

        removeAlbum.setText("Eliminar album");
        removeAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAlbumActionPerformed(evt);
            }
        });

        lblAlbum.setText("Album");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAlbum)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlbum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAlbum)
                    .addComponent(removeAlbum))
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 420));

        tblFotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ubicacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblFotos);

        removeFoto.setText("ELIMINAR TODO");
        removeFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFotoActionPerformed(evt);
            }
        });

        choosePicture.setText("Argregar foto(s)");
        choosePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePictureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(choosePicture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(removeFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeFoto)
                    .addComponent(choosePicture))
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 360, 420));

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        btnSave1.setText("Guardar");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, -1, -1));

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //this.setVisible(false);
        formClosed = false;
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void addAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlbumActionPerformed
        String valor = txtAlbum.getText();
        if(valor.equals("") || valor.equals(null))
        {
            JOptionPane.showMessageDialog(null,"Debe especificar un nombre de Album","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(getSelectedAlbum(txtAlbum.getText()) != null){
            JOptionPane.showMessageDialog(null,"El nombre de album ya existe","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        obj[0] = txtAlbum.getText();
        dtm.addRow(obj);
        
        Album alb = new Album();
        alb.Nombre = txtAlbum.getText();
        alb.Fotos = new ListPhoto();
        lstAlbumFrm2.Albumes.add(alb);
    }//GEN-LAST:event_addAlbumActionPerformed

    private void tblAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlbumMouseClicked
        intAlbSelected = tblAlbum.rowAtPoint(evt.getPoint());
        albSelected = getSelectedAlbum(String.valueOf(tblAlbum.getValueAt(intAlbSelected, 0)));
        if(albSelected != null){
            clearDetail();
            System.out.println(albSelected.Nombre);
            Photo actual;
            actual = albSelected.Fotos.Primero;
            if(actual != null){
                do {
                    objDetalle[0] = actual.ruta;
                    dtmDetalle.addRow(objDetalle);
                    actual = actual.siguiente;
                } while (actual != albSelected.Fotos.Primero);
            }
        }
    }//GEN-LAST:event_tblAlbumMouseClicked

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        new FileDataXML().saveFile(lstAlbumFrm2);
        dispose();
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void choosePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePictureActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes PNG & JPG ","png","jpg");
        fc.setFileFilter(filter);
        int selection = fc.showOpenDialog(this);
        
        if(selection == JFileChooser.APPROVE_OPTION)
        {
            if(albSelected == null){
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Album","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            File[] archivos = fc.getSelectedFiles();
            for(File fileChoose: archivos){
                objDetalle[0] = fileChoose.getAbsolutePath();
                dtmDetalle.addRow(objDetalle);
                albSelected.Fotos.addPhoto(fileChoose.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_choosePictureActionPerformed

    private void removeAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAlbumActionPerformed
        if(albSelected != null){
            dtm.removeRow(intAlbSelected);
            lstAlbumFrm2.Albumes.remove(albSelected);
            albSelected = null;
            clearDetail();
        }
    }//GEN-LAST:event_removeAlbumActionPerformed

    private void removeFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFotoActionPerformed
        clearDetail();
        albSelected.Fotos = new ListPhoto();
    }//GEN-LAST:event_removeFotoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAlbum;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton choosePicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JButton removeAlbum;
    private javax.swing.JButton removeFoto;
    private javax.swing.JTable tblAlbum;
    private javax.swing.JTable tblFotos;
    private javax.swing.JTextField txtAlbum;
    // End of variables declaration//GEN-END:variables
}
