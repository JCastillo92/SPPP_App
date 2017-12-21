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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.beans.Empresa;
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
public class AlmacenamientoPDF {

    //variables globales
    private String //local_path="/home/SPPP_PDF/";
            local_path = "E:/home/SPPP_PDF/";
    //local_path="D:/home/SPPP_PDF/";

    private String //local_path_images="/home/SPPP_PDF/images/";
            local_path_images = "E:/home/SPPP_PDF/images/";
    //local_path_images="D:/home/SPPP_PDF/images/";

    //invocacion a clases que debo usar para obtener los datos
    private Usuario usuario = new Usuario();//jairo
    private Pasantia pasantia = new Pasantia();//jairo
    private Encargado encargado = new Encargado();//jairo
    private Empresa empresa = new Empresa();//jairo

    public boolean create_student_folder_first_time(long cedula) {
        //NOTA el path /home/SPPP_PDF/ ya debe estar creado, para que lueg se proceda a crear cada carpeta con la ci
        File dir = new File(local_path + cedula + "");
        boolean exitoalguardar = false;
        if (!dir.exists()) {
            System.out.println("intentando crear nuevo directorio por primera y unica vez" + dir.getName());
            try {
                dir.mkdir();// attempt to create the directory here
                exitoalguardar = true;
            } catch (SecurityException se) {
                exitoalguardar = false;
            }
        }//end if(!dir.exists()){

        //comprobacion local
        if (exitoalguardar) {
            System.out.println("directory was created successfully");
        } else {
            System.out.println("failed trying to create the directory");
        }
        return exitoalguardar;
    }

    public boolean guardado_archivo_pdf_subido(long cedula, int numero_pdf) throws FileNotFoundException, IOException {
        //metodo que permite coger el archivo subido al sistema y almacenarlo en un directorio

        boolean exitoalguardar = false;

        switch (numero_pdf) {
            case 1:
//https://www.mkyong.com/java/itext-read-and-write-pdf-in-java/
                try {
                    PdfReader reader = new PdfReader(new FileInputStream(local_path + ""));
                    if (!reader.isEncrypted()) {//si el archivo PDF no esta encriptado

                    } else {

                    }
                } catch (IOException e) {
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
                exitoalguardar = false;
                break;
        }//end of SWITCH 
        return exitoalguardar;
    }//fin guardado

    public boolean guardado_archivo_pdf_creado(long cedula, int numero_pdf) {
        boolean exitoalguardar = false;
        //LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
        UsuarioDAO uDAO = new UsuarioDAO();
        usuario = uDAO.findUsuario(cedula);

        PasantiaDAO passDAO = new PasantiaDAO();
        pasantia = passDAO.findPasantia(cedula);

        EncargadoDAO encarDAO = new EncargadoDAO();
        encargado = encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());

        EmpresaDAO empreDAO = new EmpresaDAO();
        empresa = empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());

