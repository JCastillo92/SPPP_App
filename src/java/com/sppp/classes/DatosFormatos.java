/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.CampoDAO;
import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.DAO.PasantiaPracticaDAO;
import com.sppp.DAO.PeriodoDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.DAO.WizardDAO;
import com.sppp.beans.Campo;
import com.sppp.beans.Empresa;
import com.sppp.beans.Encargado;
import com.sppp.beans.Estudiante;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Periodo;
import com.sppp.beans.Usuario;
import com.sppp.utils.SessionUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author KarenVanessaAchigGua
 */
@Named(value = "datosFormatos")
@SessionScoped
public class DatosFormatos implements Serializable {
    
    private List<Usuario> usuario;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Usuario> getUsuario(long id) {
         
        CitasDao citasdao=new CitasDaoImp();
        this.usuario=citasdao.findUser(id);
       
        return usuario;
    }
    
    
    
}

    

