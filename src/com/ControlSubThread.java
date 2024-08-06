/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import AppPackage.AnimationClass;
import java.awt.Image;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    JLabel img1;
    JButton start;
    Album album;
    private volatile Photo actual;

    public ControlSubThread(int sleepInterval, Album _album, JLabel _img1,JButton _start) {
        interval = sleepInterval;
        img1 = _img1;
        start = _start;
        album = _album;
        
        cargarAlbum();
    }
    
    public void cargarAlbum(){
        actual = album.Fotos.Primero;
        if(actual != null){
            setImages();
        }
    }
    
    public void setImages(){
        setImg(img1,actual.ruta);
    }
    
    private void setImg(JLabel _img, String _ruta){
        ImageIcon imageIcon = new ImageIcon(_ruta);
        Image img = imageIcon.getImage();
        ImageIcon scaled = new ImageIcon(img.getScaledInstance(_img.getHeight(), _img.getWidth(), Image.SCALE_SMOOTH));
        _img.setIcon(scaled);
    }    
 
    public void start() {
        worker = new Thread(this);            
        worker.start();
        start.setIcon(new ImageIcon(getClass().getResource("/img/Pause.png")));
    }
 
    public void stop() {
        //running.set(false);
        pause();
        cargarAlbum();
    }
    
    public void pause() {
        //running.set(false);
        running = false;
        start.setIcon(new ImageIcon(getClass().getResource("/img/Play.png")));
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
        //running.set(true);
        running = true;
        //while (running.get()) {
        while(running){
            try { 
                moveNext();
                Thread.sleep(interval);

                if(album.Fotos.Ultimo == actual && !looping){
                    stop();
                }                
            } catch (InterruptedException e){ 
                Thread.currentThread().interrupt();
                System.out.println(
                  "Thread was interrupted, Failed to complete operation");
            }
         } 
    } 
    
    public void moveNext() {  
        if(album.Fotos.Ultimo != actual || looping){
            actual = actual.siguiente;
        }        
        setImages();
    }
    
    public void movePrev() {    
        if(album.Fotos.Primero != actual || looping){
            actual = actual.anterior;
        }
        setImages();
    }
    
    public void moveLast() {  
        actual = album.Fotos.Ultimo;        
        setImages();
    }
    
    public void moveFirst() {    
        actual = album.Fotos.Primero;
        setImages();
    }
}