/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DatosDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.PasantiaPracticaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.mailing.MailingMain;
import com.sppp.utils.SessionUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
@ViewScoped
public class WizardDBValidacion extends WizardDB {
    
    List<Datos> datosBasicos = new LinkedList<>();
    DetallePasantia dp = new DetallePasantia();
    MailingMain email_aprobado=new MailingMain();
    String observacion;
    private Usuario usuarioActual= new Usuario();//jairo

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    private boolean validar1;
    private boolean validar2;
    private boolean validar3;
    private boolean validar4;
    private boolean validar5;
    private boolean validar6;
    private boolean validar7;
    private boolean validar8;
    private boolean validar9;
    private boolean validar10;
    
    private boolean validar11;
    private boolean validar12;
    private boolean validar13;
    private boolean validar14;
    private boolean validar15;
    private boolean validar16;
    private boolean validar17;
    private boolean validar18;
    
    private String fechaInicioHelper;
    private String fechaFinHelper;

    public String getFechaInicioHelper() {
        return fechaInicioHelper;
    }

    public void setFechaInicioHelper(String fechaInicioHelper) {
        this.fechaInicioHelper = fechaInicioHelper;
    }

    public String getFechaFinHelper() {
        return fechaFinHelper;
    }

    public void setFechaFinHelper(String fechaFinHelper) {
        this.fechaFinHelper = fechaFinHelper;
    }
    
    

    public boolean isValidar1() {
        return validar1;
    }

    public void setValidar1(boolean validar1) {
        this.validar1 = validar1;
    }

    public boolean isValidar2() {
        return validar2;
    }

    public void setValidar2(boolean validar2) {
        this.validar2 = validar2;
    }

    public boolean isValidar3() {
        return validar3;
    }

    public void setValidar3(boolean validar3) {
        this.validar3 = validar3;
    }

    public boolean isValidar4() {
        return validar4;
    }

    public void setValidar4(boolean validar4) {
        this.validar4 = validar4;
    }

    public boolean isValidar5() {
        return validar5;
    }

    public void setValidar5(boolean validar5) {
        this.validar5 = validar5;
    }

    public boolean isValidar6() {
        return validar6;
    }

    public void setValidar6(boolean validar6) {
        this.validar6 = validar6;
    }

    public boolean isValidar7() {
        return validar7;
    }

    public void setValidar7(boolean validar7) {
        this.validar7 = validar7;
    }

    public boolean isValidar8() {
        return validar8;
    }

    public void setValidar8(boolean validar8) {
        this.validar8 = validar8;
    }

    public boolean isValidar9() {
        return validar9;
    }

    public void setValidar9(boolean validar9) {
        this.validar9 = validar9;
    }

    public boolean isValidar10() {
        return validar10;
    }

    public void setValidar10(boolean validar10) {
        this.validar10 = validar10;
    }

    public boolean isValidar11() {
        return validar11;
    }

    public void setValidar11(boolean validar11) {
        this.validar11 = validar11;
    }

    public boolean isValidar12() {
        return validar12;
    }

    public void setValidar12(boolean validar12) {
        this.validar12 = validar12;
    }

    public boolean isValidar13() {
        return validar13;
    }

    public void setValidar13(boolean validar13) {
        this.validar13 = validar13;
    }

    public boolean isValidar14() {
        return validar14;
    }

    public void setValidar14(boolean validar14) {
        this.validar14 = validar14;
    }

    public boolean isValidar15() {
        return validar15;
    }

    public void setValidar15(boolean validar15) {
        this.validar15 = validar15;
    }

    public boolean isValidar16() {
        return validar16;
    }

    public void setValidar16(boolean validar16) {
        this.validar16 = validar16;
    }

    public boolean isValidar17() {
        return validar17;
    }

    public void setValidar17(boolean validar17) {
        this.validar17 = validar17;
    }

    public boolean isValidar18() {
        return validar18;
    }

    public void setValidar18(boolean validar18) {
        this.validar18 = validar18;
    }

    int id_estudiante;
    List<Datos> datosWizard = new LinkedList<>();

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public List<Datos> getDatosWizard() {
        return datosWizard;
    }

    public WizardDBValidacion() {
    }
    

