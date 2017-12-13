/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.beans.Login;
import com.sppp.beans.VisitaTutor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "confirmaCita")

public class ConfirmaCita {

    private List<VisitaTutor> visitas;
    private Login login;
    
    public ConfirmaCita() {
        this.visitas= new ArrayList<VisitaTutor>();
        
    }

    public List<VisitaTutor> getVisitas(String id) {
        
        CitasDao citasdao=new CitasDaoImp();
        this.visitas=citasdao.confirma(id);
        return visitas;
       
    }
    
    
}
