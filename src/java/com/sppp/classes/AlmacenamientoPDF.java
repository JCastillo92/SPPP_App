/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.beans.Empresa;
import com.sppp.beans.Encargado;
import com.sppp.beans.LocalTimeDate;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Jairo
 */
public class AlmacenamientoPDF{
    //variables globales
    boolean exitoalguardar=false;
    Paths directorio=new Paths();
    private final String local_path=directorio.local_path();
    private final String local_path_images=directorio.local_path_images();
    ListaDocentesAdministrativos buscar_docadmin=new ListaDocentesAdministrativos();
  

    //invocacion a clases que debo usar para obtener los datos
                private Usuario usuario = new Usuario();//jairo
                private Pasantia pasantia=new Pasantia();//jairo
                private Encargado encargado=new Encargado();//jairo
                private Empresa empresa=new Empresa();//jairo
                private VisitaTutor tutor=new VisitaTutor();//karen


        
    
    public boolean create_student_folder_first_time(long cedula){
        //NOTA el path /home/SPPP_PDF/ ya debe estar creado, para que lueg se proceda a crear cada carpeta con la ci
    File dir = new File(local_path+cedula+"");
    exitoalguardar=false;
    if(!dir.exists()){
        System.out.println("intentando crear nuevo directorio por primera y unica vez"+dir.getName());
         try{
        dir.mkdir();// attempt to create the directory here
        exitoalguardar=true;
        } 
        catch(SecurityException se){
        exitoalguardar=false;
        }
    }else{
        exitoalguardar=true;
    }
    
    //comprobacion local
    if(exitoalguardar){System.out.println("directory was created successfully");
        }else{System.out.println("failed trying to create the directory");}
    return exitoalguardar;
    }
    
    public boolean guardado_archivo_pdf_creado(long cedula,int numero_pdf){
        exitoalguardar=false;     
        switch(numero_pdf){
            case 101:
                //oficiio para la emresa
                exitoalguardar=pdf_oficioempresa(cedula, numero_pdf);
                break;
            case 102:
                //carta de aceptacion
                exitoalguardar=pdf_cartaaceptacion(cedula, numero_pdf);
                break;
            case 103:
                //carta de compromiso
                exitoalguardar=pdf_cartadecompromiso(cedula, numero_pdf);
                break;
            case 104:
               //formato solicitud resolucion
                exitoalguardar=pdf_formatoiniciopasantiaempresa(cedula, numero_pdf);
                break;
            case 105:
               
                break; 
            case 111:
               
                break;
            default:
                System.out.println("No se ha encontrado dentro del case el numero para crear el .PDF");
                exitoalguardar=false;
                break;
        }//end of SWITCH
        return exitoalguardar;
    }//fin metodo
    
    
    