        //VARIABLES INICIALES DEL  P D F 
        Document documento = new Document();
        PdfPCell cell;
        documento.setPageSize(PageSize.A4);
        Font estitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL);
        Font estexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
        Font esnota = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.NORMAL);
        Font estextoespecial = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL);

        switch (numero_pdf) {
            case 101:
                //FORMATO OFICIO PARA LA EMPRESA
                try {
                    FileOutputStream archivo = new FileOutputStream(local_path + cedula + "/" + numero_pdf + ".pdf");//asi se guardara el archivo
                    PdfWriter.getInstance(documento, archivo);
                    documento.open();

                    //logo de la UPS
                    Image image = Image.getInstance(local_path_images + "logo-ups-home.png");
                    image.setAlignment(Image.ALIGN_LEFT);
                    image.setAbsolutePosition(10, 780);
                    image.scalePercent(60, 55);
                    documento.add(image);

                    Image image2 = Image.getInstance(local_path_images + "bkj2.png");
                    image2.setAlignment(Image.ALIGN_RIGHT);
                    image2.setAbsolutePosition(562, 458);
                    image2.scalePercent(60, 75);
                    documento.add(image2);

                    Image image3 = Image.getInstance(local_path_images + "batl.png");
                    image3.setAlignment(Image.ALIGN_RIGHT);
                    image3.setAbsolutePosition(445, 775);
                    image3.scalePercent(6, 6);
                    documento.add(image3);

                    documento.addAuthor("Universidad Politecnica Salesiana");
                    Paragraph salto_linea = new Paragraph("\n");
                    Paragraph linea_firma = new Paragraph("________________", estexto);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    // T I T U L O
                    Paragraph p1 = new Paragraph("OFICIO PARA LA EMPRESA", estitulo);
                    p1.setAlignment(Element.ALIGN_CENTER);
                    documento.add(p1);
                    documento.add(salto_linea);

                    //F E C H A  DEL  S I S T E M A  
                    LocalTimeDate obtenerfecha = new LocalTimeDate();
                    documento.add(new Paragraph("Fecha: Quito, " + obtenerfecha.fechaAnioMesDia(), estexto));
                    documento.add(salto_linea);

                    //D I R I G I D O AL GERENTE DE LA EMPRESA O INSTITUCION
                    documento.add(new Paragraph("Para: " + empresa.getNombre_gerente(), estexto));
                    documento.add(salto_linea);

                    // C U  E R  P O   DE  D O C U M E N T O 
                    Paragraph cuerpo = new Paragraph("La Universidad Politécnica Salesiana solicita de la forma mas comedida que "
                            + "" + usuario.getNombre() + " " + usuario.getApellido() + ", con cédula de ciudadanía: " + usuario.getEstudiante().getCedula() + ", "
                            + " se le otorgue la oprtuninda de realizar la " + giveMeNamePPP(pasantia.getTipo_ppp()) + " dentro de sus "
                            + "instalaciones.", estexto);
                    cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
                    documento.add(cuerpo);

                    //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    ListaDocentesAdministrativos buscar_docadmin = new ListaDocentesAdministrativos();
                    documento.add(new Paragraph("Atentamente: " + buscar_docadmin.nombreDocenteAdministrativo(1), estexto));

                    //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
                    documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito ", estexto));

                    //FIRMA linea de firma
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(linea_firma);

                    //F I N  D O C U M E N T O 
                    documento.close();
                    exitoalguardar = true;
                } catch (DocumentException | IOException e) {
                    exitoalguardar = false;
                }
                break;
            case 102:
                //FORMATO CARTA DE ACEPTACION
                try {
                    FileOutputStream archivo = new FileOutputStream(local_path + cedula + "/" + numero_pdf + ".pdf");//asi se guardara el archivo
                    //FileOutputStream archivo = new FileOutputStream("E:\\"+cedula+"\\"+numero_pdf+".pdf");//asi se guardara el archivo
                    PdfWriter.getInstance(documento, archivo);
                    documento.open();

                    documento.addAuthor("Universidad Politecnica Salesiana");
                    Paragraph salto_linea = new Paragraph("\n");
                    Paragraph linea_firma = new Paragraph("________________", estexto);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    //F E C H A  DEL  S I S T E M A  
                    LocalTimeDate obtenerfecha = new LocalTimeDate();
                    Paragraph poner_fecha = new Paragraph("Fecha: Quito, " + obtenerfecha.fechaAnioMesDia(), estexto);
                    poner_fecha.setAlignment(Element.ALIGN_RIGHT);
                    documento.add(poner_fecha);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    // T I T U L O
                    Paragraph p1 = new Paragraph("CARTA DE ACEPTACIÓN", estitulo);
                    p1.setAlignment(Element.ALIGN_CENTER);
                    documento.add(p1);
                    documento.add(salto_linea);

                    //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    ListaDocentesAdministrativos buscar_docadmin = new ListaDocentesAdministrativos();
                    documento.add(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(1), estexto));

                    //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
                    documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito", estexto));

                    //SALUDO
                    documento.add(new Paragraph("Presente.-", estexto));
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(new Paragraph("De mis consideraciones:", estexto));
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    // C U  E R  P O   DE  D O C U M E N T O 
                    Paragraph cuerpo = new Paragraph("Por medio de la presente comunicamos a usted, la aceptación del estudiante "
                            + "" + usuario.getNombre() + " " + usuario.getApellido() + ", con cédula de ciudadanía: " + usuario.getEstudiante().getCedula() + ", "
                            + " para la ejecución de " + giveMeNamePPP(pasantia.getTipo_ppp()) + ", del " + pasantia.getFechaInicio() + " al " + pasantia.getFechaFin() + ".", estexto);
                    cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
                    documento.add(cuerpo);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    //RESPONSABLE / ENCARGADO DE LA EMPRESA
                    documento.add(linea_firma);
                    documento.add(new Paragraph("Atentamente, ", estexto));
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    //documento.add(new Paragraph("ID encargado: "+encargado.getId_encargado(),estexto));
                    documento.add(new Paragraph("Persona a cargo: " + encargado.getNombre_encargado(), estexto));//Nombre Responsableen la empresa 
                    documento.add(new Paragraph("Identificación: " + encargado.getCi_encargado(), estexto));//CEDULA  Nombre Responsable en la empresa NO es el ID
                    documento.add(new Paragraph("Cargo/Profesión: " + encargado.getCargo_encargado(), estexto));//Cargo dentro de la empresa 
                    documento.add(new Paragraph("RUC: " + encargado.getEmpresa().getId_empresa(), estexto));//RUC empresa donde trabaja encargado

                    //SELLO DE LA EMPRESA
                    documento.add(new Paragraph("Se requiere el sello de la empresa. ", esnota));
                    //F I N  D O C U M E N T O 
                    documento.close();
                    exitoalguardar = true;
                } catch (DocumentException | FileNotFoundException e) {
                    exitoalguardar = false;
                }
                break;
            case 103:
                //FORMATO CARTA COMPROMISO INTERINSTITUCIONAL
                try {
                    FileOutputStream archivo = new FileOutputStream(local_path + cedula + "/" + numero_pdf + ".pdf");//asi se guardara el archivo
                    PdfWriter.getInstance(documento, archivo);
                    documento.open();

                    //logo de la UPS
                    Image image = Image.getInstance(local_path_images + "logo-ups-home.png");
                    image.setAlignment(Image.ALIGN_LEFT);
                    image.setAbsolutePosition(10, 780);
                    image.scalePercent(60, 55);
                    documento.add(image);

                    Image image2 = Image.getInstance(local_path_images + "bkj2.png");
                    image2.setAlignment(Image.ALIGN_RIGHT);
                    image2.setAbsolutePosition(562, 458);
                    image2.scalePercent(60, 75);
                    documento.add(image2);

                    Image image3 = Image.getInstance(local_path_images + "batl.png");
                    image3.setAlignment(Image.ALIGN_RIGHT);
                    image3.setAbsolutePosition(445, 775);
                    image3.scalePercent(6, 6);
                    documento.add(image3);

                    documento.addAuthor("Universidad Politecnica Salesiana");
                    Paragraph salto_linea = new Paragraph("\n");
                    Paragraph linea_firma = new Paragraph("________________", estexto);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    // T I T U L O
                    Paragraph p1 = new Paragraph("FORMATO CARTA COMPROMISO INTERINSTITUCIONAL", estitulo);
                    p1.setAlignment(Element.ALIGN_CENTER);
                    documento.add(p1);
                    documento.add(salto_linea);

                    //                            SEPARAR POR SECCIONES
                    //SEC INFORMACION GENERAL
                    //https://developers.itextpdf.com/examples/tables/colspan-and-rowspan
                    documento.add(new Paragraph("INFORMACIÓN GENERAL", estexto));
                    documento.add(salto_linea);

                    //tabla 1
                    PdfPTable table = new PdfPTable(4);//# columns
                    //1 row
                    table.addCell(new Paragraph("CÓDIGO:", estexto));
                    table.addCell(new Paragraph("" + pasantia.getTipo_ppp() + " " + pasantia.getCod_ppp(), estexto));
                    table.addCell(new Paragraph("No.:", estexto));
                    table.addCell("XXXXXXXXXXXXXX");

                    //2 row
                    table.addCell(new Paragraph("NOMBRE DE LA EMPRESA O INSTITUCIÓN:", estexto));
                    cell = new PdfPCell(new Paragraph(empresa.getNombre_empresa(), estexto));
                    cell.setColspan(3);//total de celdas que va MERGE a esta FILA
                    table.addCell(cell);

                    //3 row
                    table.addCell(new Paragraph("DIRECCIÓN:", estexto));
                    table.addCell(new Paragraph(empresa.getDireccion_empresa(), estexto));
                    table.addCell(new Paragraph("TELÉFONO:", estexto));
                    table.addCell(new Paragraph(empresa.getTelefono_empresa(), estexto));

                    //4 row
                    table.addCell(new Paragraph("ACTIVIDAD PRINCIPAL DE LA EMPRESA O INSTITUCIÓN:", estexto));
                    cell = new PdfPCell(new Paragraph(usuario.getEstudiante().getActividadRealizar(), estexto));
                    cell.setColspan(3);//total de celdas que va MERGE a esta FILA
                    table.addCell(cell);

                    //5 row
                    table.addCell(new Paragraph("APELLIDOS Y NOMBRES DEL ESTUDIANTE:", estexto));
                    cell = new PdfPCell(new Paragraph(usuario.getApellido() + " " + usuario.getNombre(), estexto));
                    cell.setColspan(3);//total de celdas que va MERGE a esta FILA
                    table.addCell(cell);

                    //6 row
                    table.addCell(new Paragraph("CARRERA DE GRADO:", estexto));
                    table.addCell(new Paragraph("INGENIERÍA DE SISTEMAS", estexto));
                    table.addCell(new Paragraph("CICLO o SEMESTRE QUE CURSA:", estexto));
                    table.addCell(new Paragraph("" + usuario.getEstudiante().getUltimoNivel(), estexto));
                    documento.add(table);
                    //FIN TABLA 1

                    //SEC DESCRIPCIÓN ESTRATÉGICA DE INTERVENCIÓN
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    documento.add(new Paragraph("DESCRIPCIÓN ESTRATÉGICA DE INTERVENCIÓN", estexto));
                    documento.add(salto_linea);

//tabla 2
                    PdfPTable table2 = new PdfPTable(6);//# columns
                    //1 row
                    table2.addCell(new Paragraph("TIPO DE ACTIVIDAD ACADÉMICA:", estexto));
                    cell = new PdfPCell(new Paragraph(giveMeNamePPP(pasantia.getTipo_ppp()), estexto));
                    cell.setColspan(3);//total de celdas que va MERGE a esta FILA
                    table2.addCell(cell);
                    table2.addCell(new Paragraph("TOTAL HORAS:", estexto));
                    table2.addCell(new Paragraph("" + usuario.getEstudiante().getHorasPasantia(), estexto));

                    //2 row
                    table2.addCell(new Paragraph("OBJETO DE LA ACTIVIDAD ACADÉMICA:", estexto));

                    cell = new PdfPCell(new Paragraph(empresa.getNombre_empresa(), estexto));
                    cell.setColspan(3);//total de celdas que va MERGE a esta FILA
                    table2.addCell(cell);
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");
                    table2.addCell("XXXXXXXXXXXXXX");

                    documento.add(table2);
                    //FIN TABLA 2

                    //F I N  D O C U M E N T O 
                    documento.close();
                    exitoalguardar = true;
                } catch (DocumentException | IOException e) {
                    exitoalguardar = false;
                }

                break;
            case 104:
                //FORMATO DE INICIAR PASANTIAS EN LA EMPRESA / FORMATO SOLICITUD RESOLUCION
                try {
                    FileOutputStream archivo = new FileOutputStream(local_path + cedula + "/" + numero_pdf + ".pdf");//asi se guardara el archivo
                    //FileOutputStream archivo = new FileOutputStream("E:\\"+cedula+"\\"+numero_pdf+".pdf");//asi se guardara el archivo
                    PdfWriter.getInstance(documento, archivo);
                    documento.open();

                    documento.addAuthor("Universidad Politecnica Salesiana");
                    Paragraph salto_linea = new Paragraph("\n");
                    Paragraph linea_firma = new Paragraph("________________", estexto);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    //F E C H A  DEL  S I S T E M A  
                    LocalTimeDate obtenerfecha = new LocalTimeDate();
                    Paragraph poner_fecha = new Paragraph("Fecha: Quito, " + obtenerfecha.fechaAnioMesDia(), estexto);
                    poner_fecha.setAlignment(Element.ALIGN_RIGHT);
                    documento.add(poner_fecha);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    // T I T U L O
                    Paragraph p1 = new Paragraph("FORMATO SOLICITUD RESOLUCIÓN", estitulo);
                    p1.setAlignment(Element.ALIGN_CENTER);
                    documento.add(p1);
                    documento.add(salto_linea);

                    //nombre  DOCENTE, TUTOR, ADMINISTRATIVO
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    ListaDocentesAdministrativos buscar_docadmin = new ListaDocentesAdministrativos();
                    documento.add(new Paragraph(buscar_docadmin.nombreDocenteAdministrativo(1), estexto));

                    //ADICIONAL VA EL NOMBRE DE LA UNIVERSIDAD Y SEDE
                    documento.add(new Paragraph("Universidad Politécnica Salesiana, Sede Quito", estexto));

                    //SALUDO
                    documento.add(new Paragraph("Presente.-", estexto));
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(new Paragraph("De mis consideraciones:", estexto));
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    // C U  E R  P O   DE  D O C U M E N T O 
                    Paragraph cuerpo = new Paragraph("Yo," + usuario.getNombre() + " " + usuario.getApellido() + ", con cédula de ciudadanía: " + usuario.getEstudiante().getCedula() + ", "
                            + " solicito a Ud. la autorización del inicio de la actividad de " + giveMeNamePPP(pasantia.getTipo_ppp()) + ", en " + empresa.getNombre_empresa() + " "
                            + "desde " + pasantia.getFechaInicio() + " hasta " + pasantia.getFechaFin() + ".", estexto);
                    cuerpo.setAlignment(Element.ALIGN_JUSTIFIED);
                    documento.add(cuerpo);
                    documento.add(salto_linea);
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    //FIRMA ALUMNO
                    documento.add(linea_firma);
                    documento.add(new Paragraph("Atentamente, ", estexto));
                    documento.add(salto_linea);
                    documento.add(salto_linea);

                    documento.add(new Paragraph(usuario.getNombre() + " " + usuario.getApellido(), estexto));
                    documento.add(new Paragraph("" + usuario.getEstudiante().getCedula(), estexto));

                    //F I N  D O C U M E N T O 
                    documento.close();
                    exitoalguardar = true;
                } catch (DocumentException | FileNotFoundException e) {
                    exitoalguardar = false;
                }
                break;
            default:
                System.out.println("No se ha encontrado dentro del case el numero para crear el .PDF");
                exitoalguardar = false;
                break;
        }//end of SWITCH
        return exitoalguardar;
    }//fin metodo

    private String giveMeNamePPP(String nameppp) {
        if (nameppp.equals("PA")) {
            nameppp = "pasantía";
        }
        if (nameppp.equals("PP")) {
            nameppp = "práctica pre profesional";
        }
        return nameppp;
    }

}//end of class
