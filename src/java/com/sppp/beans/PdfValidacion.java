/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DatosDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.mailing.MailingMain;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
@ViewScoped
public class PdfValidacion {
private MailingMain email_aprobado=new MailingMain();
    int id_estudiante;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    private List<Datos> datosCartaC = new LinkedList<>();
    private DetallePasantia dp2 = new DetallePasantia();
    private Usuario usuario = new Usuario();
    private Pasantia pasantia = new Pasantia();

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    private boolean archivo1;
    private boolean archivo2;
    private boolean archivo3;
    private boolean archivo4;

    public boolean isArchivo1() {
        return archivo1;
    }

    public void setArchivo1(boolean archivo1) {
        this.archivo1 = archivo1;
    }

    public boolean isArchivo2() {
        return archivo2;
    }

    public void setArchivo2(boolean archivo2) {
        this.archivo2 = archivo2;
    }

    public boolean isArchivo3() {
        return archivo3;
    }

    public void setArchivo3(boolean archivo3) {
        this.archivo3 = archivo3;
    }

    public boolean isArchivo4() {
        return archivo4;
    }

    public void setArchivo4(boolean archivo4) {
        this.archivo4 = archivo4;
    }

    public void init() {

        //Encuentro el detalle de esa pasantia
        UsuarioDAO uDAO = new UsuarioDAO();
        usuario = uDAO.findUsuario(id_estudiante);

        PasantiaDAO passDAO = new PasantiaDAO();
        pasantia = passDAO.findPasantia(id_estudiante);

        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
        
        //Busco los datos segun el detallePasantia dado, debe si o si estar en el proceso adecuado
        //o traera data erronea
        obtenerDatosEstudiante(dp2.getIdDetallePasantia());

    }
    
    public void obtenerDatosEstudiante(int id) {
        
        DatosDAO dDAO = new DatosDAO();
        datosCartaC = dDAO.datosPorDetallePasantia(id);
        llenarDatosEstudiante();
    }
    
    public void llenarDatosEstudiante(){
        
        //Zona checkbox
        archivo1  = datosCartaC.get(0).isEstado();
        archivo2  = datosCartaC.get(1).isEstado();
        archivo3 = datosCartaC.get(2).isEstado();
        archivo4 = datosCartaC.get(3).isEstado();
        //FIN ZONA CHECKBOX
    }
    
    public String guardarDatos(){
        
        List<Datos> lDatos = new LinkedList<>();
        lDatos.add(new Datos(datosCartaC.get(0).getId_tbdatos(),datosCartaC.get(0).getValor_datos() ,datosCartaC.get(0).getDetallePasantias(),new Respuesta(48), archivo1));
        lDatos.add(new Datos(datosCartaC.get(1).getId_tbdatos(),datosCartaC.get(1).getValor_datos() ,datosCartaC.get(1).getDetallePasantias(),new Respuesta(49), archivo2));
        lDatos.add(new Datos(datosCartaC.get(2).getId_tbdatos(),datosCartaC.get(2).getValor_datos() ,datosCartaC.get(2).getDetallePasantias(),new Respuesta(50), archivo3));
        lDatos.add(new Datos(datosCartaC.get(3).getId_tbdatos(),datosCartaC.get(3).getValor_datos() ,datosCartaC.get(3).getDetallePasantias(),new Respuesta(51), archivo4));
        
        //Mando a guardar los datos
        DatosDAO dDAO = new DatosDAO();
        dDAO.guardarValidacionCC(lDatos);
        
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        //Compruebo si cumple todos los checks
        if(archivo1 && archivo2 && archivo3 && archivo4){
            
            dp2.setValidacion(EnumEstado.aprobar);
            dp2.setEstado(false);
            dp2.setObservacion(null);
            dpDAO.actualizarDetallePasantia(dp2);
            
            //envio email al estudiante de aprobado
            email_aprobado.mensajes(2, usuario.getCorreo(), "vacio");
            
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Resolucion de Proceso");
            dp3.setEstado(true);
            dp3.setPasantia(pasantia);
            dp3.setProceso(new Proceso(16));
            dp3.setValidacion(EnumEstado.validar);
            dpDAO.insertarNuevoDetalle(dp3);
        }else{
            
            //Cambio solo el campo Validacion
            dp2.setValidacion(EnumEstado.llenar);
            dp2.setObservacion(observacion);
            dpDAO.actualizarDetallePasantia(dp2);
            
            //envio email al estudiante de correccion
            email_aprobado.mensajes(1, usuario.getCorreo(), "vacio");
        }
        
        return "dashboard_gestor";
    }

}
