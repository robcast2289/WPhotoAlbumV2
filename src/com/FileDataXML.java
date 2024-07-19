/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
/**
 *
 * @author Roberto Castro
 */
public class FileDataXML {
    
    public static void main(String[] args) {
        /*try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            //Document midocumento = builder.newDocument();
            //Element elementoRaiz = midocumento.createElement("albumes");
            //midocumento.appendChild(elementoRaiz);
            Document documento = implementation.createDocument(null, "albumes", null);
            documento.setXmlVersion("1.0");
            Element album = documento.createElement("album");
            Element nombre = documento.createElement("nombre");
            Text textNombre = documento.createTextNode("Mi primera lista");
            Element fotos = documento.createElement("fotos");
            nombre.appendChild(textNombre);
            album.appendChild(nombre);
            album.appendChild(fotos);
            
            documento.getDocumentElement().appendChild(album);
            
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("albumes.xml"));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(FileDataXML.class.getName()).log(Level.SEVERE, null, ex);
        }   */
        
        FileDataXML miarchivo = new FileDataXML();
        
        ListAlbum listado = new ListAlbum();
        listado = miarchivo.loadFile();
        
        for(Album alb: listado.Albumes){
            System.out.println(alb.Nombre);
            Photo actual = alb.Fotos.Primero;
            if(actual != null){
                do {
                    System.out.println(actual.ruta);
                    actual = actual.siguiente;
                } while (actual != alb.Fotos.Primero);
            }
        }
        
        /*ListPhoto fotos = new ListPhoto();
        fotos.addPhoto("foto1.jpg");
        fotos.addPhoto("foto2.jpg");
        fotos.addPhoto("foto3.jpg");
        fotos.addPhoto("foto4.jpg");
        Album mialbum = new Album();
        mialbum.Nombre = "Album 1";
        mialbum.Fotos = fotos;
        ListAlbum listado = new ListAlbum();
        listado.addAlbum(mialbum);
        
        fotos = new ListPhoto();
        fotos.addPhoto("galeria1.jpg");
        fotos.addPhoto("galeria2.jpg");
        fotos.addPhoto("galeria3.jpg");
        fotos.addPhoto("galeria4.jpg");
        mialbum = new Album();
        mialbum.Nombre = "Galeria 2";
        mialbum.Fotos = fotos;
        
        listado.addAlbum(mialbum);
        
        miarchivo.saveFile(listado);*/
        
    }
    
    String fileName = "albumes.xml";
    

    public FileDataXML(){
        File af = new File(fileName);
        
        if(!af.exists() || !af.isFile()){
            createFileBlank();
        }
    }
    
    public ListAlbum loadFile(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File(fileName));
            
            ListAlbum listado = new ListAlbum();
            
            NodeList albumes = documento.getElementsByTagName("album");
            
            for (int i = 0; i < albumes.getLength(); i++) {
                Album mialbum = new Album();
                Node nodo = albumes.item(i);
                if(nodo.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList nodeAlbum = ((Element)nodo).getChildNodes();
                    for (int j = 0; j < nodeAlbum.getLength(); j++) {
                        if(nodeAlbum.item(j).getNodeName() == "nombre"){
                            mialbum.Nombre = nodeAlbum.item(j).getTextContent();
                        }
                        if(nodeAlbum.item(j).getNodeName() == "fotos"){
                            ListPhoto fotos = new ListPhoto();
                            NodeList nodeFotos = nodeAlbum.item(j).getChildNodes();
                            for (int k = 0; k < nodeFotos.getLength(); k++) {
                                if(nodeFotos.item(k).getNodeName() == "ruta"){
                                    fotos.addPhoto(nodeFotos.item(k).getTextContent());
                                }
                            }
                            mialbum.Fotos = fotos;
                        }                        
                    }
                }
                listado.addAlbum(mialbum);
            }
            
            
            return listado;
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(FileDataXML.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
    private Document createFileBlank(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            //Document midocumento = builder.newDocument();
            //Element elementoRaiz = midocumento.createElement("albumes");
            //midocumento.appendChild(elementoRaiz);
            Document documento = implementation.createDocument(null, "albumes", null);
            documento.setXmlVersion("1.0");
            
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File(fileName));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            return documento;
            
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(FileDataXML.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
    
    public Document saveFile(ListAlbum _listAlbum){
        File af = new File(fileName);
        af.delete();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "albumes", null);
            documento.setXmlVersion("1.0");
            
            for(Album alb: _listAlbum.Albumes){
                Element album = documento.createElement("album");
                Element nombre = documento.createElement("nombre");
                Text textNombre = documento.createTextNode(alb.Nombre);
                nombre.appendChild(textNombre);
                album.appendChild(nombre);
                
                Element fotos = documento.createElement("fotos");
                
                Photo actual = alb.Fotos.Primero;
                if(actual != null){
                    do {
                        Element ruta = documento.createElement("ruta");
                        Text textRuta = documento.createTextNode(actual.ruta);
                        ruta.appendChild(textRuta);
                        fotos.appendChild(ruta);
                        actual = actual.siguiente;
                    } while (actual != alb.Fotos.Primero);
                }                
                album.appendChild(fotos);
                documento.getDocumentElement().appendChild(album);
            }
            
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File(fileName));
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            return documento;
            
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(FileDataXML.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
}
