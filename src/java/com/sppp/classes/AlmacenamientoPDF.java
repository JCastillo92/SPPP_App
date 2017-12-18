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
    
    public boolean guardado_archivo_pdf() throws FileNotFoundException{
        boolean exitoalguardar=false;
        FileOutputStream archivo = new FileOutputStream("E:\\hola.pdf");
        try {
             Document documento = new Document();

      PdfWriter.getInstance(documento, archivo);

      documento.open();

      documento.add(new Paragraph("Hola Mundo!"));

      documento.add(new Paragraph("SoloInformaticaYAlgoMas.blogspot.com"));

      documento.close();
        } catch (Exception e) {
        }
     
        return exitoalguardar;
    }//fin guardado
}//end of class