    public void init() {

        //Recupero el Usuario
        UsuarioDAO uDAO = new UsuarioDAO();
        usuario = uDAO.findUsuario(id_estudiante);
        
        //Recupero su pasantia
        PasantiaDAO ppDAO = new PasantiaDAO();
        p = ppDAO.findPasantia(id_estudiante);
        
        //Encuentro el encargado
        EncargadoDAO encDAO = new EncargadoDAO();
        enc = encDAO.findEncargado(p.getEncargado().getId_encargado());
        
        //Encontrar la empresa
        EmpresaDAO empDAO = new EmpresaDAO();
        emp = empDAO.findEmpresa(enc.getEmpresa().getId_empresa());
        
        
        //Encontramos el detalle de esa pasantia cuyo proceso sea 1
        
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        dp= dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),1);
        
        //Encontras los VISTOS de las preguntas
        obtenerDatosEstudiante(dp.getIdDetallePasantia());
        //Asignar a los checkbox
        llenarDatosEstudiante();
        
        //Lleno la observacion
        observacion = dp.getObservacion();

    }
    
    public void obtenerDatosEstudiante(int id) {
        
        DatosDAO dDAO = new DatosDAO();
        datosBasicos = dDAO.datosPorDetallePasantia(id);

    }
    
    public void llenarDatosEstudiante(){
        
        
        /* SI TUVIERA CAMPOS NO DISPONIBLES EN LA DB
        lugarFecha = datosBasicos.get(28).getValor_datos();
        
        objetoDeLaActividad = datosBasicos.get(11).getValor_datos();
        horarioPrevisto = datosBasicos.get(15).getValor_datos();
        nombrePrograma = datosBasicos.get(16).getValor_datos();
        areaAcademica = datosBasicos.get(17).getValor_datos();
        actividadPrevista = datosBasicos.get(19).getValor_datos();
        resultadosPrevistos = datosBasicos.get(20).getValor_datos();
        productosEntregables = datosBasicos.get(21).getValor_datos();
        */
        //Zona checkbox ---- RECORDAR QUE LOS ARRAYS COMIENZAN EN CERO ----
        
        fechaInicioHelper = datosBasicos.get(7).getValor_datos();
        fechaFinHelper = datosBasicos.get(8).getValor_datos();
        /*INTENTO DE CONVERTIR LA FECHA*/
        int day;
        int month;
        int year;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(p.getFechaInicio());
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);

        //Formateo si la fecha me regresa solo 1 para que quede 01
        String formatted = String.format("%02d", month);
        String formatted2 = String.format("%02d", day);
        fechaInicioHelper = year + "/" + formatted + "/" + formatted2;
        
        cal.setTime(p.getFechaFin());
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        //Formateo si la fecha me regresa solo 1 para que quede 01
        formatted = String.format("%02d", month);
        formatted2 = String.format("%02d", day);
        fechaFinHelper = year + "/" + formatted + "/" + formatted2;

        validar3 = datosBasicos.get(2).isEstado();
        validar4 = datosBasicos.get(3).isEstado();
        validar6 = datosBasicos.get(5).isEstado();
        validar8 = datosBasicos.get(7).isEstado();
        validar9 = datosBasicos.get(8).isEstado();
        
        validar10 = datosBasicos.get(9).isEstado();
        validar11 = datosBasicos.get(10).isEstado();
        validar12 = datosBasicos.get(11).isEstado();
        validar13 = datosBasicos.get(12).isEstado();
        validar14 = datosBasicos.get(13).isEstado();
        validar15 = datosBasicos.get(14).isEstado();
        validar16 = datosBasicos.get(15).isEstado();
        validar17 = datosBasicos.get(16).isEstado();
        validar18 = datosBasicos.get(17).isEstado();
                
        //FIN ZONA CHECKBOX
    }
    
    public String guardarDatos(){
        try {
            
       
        //3 - 4 - 6 - 8 -9
        
        // 10 - 18
        
        //Obtener los datos guardados en la BD 
        //obtenerDatosEstudiante(dp.getIdDetallePasantia());
        
        //Asignar T/F segun los checkbox que se inicien
        List<Datos> lDatos = new LinkedList<>();
        lDatos.add(new Datos(datosBasicos.get(2).getId_tbdatos(),datosBasicos.get(2).getValor_datos() ,datosBasicos.get(2).getDetallePasantias(),new Respuesta(32), validar3));
        lDatos.add(new Datos(datosBasicos.get(3).getId_tbdatos(),datosBasicos.get(3).getValor_datos() ,datosBasicos.get(3).getDetallePasantias(),new Respuesta(33), validar4));
        lDatos.add(new Datos(datosBasicos.get(5).getId_tbdatos(),datosBasicos.get(5).getValor_datos() ,datosBasicos.get(5).getDetallePasantias(),new Respuesta(35), validar6));
        lDatos.add(new Datos(datosBasicos.get(7).getId_tbdatos(),datosBasicos.get(7).getValor_datos() ,datosBasicos.get(7).getDetallePasantias(),new Respuesta(37), validar8));
        lDatos.add(new Datos(datosBasicos.get(8).getId_tbdatos(),datosBasicos.get(8).getValor_datos() ,datosBasicos.get(8).getDetallePasantias(),new Respuesta(38), validar9));
        lDatos.add(new Datos(datosBasicos.get(9).getId_tbdatos(),datosBasicos.get(9).getValor_datos() ,datosBasicos.get(9).getDetallePasantias(),new Respuesta(39), validar10));
        lDatos.add(new Datos(datosBasicos.get(10).getId_tbdatos(),datosBasicos.get(10).getValor_datos() ,datosBasicos.get(10).getDetallePasantias(),new Respuesta(40), validar11));
        lDatos.add(new Datos(datosBasicos.get(11).getId_tbdatos(),datosBasicos.get(11).getValor_datos() ,datosBasicos.get(11).getDetallePasantias(),new Respuesta(41), validar12));
        lDatos.add(new Datos(datosBasicos.get(12).getId_tbdatos(),datosBasicos.get(12).getValor_datos() ,datosBasicos.get(12).getDetallePasantias(),new Respuesta(42), validar13));
        lDatos.add(new Datos(datosBasicos.get(13).getId_tbdatos(),datosBasicos.get(13).getValor_datos() ,datosBasicos.get(13).getDetallePasantias(),new Respuesta(43), validar14));
        lDatos.add(new Datos(datosBasicos.get(14).getId_tbdatos(),datosBasicos.get(14).getValor_datos() ,datosBasicos.get(14).getDetallePasantias(),new Respuesta(44), validar15));
        lDatos.add(new Datos(datosBasicos.get(15).getId_tbdatos(),datosBasicos.get(15).getValor_datos() ,datosBasicos.get(15).getDetallePasantias(),new Respuesta(45), validar16));
        lDatos.add(new Datos(datosBasicos.get(16).getId_tbdatos(),datosBasicos.get(16).getValor_datos() ,datosBasicos.get(16).getDetallePasantias(),new Respuesta(46), validar17));
        lDatos.add(new Datos(datosBasicos.get(17).getId_tbdatos(),datosBasicos.get(17).getValor_datos() ,datosBasicos.get(17).getDetallePasantias(),new Respuesta(47), validar18));

        //Guardar en la DB
        DatosDAO dDAO = new DatosDAO();
        dDAO.guardarValidacionCC(lDatos);
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        //Comparacion para APROBAR O INGRESAR DE NUEVO
        if(validar3 && validar4 && validar6 && validar8 && validar9 && validar10 && validar11
                && validar12 && validar13 && validar14 && validar15 && validar16 && validar17 && validar18){
            
            
            /// ESTE CODIGO PERRY -------------------------
            dp.setValidacion(EnumEstado.aprobar);
            dp.setEstado(false);
            dp.setObservacion(null);
            dpDAO.actualizarDetallePasantia(dp);
            
            //preparo datos del USUARIO LOGUEADO (GESTOR)
            HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");
                UsuarioDAO uDAO = new UsuarioDAO();
                usuarioActual = uDAO.findUsuario(id);
            
            //envio email al estudiante de aprobado
            email_aprobado.mensajes(2, usuario.getCorreo(), "\n\nAtentamente:\n"+usuarioActual.getApellido()+" "+usuarioActual.getNombre()+"");
            
            
            //Paso a agregar el nuevo proceso 11
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Descargar/Subir Oficio");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(4));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
        }else{
            //Cambio solo el campo Validacion
            dp.setValidacion(EnumEstado.llenar);
            dp.setObservacion(observacion);
            dpDAO.actualizarDetallePasantia(dp);
            
            
            //preparo datos del USUARIO LOGUEADO (GESTOR)
            HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");
                UsuarioDAO uDAO = new UsuarioDAO();
                usuarioActual = uDAO.findUsuario(id);
                
            //envio email al estudiante de correccion
            email_aprobado.mensajes(1, usuario.getCorreo(), observacion+"\n\nAtentamente:\n"+usuarioActual.getApellido()+" "+usuarioActual.getNombre()+"");
            
        }
         } catch (Exception e) {
             e.printStackTrace();
        }
        return "dashboard_gestor";
    }
    
    

}
