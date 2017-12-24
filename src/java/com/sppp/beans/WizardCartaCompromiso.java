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
        } catch (Exception e) {
            id = 0;
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
           
            /////LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(id);
            
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
            
    }
}//fin de la clase
