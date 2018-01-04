/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class PasswordRestoration {
    private String email;
    private Long identification;

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String sendMePasswd(){
        String retorno="/public/login";
        try {
          Cls_OutOfSystem llama=new Cls_OutOfSystem();
          llama.findUsuarioEmail(email,identification);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }
}
