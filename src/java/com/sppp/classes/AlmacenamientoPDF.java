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
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.beans.Encargado;
import com.sppp.beans.LocalTimeDate;
import com.sppp.beans.Pasantia;
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
    //variables globales
    private String local_path="/home/SPPP_PDF/";
    
    //invocacion a clases que debo usar para obtener los datos
                private Usuario usuario = new Usuario();
                private Pasantia pasantia=new Pasantia();
                private Encargado encargado=new Encargado();
    
    
    
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
                    PdfReader reader=new PdfReader(new FileInputStream(local_path+""));
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
          //LLAMADO A informacion NECESERAIA PARA INGRESAR AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            
                   //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
        switch(numero_pdf){
            case 101:
                //FORMATO OFICIO PARA LA EMPRESA
     try {
            //FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
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
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
      Paragraph p1=new Paragraph("OFICIO PARA LA EMPRESA",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      //F E C H A  DEL  S I S T E M A  
      LocalTimeDate obtenerfecha=new LocalTimeDate(); 
      documento.add(new Paragraph("Fecha: Quito, "+obtenerfecha.fechaAnioMesDia(),estexto));
      documento.add(salto_linea);
      
      //D I R I G I D O
      documento.add(new Paragraph("Para: ",estexto));
      documento.add(salto_linea);
      
      // C U  E R  P O   DE  D O C U M E N T O 
      Paragraph cuerpo=new Paragraph("La Universidad Politécnica Salesiana solicita de la forma mas comedida que "
              + ""+usuario.getNombre()+" "+usuario.getApellido()+", con cédula de ciudadanía: "+usuario.getEstudiante().getCedula()+", "
                      + " se le otorgue la oprtuninda de realizar la "+giveMeNamePPP(pasantia.getTipo_ppp())+" dentro de sus "
                              + "instalaciones.",estexto);
      cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
      documento.add(cuerpo);
      
      //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
      documento.add(salto_linea);
      documento.add(salto_linea);
      ListaDocentesAdministrativos buscar_docadmin=new ListaDocentesAdministrativos();
      documento.add(new Paragraph("Atentamente: "+buscar_docadmin.nombreDocenteAdministrativo(1),estexto));
      
      //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
      documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito ",estexto));
      
      //FIRMA linea de firma
      documento.add(salto_linea);
      documento.add(salto_linea);      
      documento.add(linea_firma);
      
      
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (Exception e) {
            exitoalguardar=false;
        }
                break;
            case 102:
                //FORMATO CARTA DE ACEPTACION
     try {
            //FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            FileOutputStream archivo = new FileOutputStream("E:\\"+cedula+"\\"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
 
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
        //F E C H A  DEL  S I S T E M A  
      LocalTimeDate obtenerfecha=new LocalTimeDate(); 
      Paragraph poner_fecha=new Paragraph("Fecha: Quito, "+obtenerfecha.fechaAnioMesDia(),estexto);
      poner_fecha.setAlignment(Element.ALIGN_RIGHT);
      documento.add(poner_fecha);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
        // T I T U L O
      Paragraph p1=new Paragraph("CARTA DE ACEPTACIÓN",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
            //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
      documento.add(salto_linea);
      documento.add(salto_linea);
      ListaDocentesAdministrativos buscar_docadmin=new ListaDocentesAdministrativos();
      documento.add(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(1)+"\n Presente.-",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(new Paragraph("De mis consideraciones:",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
      documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito ",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // C U  E R  P O   DE  D O C U M E N T O 
      Paragraph cuerpo=new Paragraph("Por medio de la presente comunicamos a usted, la aceptación del estudiante "
              + ""+usuario.getNombre()+" "+usuario.getApellido()+", con cédula de ciudadanía: "+usuario.getEstudiante().getCedula()+", "
                      + " para la ejecución de "+giveMeNamePPP(pasantia.getTipo_ppp())+", del "+pasantia.getFechaInicio()+" al "+pasantia.getFechaFin()+".",estexto);
      cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
      documento.add(cuerpo);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      
      //RESPONSABLE / ENCARGADO DE LA EMPRESA
      documento.add(linea_firma);
      documento.add(new Paragraph("Atentamente, ",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      //documento.add(new Paragraph("ID encargado: "+encargado.getId_encargado(),estexto));
      documento.add(new Paragraph("Persona a cargo: "+encargado.getNombre_encargado(),estexto));//Nombre Responsableen la empresa 
      documento.add(new Paragraph("Identificación: "+encargado.getCi_encargado(),estexto));//CEDULA  Nombre Responsable en la empresa NO es el ID
      documento.add(new Paragraph("Cargo/Profesión: "+encargado.getCargo_encargado(),estexto));//Cargo dentro de la empresa 
      documento.add(new Paragraph("RUC: "+encargado.getEmpresa().getId_empresa(),estexto));//RUC empresa donde trabaja encargado
      
      //SELLO DE LA EMPRESA
      documento.add(new Paragraph("Se requiere el sello de la empresa. ",esnota));
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (Exception e) {
            exitoalguardar=false;
        }
                break;
            case 103:
                //CARTA COMPROMISO
                
                break;
            case 104:
                //FORMATO DE INICIAR PASANTIAS EN LA EMPRESA / FORMATO SOLICITUD RESOLUCION
                
                break;
            default:
                System.out.println("No se ha encontrado dentro del case el numero para crear el .PDF");
                exitoalguardar=false;
                break;
        }//end of SWITCH
        return exitoalguardar;
    }//fin metodo
    
    
    private String giveMeNamePPP(String nameppp){
        if(nameppp.equals("pa")){
            nameppp="pasantía";
        }
        if(nameppp.equals("pp")){
            nameppp="práctica pre profesional";
        }
        return nameppp;
    }
}//end of class
