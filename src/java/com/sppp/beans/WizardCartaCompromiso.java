/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.utils.SessionUtils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
@ManagedBean
@ViewScoped
public class WizardCartaCompromiso {
    //invocacion a clases que debo usar para obtener los datos
                private Usuario usuario = new Usuario();//jairo
                private Pasantia pasantia=new Pasantia();//jairo
                private Encargado encargado=new Encargado();//jairo
                private Empresa empresa=new Empresa();//jairo
                
                //Campo Oculto
                private String carrera_grado;
                private String tipo_actividad_academica;
                private String objetoDeLaActividad;
                private String horarioPrevisto;
                private String nombrePrograma;
                private String areaAcademica;
                private String actividadPrevista;
                private String resultadosPrevistos;
                private String productosEntregables;
                private String cargo;
                private String delegadoUPS;
                private String cargoDelegado;
                private String telefonoDelegado;
                private String lugarFecha;

    public String getLugarFecha() {
        FechaSistema fc = new FechaSistema();
        
        lugarFecha = "Quito,  "+fc.fecha(); //Quito, 30-10-1992
        return lugarFecha;
    }

    public void setLugarFecha(String lugarFecha) {
        this.lugarFecha = lugarFecha;
    }

    public String getTelefonoDelegado() {
        telefonoDelegado = "3962800 Ext.-2167";
        return telefonoDelegado;
    }

    public void setTelefonoDelegado(String telefonoDelegado) {
        this.telefonoDelegado = telefonoDelegado;
    }

    public String getCargoDelegado() {
        cargoDelegado = "Directora Técnica de Vinculación UPS";
        return cargoDelegado;
    }

    public void setCargoDelegado(String cargoDelegado) {
        this.cargoDelegado = cargoDelegado;
    }

    public String getDelegadoUPS() {
        delegadoUPS = "Lola Vazquez";
        return delegadoUPS;
    }

    public void setDelegadoUPS(String delegadoUPS) {
        this.delegadoUPS = delegadoUPS;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
                
                //Cambiar Tutor
                private String tutorXXX;

    public String getTutorXXX() {
        return tutorXXX;
    }

    public void setTutorXXX(String tutorXXX) {
        this.tutorXXX = tutorXXX;
    }
                

    public String getProductosEntregables() {
        return productosEntregables;
    }

    public void setProductosEntregables(String productosEntregables) {
        this.productosEntregables = productosEntregables;
    }

    public String getResultadosPrevistos() {
        return resultadosPrevistos;
    }

    public void setResultadosPrevistos(String resultadosPrevistos) {
        this.resultadosPrevistos = resultadosPrevistos;
    }

    public String getActividadPrevista() {
        return actividadPrevista;
    }

    public void setActividadPrevista(String actividadPrevista) {
        this.actividadPrevista = actividadPrevista;
    }

    public String getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(String areaAcademica) {
        this.areaAcademica = areaAcademica;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
                

    public String getHorarioPrevisto() {
        return horarioPrevisto;
    }

    public void setHorarioPrevisto(String horarioPrevisto) {
        this.horarioPrevisto = horarioPrevisto;
    }
                
                

    public String getObjetoDeLaActividad() {
        return objetoDeLaActividad;
    }

    public void setObjetoDeLaActividad(String objetoDeLaActividad) {
        this.objetoDeLaActividad = objetoDeLaActividad;
    }
                

    public String getTipo_actividad_academica() {
        if(pasantia.getTipo_ppp().equals("PA")){
            tipo_actividad_academica="pasantía";
        }
        if(pasantia.getTipo_ppp().equals("PP")){
            tipo_actividad_academica="práctica pre profesional";
        }
        return tipo_actividad_academica;
    }

    public void setTipo_actividad_academica(String tipo_actividad_academica) {
        this.tipo_actividad_academica = tipo_actividad_academica;
    }

    

    public String getCarrera_grado() {
        carrera_grado = "Ingenieria de Sistemas";
        return carrera_grado;
    }

    public void setCarrera_grado(String carrera_grado) {
        this.carrera_grado = carrera_grado;
    }
                

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pasantia getPasantia() {
        return pasantia;
    }

    public void setPasantia(Pasantia pasantia) {
        this.pasantia = pasantia;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public WizardCartaCompromiso(){
        
        
        //Obteniendo el Usuario del Sistema
        HttpSession session = SessionUtils.getSession();
        long id;
        try {
            id = (long) session.getAttribute("id");
            /////LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(id);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
        } catch (Exception e) {
            id = 0;
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
           
            
            
    }
    
    
    public String guardarDatos(){
        String redireccion = "dashboard";
        
        //Recolectando la informacion
        pasantia.getTipo_ppp();
        pasantia.getCod_ppp();
        empresa.getNombre_empresa();
        empresa.getDireccion_empresa();
        empresa.getTelefono_empresa();
        empresa.getActividad_principal_empresa();
        
        //Recolectando info estudiante
        usuario.getNombre();
        usuario.getApellido();
        usuario.getEstudiante().getUltimoNivel();
        
        
        
        //carrera-grado objetoDeLaActividad - horarioPrevisto - nombrePrograma - areaAcademica - actividadPrevista - resultadosPrevistos - TutorXXX - cargo
        usuario.getEstudiante().getHorasPasantia();
        pasantia.getFechaInicio();
        pasantia.getFechaFin();
        
        encargado.getNombre_encargado();
        //Nombre Gerente
        empresa.getNombre_gerente();
        
        //Generando LISTA DE RESPUESTAS
        
        
        //Obtener idDetallePasantia
        
        
        //Guardar en la tb_datos;
        
        
        //Incrementar cargo en la BD;
        
        
        return redireccion;
    }
    
    
}//fin de la clase
