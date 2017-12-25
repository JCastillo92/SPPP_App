/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import com.sppp.classes.AlmacenamientoPDF;
import com.sppp.classes.ListaDocentesAdministrativos;
import com.sppp.classes.Paths;
import com.sppp.mailing.MailingMain;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.http.HttpSession;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    
    
    
    
    //METODO PARA GUARDAR ARCHIVOS SCANEADOS
    public void save_file(int opcion){
         Paths directorio = new Paths();
        String local_path = directorio.local_path();
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
                case 3:
                    //3 SCAN CARTA COMPROMICO
                    Files.copy(input, new File(local_path+id, "3" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                 case 4:
                    //4 SCAN INICIO PASANTIA / FORMATO RESOLUCION
                    Files.copy(input, new File(local_path+id, "4" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                 case 5:
                    //5
                    
                    break;
                default:
                    System.out.println("No se ha encontrado la orden para subir el archivo scaneado");
                    break;
            }
//aqui envio el email al docente encargado para que revise que han subido scan de docs en  oficio y carta aceptacion.
        MailingMain primer_mensaje=new MailingMain();
        ListaDocentesAdministrativos corrreo_De=new ListaDocentesAdministrativos();
        primer_mensaje.mensajes(1002,corrreo_De.corrreoDocenteAdministrativo(6),"vacio");
        
            System.out.println(new File("/").getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error Al Cargar: "+ex.getMessage());
        }
        //return "subida";
        
    }
    
    
    
    
    
    //METODO PARA GUARDAR/DESCARGAR ARCHIVOS CREADOR
        public void download_file(int opcion) {///aqui recibir nombre de archivo 103.pdf
        try {
            AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
            HttpSession session = SessionUtils.getSession();
            long id;
            id = (long) session.getAttribute("id");
        
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();

            obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            response.sendRedirect(request.getContextPath() + "/faces/user/estudiantes/download/" + opcion + ".pdf");
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
        
}//end of class
