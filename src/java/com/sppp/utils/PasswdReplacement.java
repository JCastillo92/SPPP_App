/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import com.sppp.DAO.UsuarioDAO;
import com.sppp.classes.ChangePassword;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class PasswdReplacement {
    private String passMain;
    private String pass1;
    private String pass2;
    private boolean verdadPass;

    public boolean isVerdadPass() {
        return verdadPass;
    }

    public void setVerdadPass(boolean verdadPass) {
        this.verdadPass = verdadPass;
    }

    public String getPassMain() {
        return passMain;
    }

    public void setPassMain(String passMain) {
        this.passMain = passMain;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

 

   
    
    
    
      public String cambiarPassword(){
        long id=0;
        int perfil=0;
        String retorno="/public/login";
        try {
            HttpSession session = SessionUtils.getSession();
                id = (long) session.getAttribute("id");
                perfil= (int) session.getAttribute("perfil");
                
                if(id != 0){
                    if(pass1.equals(pass2)){
                        ChangePassword objPass=new ChangePassword();
                        verdadPass=objPass.setNewPasswd(id,passMain,pass1);
                        if(verdadPass){
                            switch(perfil){
                                case 1://estudiante
                                        retorno="dashboard_est";
                                break;
                                case 2://gestor
                                        retorno="dashboard_gestor";
                                break;
                                case 4://consejo
                                        retorno="dashboard_consejo";
                                break;
                                case 5://secretaria
                                    retorno="dashboard_secretaria";
                                    break;
                                default:
                                    break;
                            }
                        }
                    }else{
                        verdadPass=false;
                        switch(perfil){
                                case 1://estudiante
                                        retorno="estChPas";
                                break;
                                case 2://gestor
                                        retorno="gestChPas";
                                break;
                                case 4://consejo
                                        retorno="";
                                break;
                                case 5://secretaria
                                    retorno="";
                                    break;
                                default:
                                    break;
                            }
                    }
                }else{
                    retorno="/public/login";
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
