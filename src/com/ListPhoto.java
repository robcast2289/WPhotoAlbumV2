/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author Roberto Castro
 */
public class ListPhoto {
    Photo Primero;
    Photo Ultimo;
    
    public ListPhoto(){
        Primero = null;
        Ultimo = null;
    }
    
    public void addPhoto(String _ruta){
        Photo Nuevo = new Photo();
        Nuevo.ruta = _ruta;
        
        if(Primero == null){
            Primero = Nuevo;
            Ultimo = Nuevo;
            Primero.siguiente = Primero;
            Ultimo.anterior = Ultimo;
        } else {
            Ultimo.siguiente = Nuevo;
            Nuevo.siguiente = Primero;
            Nuevo.anterior = Ultimo;
            Ultimo = Nuevo;
            Primero.anterior = Ultimo;
        }
    }
}
