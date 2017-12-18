/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Jairo
 */
public class AlmacenamientoPDF {
    public boolean create_student_folder_first_time(long cedula){
        //NOTA el path /home/SPPP_PDF/ ya debe estar creado, para que lueg se proceda a crear cada carpeta con la ci
    File dir = new File("/home/SPPP_PDF/"+cedula+"");
    boolean exitoalguardar=false;
    if(!dir.exists()){
        System.out.println("intentando crear nuevo directorio "+dir.getName());
         try{
        dir.mkdir();// attempt to create the directory here
        exitoalguardar=true;
        } 
        catch(SecurityException se){
        exitoalguardar=false;
        }
    }//end if(!dir.exists()){
    
    //comprobacion local
    if(exitoalguardar){System.out.println("directory was created successfully");
        }else{System.out.println("failed trying to create the directory");}
    return exitoalguardar;
    }
    
    public boolean guardado_archivo_pdf_subido(long cedula,int numero_pdf) throws FileNotFoundException, IOException{
        //metodo que permite coger el archivo subido al sistema y almacenarlo en un directorio
        
        
        boolean exitoalguardar=false;
        
        //hago una redundacia de seguridad por si acaso
        create_student_folder_first_time(cedula);
        
        
        
        switch(numero_pdf){
            case 1:
//https://www.mkyong.com/java/itext-read-and-write-pdf-in-java/
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
            case 11:
                
                break;
            case 12:
                
                break;
            case 13:
                
                break;
            case 14:
                
                break;
            default:
                System.out.println("No se ha encontrado dentro del case el numero para almacenar el .PDF");
                exitoalguardar=false;
                break;
        }   
        
        try {
            FileOutputStream archivo = new FileOutputStream("/home/SPPP_PDF/"+cedula+"/"+numero_pdf+".pdf");
             Document documento = new Document();

      PdfWriter.getInstance(documento, archivo);
      documento.open();
      documento.add(new Paragraph("Hola Mundo!"));
      documento.add(new Paragraph("SoloInformaticaYAlgoMas.blogspot.com"));
      documento.close();
      exitoalguardar=true;
        } catch (Exception e) {
            exitoalguardar=false;
        }
     
        return exitoalguardar;
    }//fin guardado
    
    
    public boolean guardado_archivo_pdf_creado(long cedula,int numero_pdf) throws FileNotFoundException{
        boolean exitoalguardar=false;
        
        return exitoalguardar;
        
    }
}//end of class
