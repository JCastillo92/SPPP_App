/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
public class UploadFile {
    
    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    //ESTE METODO NOS REGRESA EL NOMBRE DEL ARCHIVO CON EXTENSION
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    
    //METODO PARA GUARDAR EL ARCHIVO
    public void guardar(int opcion){
        String nombre;
        String nombreSinExt, extension;
        int punto;
        
        try {
            InputStream input = file.getInputStream();
            nombre = getFilename(file);
            
            //CODIGO PARA OBTENER LA EXTENSION DEL ARCHIVO
            punto = nombre.indexOf(".");
            nombreSinExt = nombre.substring(0, punto);
            extension = nombre.substring(punto,nombre.length());
            System.out.println(nombreSinExt+" "+extension);
            
            //SI NECESITAS MAS DOCUMENTOS, AUMENTA LOS CASOS AQUI Y TAMBIEN EN EL XHTML
            switch(opcion){
                case 1:
                    //PATH DONDE SE VA A GUARDAR EL ARCHIVO
                    //PARA CAMBIAR EL NOMBRE DEL ARCHIVO MODIFICAR DONDE DICE "documento1"
                    Files.copy(input, new File("C:\\Users\\EstJhonAlexanderCast\\Documents\\Programacion\\NetBeanSpaces\\EjerciciosJSFs\\JsfImagen", "documento1" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);

                    break;

                case 2:
                    Files.copy(input, new File("C:\\Users\\EstJhonAlexanderCast\\Documents\\Programacion\\NetBeanSpaces\\EjerciciosJSFs\\JsfImagen", "documento2" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
            }

            System.out.println(new File("/").getAbsolutePath());
            
            
        } catch (IOException ex) {
            System.out.println("Error Al Cargar: "+ex.getMessage());
        }
        //return "subida";
        
    }
    
    
    
    
}
