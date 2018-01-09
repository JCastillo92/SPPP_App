/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.LoginDAO;
import com.sppp.DAO.VisitaDAO;
import com.sppp.utils.SessionUtils;
import com.sppp.classes.Cls_PerfilNotation;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    private String pwd;
    private String msg;
    private String user;
    private String perfil;
    private String nombre="";
    private String apellido="";
    private String nombreCompleto="";

    public String getNombreCompleto() {
        nombreCompleto = nombre+" "+apellido;
        return nombreCompleto;
    }

    
    
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    //Metodo Validacion
    public String validateUser(){
     
        Usuario usuario = LoginDAO.validate(user, pwd);
        if (usuario != null){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            session.setAttribute("perfil", usuario.getPerfil().getId_tbperfil());
            session.setAttribute("id", usuario.getId_cedula());
            //Capturar el perfil 
            int perfil = (int) session.getAttribute("perfil");
            Cls_PerfilNotation obj1= new Cls_PerfilNotation();
            
                        
            //Capturo nombre y apellido
            nombre = usuario.getNombre();
            apellido = usuario.getApellido();
            if (obj1.perfilChooser(perfil).equals("Estudiante")){
                return "/user/estudiantes/dashboard_est.xhtml";
            }else if (obj1.perfilChooser(perfil).equals("Gestor")){
                return "/user/gestores/dashboard_gestor.xhtml";
            }else if(obj1.perfilChooser(perfil).equals("Tutor")){
                return "/user/tutor/tutor.xhtml";
            }else if(obj1.perfilChooser(perfil).equals("Consejo")){
                return "/user/consejo/dashboard_consejo.xhtml";
            }else if(obj1.perfilChooser(perfil).equals("Secretaria")){
                return "/user/secretaria/dashboard_secretaria.xhtml";
            }else if(obj1.perfilChooser(perfil).equals("Coordinador")){
                return "/user/coordinador/coordinator.xhtml";
            }else if(obj1.perfilChooser(perfil).equals("Administrador")){
                return "/user/administrador/administrator.xhtml";
            }
            
            //NO DEBERIA LLEGAR
            return "/public/login";
            
        }else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "/public/login";
        }
    }
    
    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/public/login";
    }
    
}
