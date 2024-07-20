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
    ListAlbum lstAlbum;
    int sleepInterval = 2000;
    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        lstAlbum = getListAlbum();
        fillAlbumSelect(lstAlbum);
        scaleImages();
        //sliderShow();
        
        mt = new ControlSubThread(sleepInterval,lstAlbum.Albumes.get(0),img1,img2,img3);
        //mt.start();
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
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        album = new javax.swing.JComboBox<>();
        right = new javax.swing.JPanel();
        stop = new javax.swing.JButton();
        start = new javax.swing.JButton();
        loop = new javax.swing.JToggleButton();
        back = new javax.swing.JToggleButton();
        next = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left.setBackground(new java.awt.Color(255, 255, 255));
        left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        left.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 500));
        left.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 500, 500));
        left.add(img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 50, 500, 500));

        jLabel1.setText("Album de Fotos");
        jLabel1.setToolTipText("");
        left.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 14, -1, -1));

        album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumActionPerformed(evt);
            }
        });
        left.add(album, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 200, -1));

        container.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        right.setBackground(new java.awt.Color(255, 255, 255));
        right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Stop.png"))); // NOI18N
        stop.setBorder(null);
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        right.add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 50, 50));

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Play.png"))); // NOI18N
        start.setBorder(null);
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMouseClicked(evt);
            }
        });
        right.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 50, 50));

        loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Next.png"))); // NOI18N
        loop.setBorder(null);
        loop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loopActionPerformed(evt);
            }
        });
        right.add(loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 50, 50));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Loop.png"))); // NOI18N
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        right.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 50, 50));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Prev.png"))); // NOI18N
        next.setBorder(null);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        right.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 50, 50));

        container.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 200, 500));

        getContentPane().add(container, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        mt.stop();
        start.setIcon(new ImageIcon(getClass().getResource("/img/Play.png")));
    }//GEN-LAST:event_stopMouseClicked

    private void startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseClicked
        if(mt.isRunning()){
            mt.pause();
            //start.setText("Start");
            start.setIcon(new ImageIcon(getClass().getResource("/img/Play.png")));
        } else {
            mt.start();
            //start.setText("Pause");
            start.setIcon(new ImageIcon(getClass().getResource("/img/Pause.png")));
        }
        
    }//GEN-LAST:event_startMouseClicked

    private void albumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumActionPerformed
        // TODO add your handling code here:        
        if(mt != null)
            mt.stop();
        for(Album alb: lstAlbum.Albumes){
            if(alb.Nombre == album.getSelectedItem()){
                mt = new ControlSubThread(sleepInterval,alb,img1,img2,img3);
            }
        }
    }//GEN-LAST:event_albumActionPerformed

    private void loopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loopActionPerformed
        if(loop.isSelected()){
            loop.setIcon(new ImageIcon(getClass().getResource("/img/LoopActive.png")));
        } else {
            loop.setIcon(new ImageIcon(getClass().getResource("/img/Loop.png")));
        }
    }//GEN-LAST:event_loopActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextActionPerformed

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
    private javax.swing.JToggleButton back;
    private javax.swing.JPanel container;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel left;
    private javax.swing.JToggleButton loop;
    private javax.swing.JToggleButton next;
    private javax.swing.JPanel right;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
