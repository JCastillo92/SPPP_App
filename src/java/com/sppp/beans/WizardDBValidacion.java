/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.PasantiaPracticaDAO;
import com.sppp.DAO.UsuarioDAO;
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
public class WizardDBValidacion extends WizardDB {

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

    }
    
    public String guardarDatos(){
        
        return "dashboard_est";
    }

}
