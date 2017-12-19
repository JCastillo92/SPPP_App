/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.beans.LocalTimeDate;
import com.sppp.beans.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author Jairo
 */
public class AlmacenamientoPDF{
    //invocacion a clases que debo usar para obtener los datos
                private Usuario usuario = new Usuario();
    
    
    
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
                
        switch(numero_pdf){
            case 1:
//https://www.mkyong.com/java/itext-read-and-write-pdf-in-java/
                try {
                    PdfReader reader=new PdfReader(new FileInputStream("/home/SPPP_PDF/123/4.pdf"));
                    if(!reader.isEncrypted()){//si el archivo PDF no esta encriptado
                        
                    }else{
                        
                    }
                } catch (Exception e) {
                }
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
            default:
                System.out.println("No se ha encontrado dentro del case el numero para almacenar el .PDF");
                exitoalguardar=false;
                break;
        }//end of SWITCH 
        return exitoalguardar;
    }//fin guardado
    
    
    public boolean guardado_archivo_pdf_creado(long cedula,int numero_pdf){
        boolean exitoalguardar=false;     
        
        switch(numero_pdf){
            case 101:
                 
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);              
                
                //GENERAR OFICIO [ARA LA EMPRESA
                 Document documento = new Document();
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL);  
                 
                 
                 
     try {
            //FileOutputStream archivo = new FileOutputStream("/home/SPPP_PDF/"+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            FileOutputStream archivo = new FileOutputStream("E:\\"+cedula+"\\"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      //logo de la UPS
       Image image = Image.getInstance("C:\\Users\\Jairo\\Documents\\NetBeansProjects\\SPPP_App\\web\\resources\\images\\logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 50);
        documento.add(image);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      Paragraph p1=new Paragraph("OFICIO PARA LA EMPRESA",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      
      documento.add(new Paragraph("Para: "));
      documento.add(salto_linea);
      
       LocalTimeDate obtenerfecha=new LocalTimeDate(); 
      documento.add(new Paragraph("Fecha: "+obtenerfecha.fechaAnioMesDia(),estexto));
      documento.add(salto_linea);
      
      
      documento.add(new Paragraph("La Universidad Politécnica Salesiana solicita de la forma mas comedida que "
              + ""+usuario.getNombre()+" "+usuario.getApellido()+", con cédula número: "+usuario.getEstudiante().getCedula()+", "
                      + " " ,estexto));
      
      documento.add(new Paragraph("xxxxxxxxxx"));
      
      
      
     
      
      documento.close();
      
      
      
      
      exitoalguardar=true;
        } catch (Exception e) {
            exitoalguardar=false;
        }
                
                break;
            case 102:
                
                break;
            case 103:
                
                break;
            default:
                System.out.println("No se ha encontrado dentro del case el numero para crear el .PDF");
                exitoalguardar=false;
                break;
        }//end of SWITCH
        
        
          
        
               
               
               
               
               
               
               
               
               
               
               
        return exitoalguardar;
        
    }
}//end of class
