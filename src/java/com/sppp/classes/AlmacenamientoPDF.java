/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import java.io.File;

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
    
    
}//end of class
