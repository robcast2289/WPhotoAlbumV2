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
    private volatile boolean looping = false;
    private int interval;
    JLabel img1, img2, img3;
    Album album;
    int nb = 0;
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
            setImg(img1,actual.ruta);
            setImg(img2,actual.siguiente.ruta);
            setImg(img3,actual.anterior.ruta);            
        }
        if(_order == 1){
            setImg(img1,actual.anterior.ruta);  
            setImg(img2,actual.ruta);
            setImg(img3,actual.siguiente.ruta);                        
        }
        if(_order == 2){
            setImg(img1,actual.siguiente.ruta);
            setImg(img2,actual.anterior.ruta);  
            setImg(img3,actual.ruta);            
        }
    }
    
    private void setImg(JLabel _img, String _ruta){
        ImageIcon imageIcon = new ImageIcon(_ruta);
        Image img = imageIcon.getImage();
        ImageIcon scaled = new ImageIcon(img.getScaledInstance(_img.getHeight(), _img.getWidth(), Image.SCALE_SMOOTH));
        _img.setIcon(scaled);
    }
    
    public void resetPositionImg(){
        img1.setLocation(0, 50);
        img2.setLocation(500, 50);
        img3.setLocation(-500, 50);
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
    
    public void loop(boolean _looping) {
        //running.set(false);
        looping = _looping;
    }
    
    boolean isRunning() {
        //return running.get();
        return running;
    }

    @Override
    public void run() { 
        System.out.println("Entro");
        nb=0;
        
        //running.set(true);
        running = true;
        //while (running.get()) {
        while(running){
            //System.out.println(actual.ruta);
            
            try { 
                
                //moveNext();
                movePrev();
                Thread.sleep(interval);
                //System.out.println(running.get());
                
                if(album.Fotos.Ultimo == actual && !looping){
                    Thread.sleep(interval);
                    running = false;
                    resetPositionImg();
                }
                
            } catch (InterruptedException e){ 
                Thread.currentThread().interrupt();
                System.out.println(
                  "Thread was interrupted, Failed to complete operation");
            }
            // do something here 
         } 
    } 
    
    public void moveNext() {
        int delay = 12;
        int increment = 10;
        switch(nb){
            case 0:                        
                ac.jLabelXLeft(0, -500, delay, increment, img1);
                ac.jLabelXLeft(500, 0, delay, increment, img2);
                ac.jLabelXLeft(-500, 500, delay, increment, img3);                   
                nb++;
                break;
            case 1:                        
                ac.jLabelXLeft(-500, 500, delay, increment, img1);
                ac.jLabelXLeft(0, -500, delay, increment, img2);
                ac.jLabelXLeft(500, 0, delay, increment, img3);
                nb++;
                break;
                //img1.setLocation(500, 0);
            case 2:
                ac.jLabelXLeft(500, 0, delay, increment, img1);
                ac.jLabelXLeft(-500, 500, delay, increment, img2);
                ac.jLabelXLeft(0, -500, delay, increment, img3);
                nb=0;
                break;
        }
        actual = actual.siguiente;
        setImages(nb);
    }
    
    public void movePrev() {
        int delay = 1;
        int increment = 1;
        switch(nb){
            case 0:                        
                //ac.jLabelXRight(0, 500, delay, increment, img1);
                //ac.jLabelXRight(500, -500, delay, increment, img2);
                //ac.jLabelXRight(-500, 0, delay, increment, img3);   
                img1.setLocation(500, 50);
                img2.setLocation(-500, 50);
                img3.setLocation(0, 50);
                nb=2;
                break;
            case 1:                        
                //ac.jLabelXRight(-500, 0, delay, increment, img1);
                //ac.jLabelXRight(0, 500, delay, increment, img2);
                //ac.jLabelXRight(500, -500, delay, increment, img3);
                img1.setLocation(0, 50);
                img2.setLocation(500, 50);
                img3.setLocation(-500, 50);
                nb--;
                break;
                //img1.setLocation(500, 0);
            case 2:
                ac.jLabelXRight(500, -500, delay, increment, img1);
                ac.jLabelXRight(-500, 0, delay, increment, img2);
                ac.jLabelXRight(0, 500, delay, increment, img3);
                //img1.setLocation(-500, 50);
                //img2.setLocation(0, 50);
                //img3.setLocation(500, 50);
                nb--;
                break;
        }
        actual = actual.anterior;
        setImages(nb);
    }
}