/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import AppPackage.AnimationClass;
import java.awt.Image;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Roberto Castro
 */
public class ControlSubThread implements Runnable {

    private Thread worker;
    //private final AtomicBoolean running = new AtomicBoolean(false);
    private volatile boolean running = false;
    private int interval;
    JLabel img1, img2, img3;
    Album album;
    private volatile Photo actual;
    AnimationClass ac = new AnimationClass();

    public ControlSubThread(int sleepInterval, Album _album, JLabel _img1, JLabel _img2, JLabel _img3) {
        interval = sleepInterval;
        img1 = _img1;
        img2 = _img2;
        img3 = _img3;
        album = _album;
        
        cargarAlbum();
    }
    
    public void cargarAlbum(){
        actual = album.Fotos.Primero;
        if(actual != null){
            setImages(0);
            /*do {
                actual = actual.siguiente;
            } while (actual != alb.Fotos.Primero);*/
        }
    }
    
    public void setImages(int _order){
        if(_order == 0){
            ImageIcon imageIcon = new ImageIcon(actual.ruta);
            Image img = imageIcon.getImage();
            ImageIcon scaled = new ImageIcon(img.getScaledInstance(img1.getHeight(), img1.getWidth(), Image.SCALE_SMOOTH));
            img1.setIcon(scaled);

            imageIcon = new ImageIcon(actual.siguiente.ruta);
            img = imageIcon.getImage();
            scaled = new ImageIcon(img.getScaledInstance(img2.getHeight(), img2.getWidth(), Image.SCALE_SMOOTH));
            img2.setIcon(scaled);

            imageIcon = new ImageIcon(actual.anterior.ruta);
            img = imageIcon.getImage();
            scaled = new ImageIcon(img.getScaledInstance(img3.getHeight(), img3.getWidth(), Image.SCALE_SMOOTH));
            img3.setIcon(scaled);
        }
        if(_order == 1){
            ImageIcon imageIcon = new ImageIcon(actual.anterior.ruta);
            Image img = imageIcon.getImage();
            ImageIcon scaled = new ImageIcon(img.getScaledInstance(img1.getHeight(), img1.getWidth(), Image.SCALE_SMOOTH));
            img1.setIcon(scaled);

            imageIcon = new ImageIcon(actual.ruta);
            img = imageIcon.getImage();
            scaled = new ImageIcon(img.getScaledInstance(img2.getHeight(), img2.getWidth(), Image.SCALE_SMOOTH));
            img2.setIcon(scaled);

            imageIcon = new ImageIcon(actual.siguiente.ruta);
            img = imageIcon.getImage();
            scaled = new ImageIcon(img.getScaledInstance(img3.getHeight(), img3.getWidth(), Image.SCALE_SMOOTH));
            img3.setIcon(scaled);
        }
        if(_order == 2){
            ImageIcon imageIcon = new ImageIcon(actual.siguiente.ruta);
            Image img = imageIcon.getImage();
            ImageIcon scaled = new ImageIcon(img.getScaledInstance(img1.getHeight(), img1.getWidth(), Image.SCALE_SMOOTH));
            img1.setIcon(scaled);

            imageIcon = new ImageIcon(actual.anterior.ruta);
            img = imageIcon.getImage();
            scaled = new ImageIcon(img.getScaledInstance(img2.getHeight(), img2.getWidth(), Image.SCALE_SMOOTH));
            img2.setIcon(scaled);

            imageIcon = new ImageIcon(actual.ruta);
            img = imageIcon.getImage();
            scaled = new ImageIcon(img.getScaledInstance(img3.getHeight(), img3.getWidth(), Image.SCALE_SMOOTH));
            img3.setIcon(scaled);
        }
    }
 
    public void start() {
        worker = new Thread(this);
        worker.start();
    }
 
    public void stop() {
        //running.set(false);
        running = false;
        cargarAlbum();
    }
    
    public void pause() {
        //running.set(false);
        running = false;
    }
    
    boolean isRunning() {
        //return running.get();
        return running;
    }

    @Override
    public void run() { 
        System.out.println("Entro");
        int nb=0;
        int delay = 12;
        int increment = 10;
        //running.set(true);
        running = true;
        //while (running.get()) {
        while(running){
            //System.out.println(actual.ruta);
            
            try { 
                
                switch(nb){
                    case 0:
                        Thread.sleep(interval);
                        ac.jLabelXLeft(0, -500, delay, increment, img1);
                        ac.jLabelXLeft(500, 0, delay, increment, img2);
                        ac.jLabelXLeft(-500, 500, delay, increment, img3);                                
                        nb++;
                        break;
                    case 1:
                        Thread.sleep(interval);
                        ac.jLabelXLeft(-500, 500, delay, increment, img1);
                        ac.jLabelXLeft(0, -500, delay, increment, img2);
                        ac.jLabelXLeft(500, 0, delay, increment, img3);
                        nb++;
                        break;
                        //img1.setLocation(500, 0);
                    case 2:

                        Thread.sleep(interval);
                        ac.jLabelXLeft(500, 0, delay, increment, img1);
                        ac.jLabelXLeft(-500, 500, delay, increment, img2);
                        ac.jLabelXLeft(0, -500, delay, increment, img3);
                        nb=0;
                        break;
                }
                //System.out.println(running.get());
                actual = actual.siguiente;
                if(album.Fotos.Ultimo == actual){
                    running = false;
                }
                setImages(nb);
            } catch (InterruptedException e){ 
                Thread.currentThread().interrupt();
                System.out.println(
                  "Thread was interrupted, Failed to complete operation");
            }
            // do something here 
         } 
    } 
}