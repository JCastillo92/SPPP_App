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
import com.sppp.DAO.UsuarioDAO;
import com.sppp.utils.SessionUtils;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
@ManagedBean
@ViewScoped
public class WizardCartaCompromiso extends WizardCC {
    
    
    public WizardCartaCompromiso(){
        
        //Datos Quemados Generales
        
        /*delegadoUPS="Lola Vazquez";;
        cargoDelegado="Directora Técnica de Vinculación UPS";
        telefonoDelegado="3962800 Ext.-2167";
        FechaSistema fc = new FechaSistema();
        lugarFecha= "Quito,  "+fc.fecha(); //Quito, 30-10-1992;
        cargo = "Gerente";
        */
        
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
        String redireccion = "dashboard_est";
        
        //Recolectando la informacion
        pasantia.getTipo_ppp();
        pasantia.getCod_ppp();
        empresa.getNombre_empresa();
        empresa.getDireccion_empresa();
        empresa.getTelefono_empresa();
        empresa.getActividad_principal_empresa();
        
        //Recolectando info estudiante
        usuario.getApellido();
        usuario.getNombre();
        
        usuario.getEstudiante().getUltimoNivel();
        
        
        
        //carrera-grado objetoDeLaActividad - horarioPrevisto - nombrePrograma - areaAcademica - actividadPrevista - resultadosPrevistos - TutorXXX - cargo
        usuario.getEstudiante().getHorasPasantia();
        pasantia.getFechaInicio();
        pasantia.getFechaFin();
        
        encargado.getNombre_encargado();
        //Nombre Gerente
        empresa.getNombre_gerente();
        
        //Generando LISTA DE RESPUESTAS solo de los Strings
        /*
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
                private String lugarFecha;*/
        List<String> resp = new LinkedList<>();
        resp.add(carrera_grado);//0
        resp.add(tipo_actividad_academica);//1
        resp.add(objetoDeLaActividad);//2
        resp.add(horarioPrevisto);//3
        resp.add(nombrePrograma);//4
        resp.add(areaAcademica);//5
        resp.add(actividadPrevista);//6
        resp.add(resultadosPrevistos);//7
        resp.add(productosEntregables);//8
        resp.add(cargo);//9
        resp.add(delegadoUPS);//10
        resp.add(cargoDelegado);//11
        resp.add(telefonoDelegado);//12
        resp.add(lugarFecha);//13
        
        //Obtener idDetallePasantia
        DetallePasantia dp2 = new DetallePasantia();
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
        
        //Guardar en la tb_datos;
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+dp2.getIdDetallePasantia());
        DatosDAO obj = new DatosDAO();
        obj.datosGuardar(usuario, empresa, encargado, pasantia, dp2, resp);
        
        
        //Incrementar cargo en la BD;
        
        //aqui llamar a crear la carta de compromiso
        return redireccion;
    }
    
    
}//fin de la clase
