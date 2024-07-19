/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto Castro
 */
public class ListAlbum {
    List<Album> Albumes;
    
    public ListAlbum(){
        Albumes = new ArrayList<>();
    }
    
    public void addAlbum(Album _album){
        Albumes.add(_album);
    }
}
