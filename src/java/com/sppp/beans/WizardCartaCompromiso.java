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
    
    List<Datos> datosCartaC = new LinkedList<>();
    boolean existe;
    
    public List<Datos> getDatosCartaC() {
        return datosCartaC;
    }
    
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
            
            
            //DEBO OBTENER EL DETALLE PASANTIA SOLO PARA BUSCAR LOS DATOS / EXISTE OTRA DETALLEPASANTIA MAS ABAJO
            DetallePasantia dpCargaDatos = new DetallePasantia();
            DetallePasantiaDAO dpDAOT = new DetallePasantiaDAO();
            dpCargaDatos = dpDAOT.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
            
            //Mandar a cargar la info si esta disponible en la DataBase de Datos
            
            DatosDAO datosDAO = new DatosDAO();
            existe = datosDAO.hayDatosDeDetallePasantia(dpCargaDatos.getIdDetallePasantia());
            
            //De acuerdo a si EXISTE se carga o NO Datos
            if(existe){
                obtenerDatosEstudiante(dpCargaDatos.getIdDetallePasantia());
            }else{
                
            }
            
        } catch (Exception e) {
            id = 0;
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
           
            
            
    }
    
    
    public String guardarDatos(){
        String redireccion = "revision_window";
        
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
        
        // SI EXISTE LA DETALLE PASANTIA HAY QUE GUARDARDATOS CASO CONTRARIO ACTUALIZARDATOS 
        if(existe){
           obj.actualizarDatosCartaCompromiso(usuario, empresa, encargado, pasantia, dp2, resp);
        }else{
            obj.datosGuardar(usuario, empresa, encargado, pasantia, dp2, resp);
        }
        
        
        
        //Mando a estado validar el registro en la DB
        dp2.setValidacion(EnumEstado.validar);
        dpDAO.actualizarDetallePasantia(dp2);
        
        
        //Incrementar cargo en la BD;
        
        //aqui llamar a crear la carta de compromiso
        return redireccion;
    }
    
    public void obtenerDatosEstudiante(int id) {
        
        DatosDAO dDAO = new DatosDAO();
        datosCartaC = dDAO.datosPorDetallePasantia(id);
        llenarDatosEstudiante();
    }
    
    public void llenarDatosEstudiante(){
        
        lugarFecha = datosCartaC.get(28).getValor_datos();
        
        objetoDeLaActividad = datosCartaC.get(11).getValor_datos();
        horarioPrevisto = datosCartaC.get(15).getValor_datos();
        nombrePrograma = datosCartaC.get(16).getValor_datos();
        areaAcademica = datosCartaC.get(17).getValor_datos();
        actividadPrevista = datosCartaC.get(19).getValor_datos();
        resultadosPrevistos = datosCartaC.get(20).getValor_datos();
        productosEntregables = datosCartaC.get(21).getValor_datos();
        
    }
    
}//fin de la clase
