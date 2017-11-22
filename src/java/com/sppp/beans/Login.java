/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.LoginDAO;
import com.sppp.utils.SessionUtils;
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
    
    //Metodo Validacion
    public String validateUser(){
        boolean valid = LoginDAO.validate(user, pwd);
        if (valid){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "student";
        }else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }
    
    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }
    
}
