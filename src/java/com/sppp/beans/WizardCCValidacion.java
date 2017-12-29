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
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KRUGER
 */
@ManagedBean
//@ViewScoped
public class WizardCCValidacion extends WizardCC {

    @ManagedProperty(value = "#{param.id}")
    int id_estudiante;
    
    List<Datos> datosCartaC = new LinkedList<>();

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    

    public WizardCCValidacion() {

        try {
            
            /////LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
 /*           UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_estudiante);

            PasantiaDAO passDAO = new PasantiaDAO();
            pasantia = passDAO.findPasantia(id_estudiante);

            EncargadoDAO encarDAO = new EncargadoDAO();
            encargado = encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());

            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa = empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());

            DetallePasantia dp2 = new DetallePasantia();
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
            dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
            
            obtenerDatosEstudiante(dp2.getIdDetallePasantia());
*/
        } catch (Exception e) {
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
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
    
    public void init(){
        System.out.println("========== "+id_estudiante);
        
        UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_estudiante);

            PasantiaDAO passDAO = new PasantiaDAO();
            pasantia = passDAO.findPasantia(id_estudiante);

            EncargadoDAO encarDAO = new EncargadoDAO();
            encargado = encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());

            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa = empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
            DetallePasantia dp2 = new DetallePasantia();
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
            dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
            
            obtenerDatosEstudiante(dp2.getIdDetallePasantia());
        
    }
    
    public void guardarDatos(){
        
    }

}