    public boolean pdf_cartadecompromiso(long cedula,int numero_pdf){//103
        exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
        
         try {
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
            
         
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
         Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
             
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
      Paragraph p1=new Paragraph("CARTA COMPROMISO INTERINSTITUCIONAL",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      //                            SEPARAR POR SECCIONES
      //SEC INFORMACION GENERAL
      //https://developers.itextpdf.com/examples/tables/colspan-and-rowspan
       documento.add(new Paragraph("INFORMACIÓN GENERAL",estexto));
  documento.add(salto_linea);
  
  //tabla 1
  PdfPTable table = new PdfPTable(4);//# columns
  //1 row
  table.addCell(new Paragraph("CÓDIGO:",estexto));
  table.addCell(new Paragraph(pasantia.getTipo_ppp(),estexto));
  table.addCell(new Paragraph("No.:",estexto));
  table.addCell(new Paragraph(""+pasantia.getCod_ppp(),estexto));
  
  //2 row
  table.addCell(new Paragraph("NOMBRE DE LA EMPRESA O INSTITUCIÓN:",estexto));
  cell = new PdfPCell(new Paragraph(empresa.getNombre_empresa(),estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  table.addCell(cell);
   
  //3 row
  table.addCell(new Paragraph("DIRECCIÓN:",estexto));
  table.addCell(new Paragraph(empresa.getDireccion_empresa(),estexto));
  table.addCell(new Paragraph("TELÉFONO:",estexto));
  table.addCell(new Paragraph(empresa.getTelefono_empresa(),estexto));
  
  //4 row
  table.addCell(new Paragraph("ACTIVIDAD PRINCIPAL DE LA EMPRESA O INSTITUCIÓN:",estexto));
  cell = new PdfPCell(new Paragraph(empresa.getActividad_principal_empresa(),estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  table.addCell(cell);
  
  //5 row
  table.addCell(new Paragraph("APELLIDOS Y NOMBRES DEL ESTUDIANTE:",estexto));
   cell = new PdfPCell(new Paragraph(usuario.getApellido()+" "+usuario.getNombre(),estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  table.addCell(cell);
  
  //6 row
  table.addCell(new Paragraph("CARRERA DE GRADO:",estexto));
  table.addCell(new Paragraph("INGENIERÍA DE SISTEMAS",estexto));
  table.addCell(new Paragraph("CICLO o SEMESTRE QUE CURSA:",estexto));
  table.addCell(new Paragraph(""+usuario.getEstudiante().getUltimoNivel(),estexto));
  documento.add(table);
  //FIN TABLA 1
  
  //SEC DESCRIPCIÓN ESTRATÉGICA DE INTERVENCIÓN
  documento.add(salto_linea);
  documento.add(salto_linea);
  
   documento.add(new Paragraph("DESCRIPCIÓN ESTRATÉGICA DE INTERVENCIÓN",estexto));
  documento.add(salto_linea);
   
//tabla 2
   PdfPTable table2 = new PdfPTable(6);//# columns
  //1 row
  table2.addCell(new Paragraph("TIPO DE ACTIVIDAD ACADÉMICA:",estexto));
  cell = new PdfPCell(new Paragraph(giveMeNamePPP(pasantia.getTipo_ppp()),estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  table2.addCell(new Paragraph("TOTAL HORAS:",estexto));
  table2.addCell(new Paragraph(""+usuario.getEstudiante().getHorasPasantia(),estexto));
  
  //2 row
  cell = new PdfPCell(new Paragraph("OBJETO DE LA ACTIVIDAD ACADÉMICA",estexto));
  cell.setRowspan(2);//#columnas a merge para esta celda
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph("xxxxxxxxx",estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  cell.setRowspan(2);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph("FECHA INICIO:",estexto));
  table2.addCell(new Paragraph(""+pasantia.getFechaInicio(),estexto));
  table2.addCell(new Paragraph("FECHA FINAL:",estexto));
  table2.addCell(new Paragraph(""+pasantia.getFechaFin(),estexto));

  //3 row
  table2.addCell(new Paragraph("HORARIO PREVISTO:",estexto));
  cell = new PdfPCell(new Paragraph("xxxxxxxxxxxxxxx",estexto));
  cell.setColspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  table2.addCell(new Paragraph("NOMBRE PROGRAMA:",estexto));
  cell = new PdfPCell(new Paragraph("xxxxxxxxxxxxxxx",estexto));
  cell.setColspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  
  //4 row
  table2.addCell(new Paragraph("ÁREA QUE REQUIERE LA ACTIVIDAD ACADÉMICA:",estexto));
  cell = new PdfPCell(new Paragraph("xxxxxxxxxxxxxxx",estexto));
  cell.setColspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  table2.addCell(new Paragraph("RESPONSABLE DEL ÁREA:",estexto));
  cell = new PdfPCell(new Paragraph(encargado.getNombre_encargado(),estexto));
  cell.setColspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  documento.add(table2);
  //FIN TABLA 2
  
  
                    //SEC ACTIVIDADES PREVISTAS A SER DESARROLLADAS EN LA ACTIVIDAD ACADÉMICA: (SEÑALE AQUELLAS QUE PREVÉN RESULTADOS Y PRODUCTOS)
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    Paragraph p2 = new Paragraph("ACTIVIDADES PREVISTAS A SER DESARROLLADAS EN LA ACTIVIDAD ACADÉMICA", estexto);
                    p2.setAlignment(Element.ALIGN_CENTER);
                    documento.add(p2);
                    
                   
                    documento.add(new Paragraph("(SEÑALE AQUELLAS QUE PREVÉN RESULTADOS Y PRODUCTOS)", estexto));
                    documento.add(salto_linea);
                    //TABLA 3 INICIO
                    PdfPTable table3 = new PdfPTable(1);//# columns
                    //1 row
                    table3.addCell(new Paragraph("XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX", estexto));
                    documento.add(table3);
                    //FIN TABLA 3

                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(new Paragraph("RESULTADOS PREVISTOS DE ACTIVIDAD ACADÉMICA", estexto));
                    documento.add(salto_linea);
                    //TABLA 4 INICIO
                    PdfPTable table4 = new PdfPTable(1);//# columns
                    //1 row
                    table4.addCell(new Paragraph("XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX", estexto));
                    documento.add(table4);
                    //FIN TABLA 4
                    
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    Paragraph p3 = new Paragraph("PRODUCTOS ENTREGABLES PREVISTOS DE LA ACTIVIDAD ACADÉMICA", estexto);
                    p3.setAlignment(Element.ALIGN_CENTER);
                    documento.add(p3);
                    documento.add(salto_linea);
                    documento.add(new Paragraph("(INCLUYA TODOS LOS MATERIALES FÍSICOS QUE SE GENERAN EN LA INTERVENCIÓN)", estexto));
                    documento.add(salto_linea);
                    
                    //TABLA 5 INICIO
                    PdfPTable table5 = new PdfPTable(1);//# columns
                    //1 row
                    table5.addCell(new Paragraph("XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX" + "\n" + "XXXXXXXXXXXXX", estexto));
                    documento.add(table4);
                    //FIN TABLA 5
                    
                    
                    //inicio tabla 6
  PdfPTable table6 = new PdfPTable(4);//# columns
                 //1row
                 documento.add(salto_linea);
  table6.addCell(new Paragraph("NOMBRE DEL TUTOR:",estexto));
          cell = new PdfPCell(new Paragraph("xxxxxxxxxxxxxx urgente aqui se asiigna el tutor",estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  table6.addCell(cell);
  documento.add(table6);
  //FIN TABLA 6
                    
  
  //SEC ACEPTACIÓN Y LEGALIZACIÓN
  documento.add(salto_linea);
    documento.add(new Paragraph("ACEPTACIÓN Y LEGALIZACIÓN",estexto));
  documento.add(salto_linea);


                    //tabla 7
                    PdfPTable table7 = new PdfPTable(6);//# columns
                    //1 row
                    table7.addCell(new Paragraph("APELLIDOS Y NOMBRES DEL REPRESENTANTE LEGAL:", estexto));
                    cell = new PdfPCell(new Paragraph(empresa.getNombre_gerente(),estexto));
                    cell.setColspan(2);//total de celdas que va MERGE a esta FILA
                    table7.addCell(cell);
                    table7.addCell(new Paragraph("TELÉFONO:", estexto));
                    cell = new PdfPCell(new Paragraph(empresa.getTelefono_empresa(),estexto));
                    cell.setColspan(2);//total de celdas que va MERGE a esta FILA
                    table7.addCell(cell);
                    
                    //2 row
                    table7.addCell(new Paragraph("APELLIDOS Y NOMBRES DELEGADO UPS:", estexto));
                    cell = new PdfPCell(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(4),estexto));
                    cell.setColspan(5);//total de celdas que va MERGE a esta FILA
                    table7.addCell(cell);
                    
                    //3 row
                    table7.addCell(new Paragraph("LUGAR Y FECHA SUSCRIPCIÓN:", estexto));
                    cell = new PdfPCell(new Paragraph("xxxxx",estexto));
                    cell.setColspan(5);//total de celdas que va MERGE a esta FILA
                    table7.addCell(cell);
                    documento.add(table7);
                    documento.add(salto_linea);
                    
                    //tabla 8
                    PdfPTable table8 = new PdfPTable(3);//# columns
                    //1 row
                    table8.addCell(new Paragraph("REPRESENTANTE LEGAL:", estexto));
                    table8.addCell(new Paragraph("firma:", esnota));
                    table8.addCell(new Paragraph("sello:", esnota));
                    
                    //2 row
                    table8.addCell(new Paragraph("DIRECCIÓN TÉCNICA DE VINCULACIÓN CON LA SOCIEDAD:", estexto));
                    table8.addCell(new Paragraph("firma:", esnota));
                    table8.addCell(new Paragraph("sello:", esnota));
                    documento.add(table8);                                    
                    
                    
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
                return exitoalguardar;
    }//fin metodo
    
    public boolean pdf_oficioempresa(long cedula, int numero_pdf){//101
         //FORMATO OFICIO PARA LA EMPRESA
                      exitoalguardar=false;
     try {   
         
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
     
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
          Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
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
      Paragraph la_fehca=new Paragraph("Fecha: Quito, "+obtenerfecha.fechaAnioMesDia(),estexto);
      la_fehca.setAlignment(Element.ALIGN_RIGHT);
      documento.add(la_fehca);
      documento.add(salto_linea);
      
      //D I R I G I D O AL GERENTE DE LA EMPRESA O INSTITUCION
      documento.add(new Paragraph("Para: "+empresa.getNombre_gerente(),estexto));
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
      
      //FIRMA linea de firma
      documento.add(linea_firma);
      
      documento.add(new Paragraph("Atentamente: "+buscar_docadmin.nombreDocenteAdministrativo(1),estexto));
      
      //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
      documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito ",estexto));    
      
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
     return exitoalguardar;
    }//fin medoto
    
    public boolean pdf_cartaaceptacion(long cedula, int numero_pdf){//102
               //FORMATO CARTA DE ACEPTACION
                exitoalguardar=false;
        try{
                //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());

             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
     
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
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
      documento.add(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(1),estexto));
      
      //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
      documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito",estexto));
      
      //SALUDO
      documento.add(new Paragraph("Presente.-",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(new Paragraph("De mis consideraciones:",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
           
      // C U  E R  P O   DE  D O C U M E N T O 
      Paragraph cuerpo=new Paragraph("Por medio de la presente comunicamos a usted, la aceptación del estudiante "
              + ""+usuario.getNombre()+" "+usuario.getApellido()+", con cédula de ciudadanía: "+usuario.getEstudiante().getCedula()+", "
                      + "para la ejecución de "+giveMeNamePPP(pasantia.getTipo_ppp())+", del "+pasantia.getFechaInicio()+" al "+pasantia.getFechaFin()+".",estexto);
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
        } catch (DocumentException | FileNotFoundException e) {
            exitoalguardar=false;
        }
     return exitoalguardar;
    }//fin metodo
    
    public boolean pdf_formatoiniciopasantiaempresa(long cedula, int numero_pdf){//104
         //FORMATO DE INICIAR PASANTIAS EN LA EMPRESA / FORMATO SOLICITUD RESOLUCION
                exitoalguardar=false;
try{         
//LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
  
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL);
                     
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            //FileOutputStream archivo = new FileOutputStream("E:\\"+cedula+"\\"+numero_pdf+".pdf");//asi se guardara el archivo
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
      Paragraph p1=new Paragraph("FORMATO SOLICITUD RESOLUCIÓN",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
            //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
      documento.add(salto_linea);
      documento.add(salto_linea);
           ListaDocentesAdministrativos buscar_docadmin=new ListaDocentesAdministrativos();
      documento.add(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(1),estexto));
      
      //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
      documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito",estexto));
      
      //SALUDO
      documento.add(new Paragraph("Presente.-",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(new Paragraph("De mis consideraciones:",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // C U  E R  P O   DE  D O C U M E N T O 
      Paragraph cuerpo=new Paragraph("Yo, "+usuario.getNombre()+" "+usuario.getApellido()+", con cédula de ciudadanía: "+usuario.getEstudiante().getCedula()+", "
                      + " solicito a Ud. la autorización del inicio de la actividad de "+giveMeNamePPP(pasantia.getTipo_ppp())+", "
                              + "desde "+pasantia.getFechaInicio()+" hasta "+pasantia.getFechaFin()+".",estexto);
      cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
      documento.add(cuerpo);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      
      //FIRMA ALUMNO
      documento.add(linea_firma);
      documento.add(new Paragraph("Atentamente, ",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      documento.add(new Paragraph(usuario.getNombre()+" "+usuario.getApellido(),estexto));
      documento.add(new Paragraph(""+usuario.getEstudiante().getCedula(),estexto));
            
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | FileNotFoundException e) {
            exitoalguardar=false;
        }
                     return exitoalguardar;
    }//fin metodo
    
    


 

  public boolean pdf_InformeTutor(long cedula,int numero_pdf,int pre10,int pre1,int pre2,int pre3,int pre4,int pre5,int pre6,int pre7,int pre8,String observaciones){//200
      exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
         try {
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
           CitasDaoImp tut=new CitasDaoImp();
           tutor=tut.findTutor(cedula);
           TablasFormatos tabla1=new TablasFormatos();
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
              Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
      Paragraph p1=new Paragraph("FORMATO INFORME TUTOR",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      //                            SEPARAR POR SECCIONES
      //SEC INFORMACION GENERAL
      //https://developers.itextpdf.com/examples/tables/colspan-and-rowspan
      documento.add(salto_linea);
 
      documento.add(salto_linea);
  documento.add(new Paragraph( "Carta Compromiso:   "+pasantia.getTipo_ppp()+pasantia.getCod_ppp()+"                                              Tipo de actividad:            "+giveMeNamePPP(pasantia.getTipo_ppp()),estexto));
  documento.add(salto_linea);
  
  documento.add(new Paragraph("Tutor:                         "+tutor.getTutor().getUsuario2().getNombre(),estexto));
  documento.add(salto_linea);
  
  
       documento.add(new Paragraph("Estudiante:                "+usuario.getNombre()+usuario.getApellido()+"                                    Cèdula estudiante:            "+usuario.getId_cedula(),estexto));
     
      
       documento.add(salto_linea);
       
  Paragraph p2=new Paragraph("Muy satisfactorio 5",estexto);
      p2.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p2);
      Paragraph p4=new Paragraph("Satisfactorio 4",estexto);
      p4.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p4);
      Paragraph p5=new Paragraph("Aceptable 3",estexto);
      p5.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p5);
      Paragraph p6=new Paragraph("Deficiente 2",estexto);
      p6.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p6);
  
    Paragraph p3=new Paragraph("Malo 1",estexto);
      p3.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p3);
      

       documento.add(salto_linea);
       documento.add(salto_linea);
       String q1=null,q2=null,q3=null,q4=null,q5=null;
       if(pre1==1){q1="X";q2=" ";q3=" ";q4=" ";q5=" ";}if(pre1==2){q1=" ";q2="X";q3=" ";q4=" ";q5=" ";}if(pre1==3){q1=" ";q2=" ";q3="X";q4=" ";q5=" ";}
        if(pre1==4){q1=" ";q2=" ";q3=" ";q4="X";q5=" ";}if(pre1==5){q1=" ";q2=" ";q3=" ";q4=" ";q5="X";}
       String w1=null,w2=null,w3=null,w4=null,w5=null; 
        if(pre2==1){w1="X";w2=" ";w3=" ";w4=" ";w5=" ";}if(pre2==2){w1=" ";w2="X";w3=" ";w4=" ";w5=" ";}if(pre2==3){w1=" ";w2=" ";w3="X";w4=" ";w5=" ";}
        if(pre2==4){w1=" ";w2=" ";w3=" ";w4="X";w5=" ";}if(pre2==5){w1=" ";w2=" ";w3=" ";w4=" ";w5="X";}
       String e1=null,e2=null,e3=null,e4=null,e5=null;
       if(pre3==1){e1="X";e2=" ";e3=" ";e4=" ";e5=" ";}if(pre3==2){e1=" ";e2="X";e3=" ";e4=" ";e5=" ";}if(pre3==3){e1=" ";e2=" ";e3="X";e4=" ";e5=" ";}
        if(pre3==4){e1=" ";e2=" ";e3=" ";e4="X";e5=" ";}if(pre3==5){e1=" ";e2=" ";e3=" ";e4=" ";e5="X";}
       String r1=null,r2=null,r3=null,r4=null,r5=null; 
        if(pre4==1){r1="X";r2=" ";r3=" ";r4=" ";r5=" ";}if(pre4==2){r1=" ";r2="X";r3=" ";r4=" ";r5=" ";}if(pre4==3){r1=" ";r2=" ";r3="X";r4=" ";r5=" ";}
        if(pre4==4){r1=" ";r2=" ";r3=" ";r4="X";r5=" ";}if(pre4==5){r1=" ";r2=" ";r3=" ";r4=" ";r5="X";}
       String t1=null,t2=null,t3=null,t4=null,t5=null;
       if(pre5==1){t1="X";t2=" ";t3=" ";t4=" ";t5=" ";}if(pre5==2){t1=" ";t2="X";t3=" ";t4=" ";t5=" ";}if(pre5==3){t1=" ";t2=" ";t3="X";t4=" ";t5=" ";}
        if(pre5==4){t1=" ";t2=" ";t3=" ";t4="X";t5=" ";}if(pre5==5){t1=" ";t2=" ";t3=" ";t4=" ";t5="X";}
       String y1=null,y2=null,y3=null,y4=null,y5=null; 
        if(pre6==1){y1="X";y2=" ";y3=" ";y4=" ";y5=" ";}if(pre6==2){y1=" ";y2="X";y3=" ";y4=" ";y5=" ";}if(pre6==3){y1=" ";y2=" ";y3="X";y4=" ";y5=" ";}
        if(pre6==4){y1=" ";y2=" ";y3=" ";y4="X";y5=" ";}if(pre6==5){y1=" ";y2=" ";y3=" ";y4=" ";y5="X";}
       String a1=null,a2=null,a3=null,a4=null,a5=null; 
        if(pre7==1){a1="X";a2=" ";a3=" ";a4=" ";a5=" ";}if(pre7==2){a1=" ";a2="X";a3=" ";a4=" ";a5=" ";}if(pre7==3){a1=" ";a2=" ";a3="X";a4=" ";a5=" ";}
        if(pre7==4){a1=" ";a2=" ";a3=" ";a4="X";a5=" ";}if(pre7==5){a1=" ";a2=" ";a3=" ";a4=" ";a5="X";}
       String s1=null,s2=null,s3=null,s4=null,s5=null; 
        if(pre8==1){s1="X";s2=" ";s3=" ";s4=" ";s5=" ";}if(pre8==2){s1=" ";s2="X";s3=" ";s4=" ";s5=" ";}if(pre8==3){s1=" ";s2=" ";s3="X";s4=" ";s5=" ";}
        if(pre8==4){s1=" ";s2=" ";s3=" ";s4="X";s5=" ";}if(pre8==5){s1=" ";s2=" ";s3=" ";s4=" ";s5="X";}
       String f1=null,f2=null,f3=null,f4=null,f5=null; 
        if(pre10==1){f1="X";f2=" ";f3=" ";f4=" ";f5=" ";}if(pre10==2){f1=" ";f2="X";f3=" ";f4=" ";f5=" ";}if(pre10==3){f1=" ";f2=" ";f3="X";f4=" ";f5=" ";}
        if(pre10==4){f1=" ";f2=" ";f3=" ";f4="X";f5=" ";}if(pre10==5){f1=" ";f2=" ";f3=" ";f4=" ";f5="X";}
       
        
//tabla 2
   PdfPTable table2 = new PdfPTable(20);//# columns
  //1 row
  cell = new PdfPCell(new Paragraph("Cuestionario",estexto));
  cell.setRowspan(2);
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph("Escala",estexto));
  cell.setColspan(5);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  table2.addCell(new Paragraph("1",estexto));
  table2.addCell(new Paragraph("2",estexto));
  table2.addCell(new Paragraph("3",estexto));
  table2.addCell(new Paragraph("4",estexto));
  table2.addCell(new Paragraph("5",estexto));

  //2row
 cell = new PdfPCell(new Paragraph("¿Se cumplió con las actividades propuestas en la Carta Compromiso?",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  //int preg1=Integer.parseInt(pre1);
  table2.addCell(new Paragraph(f1,estexto));
   table2.addCell(new Paragraph(f2,estexto));
   table2.addCell(new Paragraph(f3,estexto));
   table2.addCell(new Paragraph(f4,estexto));
   table2.addCell(new Paragraph(f5,estexto));

  
  
 cell = new PdfPCell(new Paragraph("¿Satisfacieron los resultados a la labor institucional?",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  //int preg1=Integer.parseInt(pre1);
  table2.addCell(new Paragraph(q1,estexto));
   table2.addCell(new Paragraph(q2,estexto));
   table2.addCell(new Paragraph(q3,estexto));
   table2.addCell(new Paragraph(q4,estexto));
   table2.addCell(new Paragraph(q5,estexto));

  
  
    //3row
 cell = new PdfPCell(new Paragraph("¿El estudiante tuvo la información necesaria del proceso de pasantías, prácticas pre profesionales ó extensiones?",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(w1,estexto));
   table2.addCell(new Paragraph(w2,estexto));
   table2.addCell(new Paragraph(w3,estexto));
   table2.addCell(new Paragraph(w4,estexto));
   table2.addCell(new Paragraph(w5,estexto));
 //4row
 cell = new PdfPCell(new Paragraph("La calidad de los productos ofrecidos fueron:",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(e1,estexto));
   table2.addCell(new Paragraph(e2,estexto));
   table2.addCell(new Paragraph(e3,estexto));
   table2.addCell(new Paragraph(e4,estexto));
   table2.addCell(new Paragraph(e5,estexto));
    //5row
 cell = new PdfPCell(new Paragraph("El comportamiento del estudiante en la institución externa fue:",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(r1,estexto));
   table2.addCell(new Paragraph(r2,estexto));
   table2.addCell(new Paragraph(r3,estexto));
   table2.addCell(new Paragraph(r4,estexto));
   table2.addCell(new Paragraph(r5,estexto));
 //6row
 cell = new PdfPCell(new Paragraph("La destreza desmostrada del estudiante en sus actividades fue:",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(t1,estexto));
   table2.addCell(new Paragraph(t2,estexto));
   table2.addCell(new Paragraph(t3,estexto));
   table2.addCell(new Paragraph(t4,estexto));
   table2.addCell(new Paragraph(t5,estexto));
 //7row
 cell = new PdfPCell(new Paragraph("El nivel de información proporcionada por la institución externa fue:",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(y1,estexto));
   table2.addCell(new Paragraph(y2,estexto));
   table2.addCell(new Paragraph(y3,estexto));
   table2.addCell(new Paragraph(y4,estexto));
   table2.addCell(new Paragraph(y5,estexto));
 //8row
 cell = new PdfPCell(new Paragraph("La relación del estudiante con el tutor de la institución externa fue:",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(a1,estexto));
   table2.addCell(new Paragraph(a2,estexto));
   table2.addCell(new Paragraph(a3,estexto));
   table2.addCell(new Paragraph(a4,estexto));
   table2.addCell(new Paragraph(a5,estexto));
 //9row
 cell = new PdfPCell(new Paragraph("La relación del estudiante con el tutor de la UPS fue:",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(s1,estexto));
   table2.addCell(new Paragraph(s2,estexto));
   table2.addCell(new Paragraph(s3,estexto));
   table2.addCell(new Paragraph(s4,estexto));
   table2.addCell(new Paragraph(s5,estexto));


  documento.add(table2);
  //FIN TABLA 2
  
  
                    //SEC ACTIVIDADES PREVISTAS A SER DESARROLLADAS EN LA ACTIVIDAD ACADÉMICA: (SEÑALE AQUELLAS QUE PREVÉN RESULTADOS Y PRODUCTOS)
                    documento.add(salto_linea);

                    documento.add(new Paragraph("En caso de tener observaciones, inquietudes y/o sugerencias, detallar a continuacion: ", estexto));
                    documento.add(salto_linea);

                    //TABLA 3 INICIO
                    PdfPTable table3 = new PdfPTable(1);//# columns
                    //1 row
                    table3.addCell(new Paragraph("              " + "\n" +observaciones, estexto));
                    documento.add(table3);
                    //FIN TABLA 3
//FIRMA ALUMNO
documento.add(salto_linea);
      
         Paragraph p7=new Paragraph(linea_firma);
      p7.setAlignment(Element.ALIGN_CENTER);
      documento.add(p7);
       Paragraph p8=new Paragraph("Tutor",estexto);
      p8.setAlignment(Element.ALIGN_CENTER);
      documento.add(p8);
      
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
                return exitoalguardar;

    }//fin metodo
    
  public boolean pdf_InformeSeguimientoTutor(long cedula,int numero_pdf,String des1,int hor1,int tec1,int per1,int cont1,String des2,int hor2,int tec2,int per2,int cont2,String des3,int hor3,int tec3,int per3,int cont3,String des4,int hor4,int tec4,int per4,int cont4,int totalhoras){//200
      exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
         
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
           CitasDaoImp tut=new CitasDaoImp();
           tutor=tut.findTutor(cedula);
           TablasFormatos tabla1=new TablasFormatos();
         
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                try {
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
              Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
      Paragraph p1=new Paragraph("FORMATO INFORME SEGUIMIENTO TUTOR",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      //                            SEPARAR POR SECCIONES
      //SEC INFORMACION GENERAL
      //https://developers.itextpdf.com/examples/tables/colspan-and-rowspan
      documento.add(salto_linea);
 
      documento.add(salto_linea);
  documento.add(new Paragraph( "Carta Compromiso:         "+pasantia.getTipo_ppp()+pasantia.getCod_ppp()+"                                              Tipo de actividad:            "+giveMeNamePPP(pasantia.getTipo_ppp()),estexto));
  documento.add(salto_linea);
  
  documento.add(new Paragraph("Estudiante:                  "+usuario.getNombre()+usuario.getApellido()+"                                             Cedula estudiante:             "+usuario.getId_cedula(),estexto));
  documento.add(salto_linea);
  
  
       documento.add(new Paragraph("Tutor UPS:                    "+tutor.getTutor().getUsuario2().getNombre()+tutor.getTutor().getUsuario2().getApellido()+"                                    Tutor institucion:            "+encargado.getNombre_encargado(),estexto));
     
      
       documento.add(salto_linea);
       
       documento.add(new Paragraph("Tutor Institucion:         "+empresa.getNombre_gerente(),estexto));
       documento.add(salto_linea);
     
       
   
//tabla 2
   PdfPTable table2 = new PdfPTable(20);//# columns
  //1 row
  cell = new PdfPCell(new Paragraph("Cuestionario",estexto));
  cell.setRowspan(2);
  cell.setColspan(13);//#columnas a merge para esta celda
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph("Horas asignadas",estexto));
  cell.setRowspan(2);
  cell.setColspan(4);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph("Criterios de desempeño",estexto));
  cell.setColspan(3);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  table2.addCell(new Paragraph("Tècnico",estexto));
  table2.addCell(new Paragraph("Personal",estexto));
  table2.addCell(new Paragraph("Contextual",estexto));

  //2row
 cell = new PdfPCell(new Paragraph(des1,estexto));
  cell.setColspan(13);//#columnas a merge para esta celda
  table2.addCell(cell);
cell = new PdfPCell(new Paragraph(""+hor1,estexto));
  cell.setColspan(4);//#columnas a merge para esta celda
  table2.addCell(cell); 
  table2.addCell(new Paragraph(""+tec1,estexto));
   table2.addCell(new Paragraph(""+per1,estexto));
   table2.addCell(new Paragraph(""+cont1,estexto));

 cell = new PdfPCell(new Paragraph(des2,estexto));
  cell.setColspan(13);//#columnas a merge para esta celda
  table2.addCell(cell);
cell = new PdfPCell(new Paragraph(""+hor2,estexto));
  cell.setColspan(4);//#columnas a merge para esta celda
  table2.addCell(cell); 
  table2.addCell(new Paragraph(""+tec2,estexto));
   table2.addCell(new Paragraph(""+per2,estexto));
   table2.addCell(new Paragraph(""+cont2,estexto));

 cell = new PdfPCell(new Paragraph(des3,estexto));
  cell.setColspan(13);//#columnas a merge para esta celda
  table2.addCell(cell);
cell = new PdfPCell(new Paragraph(""+hor3,estexto));
  cell.setColspan(4);//#columnas a merge para esta celda
  table2.addCell(cell); 
  table2.addCell(new Paragraph(""+tec3,estexto));
   table2.addCell(new Paragraph(""+per3,estexto));
   table2.addCell(new Paragraph(""+cont3,estexto));

 cell = new PdfPCell(new Paragraph(des4,estexto));
  cell.setColspan(13);//#columnas a merge para esta celda
  table2.addCell(cell);
cell = new PdfPCell(new Paragraph(""+hor4,estexto));
  cell.setColspan(4);//#columnas a merge para esta celda
  table2.addCell(cell); 
  table2.addCell(new Paragraph(""+tec4,estexto));
   table2.addCell(new Paragraph(""+per4,estexto));
   table2.addCell(new Paragraph(""+cont4,estexto));
   
  documento.add(table2);
  //FIN TABLA 2
  
  
                    //SEC ACTIVIDADES PREVISTAS A SER DESARROLLADAS EN LA ACTIVIDAD ACADÉMICA: (SEÑALE AQUELLAS QUE PREVÉN RESULTADOS Y PRODUCTOS)
                    documento.add(salto_linea);

  documento.add(new Paragraph("Total de horas:         "+totalhoras, estexto));
  documento.add(new Paragraph("Fecha visita:           "+tutor.getFecha_visita(), estexto));
                   
                    documento.add(salto_linea);

                   

                    documento.add(new Paragraph("Calificar sobre 5 el criterio personal y contextual. (5 - Muy Satisfactorio, 4 - Satisfactorio, 3 - Aceptable, 2 - Deficiente, 1 - Malo) ", estexto));
                    documento.add(new Paragraph("Calificar sobre 5 cada actividad. (5 - Muy Satisfactorio, 4 - Satisfactorio, 3 - Aceptable, 2 - Deficiente, 1 - Malo) ", estexto));
                   
                    documento.add(salto_linea);

                   
      
         Paragraph p7=new Paragraph(linea_firma+"                    "+linea_firma);
      p7.setAlignment(Element.ALIGN_CENTER);
      documento.add(p7);
       Paragraph p8=new Paragraph("Tutor Ups                          Tutor institucion",estexto);
      p8.setAlignment(Element.ALIGN_CENTER);
      documento.add(p8);
      
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
                return exitoalguardar;

    }//fin metodo
    
   public boolean pdf_hojaRuta(long cedula,int numero_pdf,String observacionvisita,String movilizacionvisita){//200
      exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
         
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
           CitasDaoImp tut=new CitasDaoImp();
        
          
           tutor=tut.findTutor(cedula);
           CitasAgendadas coordinador= new CitasAgendadas();
           TablasFormatos tabla1=new TablasFormatos();
           
         
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                try {
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
              Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
      Paragraph p1=new Paragraph("FORMATO HOJA DE RUTA",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      //                            SEPARAR POR SECCIONES
      //SEC INFORMACION GENERAL
      //https://developers.itextpdf.com/examples/tables/colspan-and-rowspan
      documento.add(salto_linea);
 
      documento.add(salto_linea);
  documento.add(new Paragraph( "Entidad colaboradora:         "+empresa.getNombre_empresa()+"                         Direccion empresa:   "+empresa.getDireccion_empresa(),estexto));
  documento.add(salto_linea);
  
  documento.add(new Paragraph("Estudiante:                         "+usuario.getNombre()+usuario.getApellido(),estexto));
  documento.add(salto_linea);
  
  
       documento.add(new Paragraph("Docente coordinador:             "+coordinador.getCoordinador(),estexto));
     
      
       documento.add(salto_linea);
       
       
//tabla 2
    PdfPTable table2 = new PdfPTable(21);//# columns
  
 
   cell = new PdfPCell(new Paragraph("Visita",estexto));
  cell.setColspan(6);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph("Tutor asignado por la empresa",estexto));
  cell.setColspan(3);
  cell.setRowspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph("Firma",estexto));
  cell.setColspan(3);
  cell.setRowspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph("Sello",estexto));
  cell.setColspan(3);
   cell.setRowspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph("Observaciones",estexto));
  cell.setColspan(3);
   cell.setRowspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  
   cell = new PdfPCell(new Paragraph("Movilizacion",estexto));
 cell.setColspan(3);
   cell.setRowspan(2);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  
  
   cell = new PdfPCell(new Paragraph("Nª",estexto));
 cell.setColspan(2);
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph("Fecha",estexto));
 cell.setColspan(2);
  table2.addCell(cell);
  
   cell = new PdfPCell(new Paragraph("Hora",estexto));
 cell.setColspan(2);
  table2.addCell(cell);
  
     cell = new PdfPCell(new Paragraph(""+tutor.getId_visita(),estexto));
 cell.setColspan(2);
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph(""+tutor.getFecha_visita(),estexto));
 cell.setColspan(2);
  table2.addCell(cell);
  
   cell = new PdfPCell(new Paragraph(""+tutor.getHora_visita(),estexto));
 cell.setColspan(2);
  table2.addCell(cell);
  
  cell = new PdfPCell(new Paragraph(""+tutor.getTutor().getUsuario2().getNombre(),estexto));
  cell.setColspan(3);
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph(" ",estexto));
  cell.setColspan(3);
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph(" ",estexto));
  cell.setColspan(3);
  table2.addCell(cell);
   cell = new PdfPCell(new Paragraph(observacionvisita,estexto));
  cell.setColspan(3);
  table2.addCell(cell);
  
   cell = new PdfPCell(new Paragraph(movilizacionvisita,estexto));
 cell.setColspan(3);
  table2.addCell(cell);
  
  
  documento.add(table2);
  //FIN TABLA 2
 
  
                    //SEC ACTIVIDADES PREVISTAS A SER DESARROLLADAS EN LA ACTIVIDAD ACADÉMICA: (SEÑALE AQUELLAS QUE PREVÉN RESULTADOS Y PRODUCTOS)
                    documento.add(salto_linea);
 documento.add(salto_linea); documento.add(salto_linea); documento.add(salto_linea);
  
                   
      
         Paragraph p7=new Paragraph(linea_firma+"                         "+linea_firma);
      p7.setAlignment(Element.ALIGN_CENTER);
      documento.add(p7);
       Paragraph p8=new Paragraph("Ing. Supervisor de pasantias                          Director de carrera",estexto);
      p8.setAlignment(Element.ALIGN_CENTER);
      documento.add(p8);
      
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
                return exitoalguardar;

    }//fin metodo
 
  public boolean pdf_autoevaluacion(long cedula,int numero_pdf,int auto1,int auto2,int auto3,int auto4,int auto5){//200
      exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
         
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
           CitasDaoImp tut=new CitasDaoImp();
           tutor=tut.findTutor(cedula);
           TablasFormatos tabla1=new TablasFormatos();
         
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                try {
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
              Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
      Paragraph p1=new Paragraph("FORMATO AUTOEVALUACIÒN",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
      //                            SEPARAR POR SECCIONES
      //SEC INFORMACION GENERAL
      //https://developers.itextpdf.com/examples/tables/colspan-and-rowspan
      documento.add(salto_linea);
 
      documento.add(salto_linea);
  documento.add(new Paragraph( "Carta Compromiso:   "+pasantia.getTipo_ppp()+pasantia.getCod_ppp()+"                                              Tipo de actividad:            "+giveMeNamePPP(pasantia.getTipo_ppp()),estexto));
  documento.add(salto_linea);
  
  documento.add(new Paragraph("Resolucion de consejo de inicio de actividad:                         ",estexto));
  documento.add(salto_linea);
  
  
       documento.add(new Paragraph("Estudiante:                "+usuario.getNombre()+usuario.getApellido()+"                                    Cèdula estudiante:            "+usuario.getId_cedula(),estexto));
     
      
       documento.add(salto_linea);
  
  documento.add(new Paragraph("Auto-evalúe con honestidad su grado de participación durante el tiempo que efectúo  en la Institución la pasantia o pràctica, en función de las siguientes equivalencias:",estexto));
  documento.add(salto_linea);
       
  Paragraph p2=new Paragraph("Muy satisfactorio 5",estexto);
      p2.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p2);
      Paragraph p4=new Paragraph("Satisfactorio 4",estexto);
      p4.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p4);
      Paragraph p5=new Paragraph("Aceptable 3",estexto);
      p5.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p5);
      Paragraph p6=new Paragraph("Deficiente 2",estexto);
      p6.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p6);
  
    Paragraph p3=new Paragraph("Malo 1",estexto);
      p3.setAlignment(Element.ALIGN_RIGHT);
      documento.add(p3);
      

       documento.add(salto_linea);
       documento.add(salto_linea);
       
   String q1=null,q2=null,q3=null,q4=null,q5=null;
       if(auto1==1){q1="X";q2=" ";q3=" ";q4=" ";q5=" ";}if(auto1==2){q1=" ";q2="X";q3=" ";q4=" ";q5=" ";}if(auto1==3){q1=" ";q2=" ";q3="X";q4=" ";q5=" ";}
        if(auto1==4){q1=" ";q2=" ";q3=" ";q4="X";q5=" ";}if(auto1==5){q1=" ";q2=" ";q3=" ";q4=" ";q5="X";}
       String w1=null,w2=null,w3=null,w4=null,w5=null; 
        if(auto2==1){w1="X";w2=" ";w3=" ";w4=" ";w5=" ";}if(auto2==2){w1=" ";w2="X";w3=" ";w4=" ";w5=" ";}if(auto2==3){w1=" ";w2=" ";w3="X";w4=" ";w5=" ";}
        if(auto2==4){w1=" ";w2=" ";w3=" ";w4="X";w5=" ";}if(auto2==5){w1=" ";w2=" ";w3=" ";w4=" ";w5="X";}
       String e1=null,e2=null,e3=null,e4=null,e5=null;
       if(auto3==1){e1="X";e2=" ";e3=" ";e4=" ";e5=" ";}if(auto3==2){e1=" ";e2="X";e3=" ";e4=" ";e5=" ";}if(auto3==3){e1=" ";e2=" ";e3="X";e4=" ";e5=" ";}
        if(auto3==4){e1=" ";e2=" ";e3=" ";e4="X";e5=" ";}if(auto3==5){e1=" ";e2=" ";e3=" ";e4=" ";e5="X";}
       String r1=null,r2=null,r3=null,r4=null,r5=null; 
        if(auto4==1){r1="X";r2=" ";r3=" ";r4=" ";r5=" ";}if(auto4==2){r1=" ";r2="X";r3=" ";r4=" ";r5=" ";}if(auto4==3){r1=" ";r2=" ";r3="X";r4=" ";r5=" ";}
        if(auto4==4){r1=" ";r2=" ";r3=" ";r4="X";r5=" ";}if(auto4==5){r1=" ";r2=" ";r3=" ";r4=" ";r5="X";}
       String t1=null,t2=null,t3=null,t4=null,t5=null;
       if(auto5==1){t1="X";t2=" ";t3=" ";t4=" ";t5=" ";}if(auto5==2){t1=" ";t2="X";t3=" ";t4=" ";t5=" ";}if(auto5==3){t1=" ";t2=" ";t3="X";t4=" ";t5=" ";}
        if(auto5==4){t1=" ";t2=" ";t3=" ";t4="X";t5=" ";}if(auto5==5){t1=" ";t2=" ";t3=" ";t4=" ";t5="X";}
       
       
       
//tabla 2
   PdfPTable table2 = new PdfPTable(20);//# columns
  //1 row
  cell = new PdfPCell(new Paragraph("Cuestionario",estexto));
  cell.setRowspan(2);
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  cell = new PdfPCell(new Paragraph("Escala",estexto));
  cell.setColspan(5);//total de celdas que va MERGE a esta FILA
  table2.addCell(cell);
  table2.addCell(new Paragraph("1",estexto));
  table2.addCell(new Paragraph("2",estexto));
  table2.addCell(new Paragraph("3",estexto));
  table2.addCell(new Paragraph("4",estexto));
  table2.addCell(new Paragraph("5",estexto));

  //2row
 cell = new PdfPCell(new Paragraph(" Asistencia y puntualidad durante la extensión universitaria.",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(q1,estexto));
   table2.addCell(new Paragraph(q2,estexto));
   table2.addCell(new Paragraph(q3,estexto));
   table2.addCell(new Paragraph(q4,estexto));
   table2.addCell(new Paragraph(q5,estexto));

    //3row
 cell = new PdfPCell(new Paragraph("Responsabilidad, disposición y cumplimiento en la ejecución de tareas.",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(w1,estexto));
   table2.addCell(new Paragraph(w2,estexto));
   table2.addCell(new Paragraph(w3,estexto));
   table2.addCell(new Paragraph(w4,estexto));
   table2.addCell(new Paragraph(w5,estexto));
 //4row
 cell = new PdfPCell(new Paragraph(" En las relaciones con el personal de la Institución ha predominado la cortesía, el buen trato y la amabilidad.",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(e1,estexto));
   table2.addCell(new Paragraph(e2,estexto));
   table2.addCell(new Paragraph(e3,estexto));
   table2.addCell(new Paragraph(e4,estexto));
   table2.addCell(new Paragraph(e5,estexto));
    //5row
 cell = new PdfPCell(new Paragraph("Utilización adecuada de procedimientos metodológicos. ",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(r1,estexto));
   table2.addCell(new Paragraph(r2,estexto));
   table2.addCell(new Paragraph(r3,estexto));
   table2.addCell(new Paragraph(r4,estexto));
   table2.addCell(new Paragraph(r5,estexto));
 //6row
 cell = new PdfPCell(new Paragraph("Conocimientos teóricos y prácticos de la carrera.",estexto));
  cell.setColspan(15);//#columnas a merge para esta celda
  table2.addCell(cell);
  table2.addCell(new Paragraph(t1,estexto));
   table2.addCell(new Paragraph(t2,estexto));
   table2.addCell(new Paragraph(t3,estexto));
   table2.addCell(new Paragraph(t4,estexto));
   table2.addCell(new Paragraph(t5,estexto));
 
  documento.add(table2);
  //FIN TABLA 2
  
  
 //FIRMA ALUMNO
documento.add(salto_linea);

      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
         Paragraph p7=new Paragraph(linea_firma);
      p7.setAlignment(Element.ALIGN_CENTER);
      documento.add(p7);
       Paragraph p8=new Paragraph("Estudiante",estexto);
      p8.setAlignment(Element.ALIGN_CENTER);
      documento.add(p8);
      
      //F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
                return exitoalguardar;

    }//fin metodo
  
  public boolean pdf_solicitudFinal(long cedula, int numero_pdf){//204
        exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
         
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
           CitasDaoImp tut=new CitasDaoImp();
           tutor=tut.findTutor(cedula);
           TablasFormatos tabla1=new TablasFormatos();
         
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                try {
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
              Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
   //FORMATO DE INICIAR PASANTIAS EN LA EMPRESA / FORMATO SOLICITUD RESOLUCION
      Paragraph p1=new Paragraph("FORMATO SOLICITUD DE VALIDACIÒN FINAL",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
            //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
      documento.add(salto_linea);
      documento.add(salto_linea);
           ListaDocentesAdministrativos buscar_docadmin=new ListaDocentesAdministrativos();
      documento.add(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(1),estexto));
      
      //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
      documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito",estexto));
      
      //SALUDO
      documento.add(new Paragraph("Presente.-",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(new Paragraph("De mis consideraciones:",estexto));
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // C U  E R  P O   DE  D O C U M E N T O 
      Paragraph cuerpo=new Paragraph("Yo,"+usuario.getNombre()+" "+usuario.getApellido()+", con cédula de ciudadanía: "+usuario.getEstudiante().getCedula()+", "
                      + " solicito a Ud. la autorización para la validaciòn de  "+giveMeNamePPP(pasantia.getTipo_ppp())+", en "+empresa.getNombre_empresa()+" "
                              + "desde "+pasantia.getFechaInicio()+" hasta "+pasantia.getFechaFin()+".",estexto);
      cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
      documento.add(cuerpo);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      
      //FIRMA ALUMNO
         Paragraph p7=new Paragraph(linea_firma);
      p7.setAlignment(Element.ALIGN_CENTER);
      documento.add(p7);
       Paragraph p8=new Paragraph(usuario.getNombre()+" "+usuario.getApellido(),estexto);
      p8.setAlignment(Element.ALIGN_CENTER);
      documento.add(p8);
      
       Paragraph p9=new Paragraph(""+usuario.getEstudiante().getCedula(),estexto);
      p9.setAlignment(Element.ALIGN_CENTER);
      documento.add(p9);
      
      
      documento.add(salto_linea);
       documento.add(salto_linea);
   
//F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
               return exitoalguardar;
    }//fin metodo
  
public boolean pdf_informeCoordinador(long cedula, int numero_pdf){//204
        exitoalguardar=false;
         //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
         
         //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(cedula);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(cedula);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
           CitasAgendadas llamar=new CitasAgendadas();
           
           TablasFormatos tabla1=new TablasFormatos();
         
             //VARIABLES INICIALES DEL  P D F 
                 Document documento = new Document();
                 PdfPCell cell;
                 documento.setPageSize(PageSize.A4);
                 Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
                 Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
                 Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
                 Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL); 
                 
                try {
            FileOutputStream archivo = new FileOutputStream(local_path+cedula+"/"+numero_pdf+".pdf");//asi se guardara el archivo
            PdfWriter.getInstance(documento, archivo);
      documento.open();
      
        //logo de la UPS
        Image image = Image.getInstance(local_path_images+"logo-ups-home.png");
        image.setAlignment(Image.ALIGN_LEFT);
        image.setAbsolutePosition(10, 780);
        image.scalePercent(60, 55);
        documento.add(image);
        
              Image image2 = Image.getInstance(local_path_images+"bkj2.png");
        image2.setAlignment(Image.ALIGN_RIGHT);
        image2.setAbsolutePosition(562, 458);
        image2.scalePercent(60, 75);
        documento.add(image2);
        
        Image image3 = Image.getInstance(local_path_images+"batl.png");
        image3.setAlignment(Image.ALIGN_RIGHT);
        image3.setAbsolutePosition(445, 775);
        image3.scalePercent(6, 6);
        documento.add(image3);
        
      documento.addAuthor("Universidad Politecnica Salesiana");
      Paragraph salto_linea=new Paragraph("\n");
      Paragraph linea_firma=new Paragraph("________________",estexto);
      documento.add(salto_linea);
      documento.add(salto_linea);
      documento.add(salto_linea);
      
      // T I T U L O
   //FORMATO DE INICIAR PASANTIAS EN LA EMPRESA / FORMATO SOLICITUD RESOLUCION
      Paragraph p1=new Paragraph("LISTADO DE ESTUDIANTES",estitulo);
      p1.setAlignment(Element.ALIGN_CENTER);
      documento.add(p1);
      documento.add(salto_linea);
      
       
//F I N  D O C U M E N T O 
      documento.close();
      exitoalguardar=true;
        } catch (DocumentException | IOException e) {
            exitoalguardar=false;
        }
               return exitoalguardar;
    }//fin metodo
  


  
    public String giveMeNamePPP(String nameppp){
        if(nameppp.equals("PA")){
            nameppp="pasantía";
        }
        if(nameppp.equals("PP")){
            nameppp="práctica pre profesional";
        }
        return nameppp;
    }
    
    

    
    
    

}//end of class
