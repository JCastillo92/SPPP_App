/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import com.sppp.DAO.CitasDaoImp;
import com.sppp.DAO.DatosDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.beans.DetallePasantia;
import com.sppp.beans.EnumEstado;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Proceso;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class UploadFile{
    DetallePasantia dp = new DetallePasantia();
    Pasantia p = new Pasantia();
    
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
        Long tamano;
        int punto;
        
        try {
            InputStream input = file.getInputStream();
            nombre = getFilename(file);
            tamano = getFile().getSize();
            //CODIGO PARA OBTENER LA EXTENSION DEL ARCHIVO
            punto = nombre.indexOf(".");
            nombreSinExt = nombre.substring(0, punto);
            extension = nombre.substring(punto,nombre.length());
            System.out.println(nombreSinExt+" "+extension+" "+tamano);
            
            
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
                    Files.copy(input, new File(local_path + id, "1" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 2:
                    //2 SCAN CARTA DE ACEPTACION .PDF
                    Files.copy(input, new File(local_path + id, "2" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 3:
                    //3 SCAN CARTA COMPROMICO
                    Files.copy(input, new File(local_path + id, "3" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 4:
                    //4 SCAN INICIO PASANTIA / FORMATO RESOLUCION
                    Files.copy(input, new File(local_path + id, "4" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 5:
                    //5

                    break;
                case 6:
                    //6

                    break;
                case 7:
                    //7

                    break;
                default:
                    System.out.println("No se ha encontrado la orden para subir el archivo scaneado");
                    break;
            }

        
            System.out.println(new File("/").getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error Al Cargar: "+ex.getMessage());
        }
        //return "subida";
        
    }
    
    
    
    
    
    //METODO PARA GUARDAR en sistema Y DESCARGAR ARCHIVOS CREADOS por alumno
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

            //mando a crear el archivo pdf, para que sea lo mas actual posible.
            obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            //mando a llamar al mmismo archivo pdf en la aplicacion,  para que se pueda descargar
            response.sendRedirect(request.getContextPath() + "/faces/user/estudiantes/download/" + opcion + ".pdf");
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
        
        
        
        
        
        
        public String enviar_arch_msj(int button_action){
          //aqui envio el email al docente encargado de acorde a la accion dada.
        MailingMain primer_mensaje=new MailingMain();
        ListaDocentesAdministrativos corrreo_De=new ListaDocentesAdministrativos();
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        
        PasantiaDAO ppDAO = new PasantiaDAO();
   
        
        switch(button_action){
            case 2:
                try {
                    //envio mail a encargado mail para que revise scan de REVISIÓN DE OFICIO Y CARTA DE ACEPTACIÓN 
        primer_mensaje.mensajes(1002,corrreo_De.corrreoDocenteAdministrativo(6),"vacio");
            
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 4 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),4);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.aprobar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Ingreso Datos Carta Compromiso");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(7));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        break;
            case 3:
         try {
                //envio mail a encargado mail para que revise scan de REVISIÓN DE CARTA COMPROMISO
        primer_mensaje.mensajes(1003,corrreo_De.corrreoDocenteAdministrativo(6),"vacio");  
            
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 11 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),11);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.aprobar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Validacion PDFs");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(14));
            dp3.setValidacion(EnumEstado.validar);
            dpDAO.insertarNuevoDetalle(dp3);
            
            //Se setea datos a falso de los 4 documentos a validar
            DatosDAO dDAO = new DatosDAO();
            dDAO.insertarFalsosValidacionPDF(dp3);
            
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
        try {
                //envio mail a encargado mail para que revise scan de REVISIÓN DE INICIAR PASANTÍA
        primer_mensaje.mensajes(1004,corrreo_De.corrreoDocenteAdministrativo(6),"vacio");
            
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 14 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),14);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.validar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Resolucion de Proceso");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(17));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
            case 5:
               
                break;
            default:
                break;
        }
            return "revision_window";
        }
        
         public void download_file_tut(int opcion,long user,long cedula_tut) {///aqui recibir nombre de archivo 103.pdf
        try {
            AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
           // HttpSession session = SessionUtils.getSession();
            //long id;
            //id = (long) session.getAttribute("id");
        obj_crearpdf.pdf_InformeTutor(user, opcion,cedula_tut);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();

            //mando a crear el archivo pdf, para que sea lo mas actual posible.
         //   obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            //mando a llamar al mmismo archivo pdf en la aplicacion,  para que se pueda descargar
            response.sendRedirect(request.getContextPath() + "/faces/user/tutor/download2"+"/"+user+"/"+opcion + ".pdf");
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
        
         
            public void download_file_gest(int opcion,long user) {///aqui recibir nombre de archivo 103.pdf
        try {
            //AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
           // HttpSession session = SessionUtils.getSession();
            //long id;
            //id = (long) session.getAttribute("id");
        
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();

            //mando a crear el archivo pdf, para que sea lo mas actual posible.
         //   obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            //mando a llamar al mmismo archivo pdf en la aplicacion,  para que se pueda descargar
            response.sendRedirect(request.getContextPath() + "/faces/user/gestores/downloadGestEst"+"/"+user+"/"+opcion + ".pdf");
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
         
       public void save_file_tut(int opcion,long user){
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
            
            
      

            switch(opcion){
                case 1:
                    //300 informe tutor .PDF
                    Files.copy(input, new File(local_path + user, "300" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 2:
                    //301 informe seguimiento tutor .PDF
                    Files.copy(input, new File(local_path + user, "301" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 3:
                    //302 hoja de ruta
                    Files.copy(input, new File(local_path + user, "302" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                case 4:
                     //303 autoevaluacion 
                    Files.copy(input, new File(local_path + user, "303" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    
                    break;
                case 5:
                     //304 certificado de culminacion 
                    Files.copy(input, new File(local_path + user, "304" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                   
                    break;
                case 6:
                      //305 derecho 
                    Files.copy(input, new File(local_path + user, "305" + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                   
                    break;
                case 7:
                    //7

                    break;
                default:
                    System.out.println("No se ha encontrado la orden para subir el archivo scaneado");
                    break;
            }

        
            System.out.println(new File("/").getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error Al Cargar: "+ex.getMessage());
        }
        //return "subida";
       
        
        
        
    }
  public void download_file_coor(int opcion,long user) {///aqui recibir nombre de archivo 103.pdf
        try {
            //AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
           // HttpSession session = SessionUtils.getSession();
            //long id;
            //id = (long) session.getAttribute("id");
        
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();

            //mando a crear el archivo pdf, para que sea lo mas actual posible.
         //   obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            //mando a llamar al mmismo archivo pdf en la aplicacion,  para que se pueda descargar
            response.sendRedirect(request.getContextPath() + "/faces/user/coordinador/download1"+"/"+user+"/"+opcion + ".pdf");
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
        
       public void save_file_coor(long user){
           AlmacenamientoPDF crear=new AlmacenamientoPDF();
           CitasDaoImp llamar=new CitasDaoImp();
           crear.create_student_folder_first_time(user);
          crear.create_student_folder_first_time(llamar.id_secretaria());
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
            
            
        SimpleDateFormat sdf_data = new SimpleDateFormat("dd-MM-yyyy"); 
         java.util.Date fecha = new Date();
         String fecha1=sdf_data.format(fecha);
      

                    //informe coordinador
                    Files.copy(input, new File(local_path + user, fecha1 + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(input, new File(local_path + llamar.id_secretaria(), fecha1 + extension).toPath(), StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println(new File("/").getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error Al Cargar: "+ex.getMessage());
        }
        //return "subida";
       
       }
       
   public List<String> listar(long user) throws IOException{
         List<String> nombre = new ArrayList<String>();
           Paths g=new Paths();     
       File dir = new File(g.local_path()+"/"+user);
       String[] ficheros = dir.list();
   
       if (ficheros == null)
  System.out.println("No hay ficheros en el directorio especificado");
else { 
  for (int x=0;x<ficheros.length;x++){
      System.out.println("dfkjnjngb"+ficheros[x]);
           
  nombre.add(ficheros[x]);
  }
} return nombre;
       }
        
   public void download_all_coor(String opcion) {///aqui recibir nombre de archivo 103.pdf
        try {
            //AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
         //   HttpSession session = SessionUtils.getSession();
           // long id;
            //id = (long) session.getAttribute("id");
        
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();

            //mando a crear el archivo pdf, para que sea lo mas actual posible.
            //obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            //mando a llamar al mmismo archivo pdf en la aplicacion,  para que se pueda descargar
            response.sendRedirect(request.getContextPath() + "/faces/user/coordinador/download3/" + opcion);
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
  
    public void download_secret(String opciones) {///aqui recibir nombre de archivo 103.pdf
        try {
            //AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
            HttpSession session = SessionUtils.getSession();
            long id;
            id = (long) session.getAttribute("id");
        String opcion;
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) context.getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();

            //mando a crear el archivo pdf, para que sea lo mas actual posible.
            //obj_crearpdf.guardado_archivo_pdf_creado(id, opcion);
            //mando a llamar al mmismo archivo pdf en la aplicacion,  para que se pueda descargar
                
  
            response.sendRedirect(request.getContextPath() + "/faces/user/secretaria/downloadSec/" + opciones);
            //response.sendRedirect("index.jsf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of DOWNLOAD_FILE
  
   
   public String documentosubidoTu(){
       
        
       return "revision_windowFin";
   }
   
   /* --------------------  CODIGO JHON NO TOCAR ------------------------------ */
   
   
   
}//end of class
