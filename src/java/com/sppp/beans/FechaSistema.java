/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author
 */
@ManagedBean(name="fechaSistema")
@SessionScoped
public class FechaSistema {

      

public String fecha(){
     Date fechaSis = new Date();
      
        SimpleDateFormat sisFecha = new SimpleDateFormat("dd-MM-yyyy");  
      //System.out.println(sisFecha.format(fechaSis));
           return sisFecha.format(fechaSis);  
}
    
  
     
  
  
}
  


