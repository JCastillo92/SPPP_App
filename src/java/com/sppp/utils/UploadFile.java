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
import javax.servlet.http.HttpSession;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
public class UploadFile {
     private String //local_path="/home/SPPP_PDF/";
                    local_path="E:/home/SPPP_PDF/";
                    //local_path="D:/home/SPPP_PDF/";  
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
            
            
        //LO SIGUIENTE ME PERMITE SABER LA CEDULA DEL ALUMNO, CON ESO PUEDO SABER A QUE CARPETA MANDAR EL .PDF SUBIDO
                 HttpSession session = SessionUtils.getSession();
        long id;
            try {
            id = (long) session.getAttribute("id");
        } catch (Exception e) {
            id = 0;
            System.out.println("========== ERROR AL TRAER INFO  S E S S I O N  DE USUARIO ==============0");
        }
        
            switch(opcion){
                case 1:
                    //1 SCAN OFICIO PARA LA EMPRESA .PDF
                    Files.copy(input, new File(local_path+id, "1" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;

                case 2:
                    //2 SCAN CARTA DE ACEPTACION .PDF
                    Files.copy(input, new File(local_path+id, "2" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
            }

            System.out.println(new File("/").getAbsolutePath());
            
            
        } catch (IOException ex) {
            System.out.println("Error Al Cargar: "+ex.getMessage());
        }
        //return "subida";
        
    }
    
    
    
    
}
