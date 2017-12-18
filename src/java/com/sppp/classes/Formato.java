/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author KarenVanessaAchigGua
 */
@Named(value = "formato")
@SessionScoped
public class Formato implements Serializable {

   private String id;
   
    public Formato() {
   
        
      
    }
    public String outcome(){

		FacesContext fc = FacesContext.getCurrentInstance();
		this.id = getIdParam(fc);

		return "result";
	}

    public String getIdParam(FacesContext fc) {
     
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("id");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
