/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com;
import AppPackage.AnimationClass;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author Roberto Castro
 */
public class Frame extends javax.swing.JFrame {
    
    AnimationClass ac = new AnimationClass();
    Thread myTread;
    ControlSubThread mt;
    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        ListAlbum album = getListAlbum();
        fillAlbumSelect(album);
        scaleImages();
        //sliderShow();
        
        mt = new ControlSubThread(3000,album.Albumes.get(0),img1,img2,img3);
        mt.start();
    }
    
    public ListAlbum getListAlbum(){
        FileDataXML file = new FileDataXML();
        return file.loadFile();
    }
    
    public void fillAlbumSelect(ListAlbum dataAlbum){
        for(Album alb: dataAlbum.Albumes){
            album.addItem(alb.Nombre);
        }
        
    }
    
    public void sliderShow(){
        myTread = new Thread(new Runnable() {
            @Override
            public void run() {
                int nb=0;
                try{
                    /*while(true){
                        switch(nb){
                            case 0:
                                Thread.sleep(3000);
                                ac.jLabelXLeft(0, -500, 12, 10, img1);
                                ac.jLabelXLeft(500, 0, 12, 10, img2);
                                ac.jLabelXLeft(1000, 500, 12, 10, img3);
                                nb++;
                            case 1:
                                Thread.sleep(3000);
                                ac.jLabelXLeft(-500, -1000, 12, 10, img1);
                                ac.jLabelXLeft(0, -500, 12, 10, img2);
                                ac.jLabelXLeft(500, 0, 12, 10, img3);
                                nb++;
                            case 2:
                                Thread.sleep(3000);
                                ac.jLabelXRight(-1000, -500, 12, 10, img1);
                                ac.jLabelXRight(-500, 0, 12, 10, img2);
                                ac.jLabelXRight(0, 500, 12, 10, img3);
                                nb++;
                            case 3:
                                Thread.sleep(3000);
                                ac.jLabelXRight(-500, 0, 12, 10, img1);
                                ac.jLabelXRight(0, 500, 12, 10, img2);
                                ac.jLabelXRight(500, 1000, 12, 10, img3);
                                nb=0;
                        }
                    }*/
                    int delay = 12;
                    int increment = 10;
                    int sleep = 500;
                    while(true){
                        switch(nb){
                            case 0:
                                Thread.sleep(sleep);
                                ac.jLabelXLeft(0, -500, delay, increment, img1);
                                ac.jLabelXLeft(500, 0, delay, increment, img2);
                                ac.jLabelXLeft(-500, 500, delay, increment, img3);                                
                                nb++;
                            case 1:
                                Thread.sleep(sleep);
                                ac.jLabelXLeft(-500, 500, delay, increment, img1);
                                ac.jLabelXLeft(0, -500, delay, increment, img2);
                                ac.jLabelXLeft(500, 0, delay, increment, img3);
                                nb++;
                                //img1.setLocation(500, 0);
                            case 2:
                                
                                Thread.sleep(sleep);
                                ac.jLabelXLeft(500, 0, delay, increment, img1);
                                ac.jLabelXLeft(-500, 500, delay, increment, img2);
                                ac.jLabelXLeft(0, -500, delay, increment, img3);
                                nb=0;
                            /*case 3:
                                Thread.sleep(3000);
                                ac.jLabelXRight(-500, 0, 12, 10, img1);
                                ac.jLabelXRight(0, 500, 12, 10, img2);
                                ac.jLabelXRight(500, 1000, 12, 10, img3);
                                nb=0;*/
                        }
                    }
                }catch(Exception ex) {
                }
            }
        });

        myTread.start();
    }
    
    public void scaleImages(){
        Image img = ((ImageIcon)img1.getIcon()).getImage();
        ImageIcon scaled = new ImageIcon(img.getScaledInstance(img1.getHeight(), img1.getWidth(), Image.SCALE_SMOOTH));
        img1.setIcon(scaled);
        
        img = ((ImageIcon)img2.getIcon()).getImage();
        scaled = new ImageIcon(img.getScaledInstance(img2.getHeight(), img2.getWidth(), Image.SCALE_SMOOTH));
        img2.setIcon(scaled);
        
        img = ((ImageIcon)img3.getIcon()).getImage();
        scaled = new ImageIcon(img.getScaledInstance(img3.getHeight(), img3.getWidth(), Image.SCALE_SMOOTH));
        img3.setIcon(scaled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        album = new javax.swing.JComboBox<>();
        right = new javax.swing.JPanel();
        stop = new javax.swing.JButton();
        start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left.setBackground(new java.awt.Color(255, 255, 255));
        left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Algun texto aqui");
        left.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IMG_20210501_182020.jpg"))); // NOI18N
        left.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 500));

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IMG_20210504_065007.jpg"))); // NOI18N
        left.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 500, 500));

        img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IMG_20210504_090647.jpg"))); // NOI18N
        left.add(img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 50, 500, 500));

        jLabel1.setText("Album de Fotos");
        jLabel1.setToolTipText("");
        left.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 14, -1, -1));

        left.add(album, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 200, -1));

        container.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        right.setBackground(new java.awt.Color(255, 255, 255));
        right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stop.setText("Stop");
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        right.add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        start.setText("Start");
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });
        right.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        container.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 200, 500));

        getContentPane().add(container, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        System.out.println("Hola mundo");
        mt.stop();
    }//GEN-LAST:event_stopMouseClicked

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
        mt.start();
    }//GEN-LAST:event_startMouseClicked

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> album;
    private javax.swing.JPanel container;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel left;
    private javax.swing.JPanel right;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
