/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.CampoDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.DAO.WizardDAO;
import com.sppp.utils.SessionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
@ViewScoped
public class UserWizard implements Serializable{
    
    private Usuario usuario = new Usuario();
    private Estudiante est = new Estudiante();
    private Empresa emp = new Empresa();
    private Encargado enc = new Encargado();
    Pasantia p = new Pasantia();
    private String tipo_p;

    public Pasantia getP() {
        return p;
    }

    public void setP(Pasantia p) {
        this.p = p;
    }

    public String getTipo_p() {
        return tipo_p;
    }

    public void setTipo_p(String tipo_p) {
        this.tipo_p = tipo_p;
    }
    private boolean skip;

    public Encargado getEnc() {
        return enc;
    }

    public void setEnc(Encargado enc) {
        this.enc = enc;
    }
    
    //CONTENIDO DE PRUEBA
    private Map<String, Object> respuestas_obtenidas = new HashMap<>();

    public Map<String, Object> getRespuestas_obtenidas() {
        return respuestas_obtenidas;
    }

    public void setRespuestas_obtenidas(Map<String, Object> respuestas_obtenidas) {
        this.respuestas_obtenidas = respuestas_obtenidas;
    }

    public UserWizard() {
        
        //Obteniendo el Usuario del Sistema
        UsuarioDAO u = new UsuarioDAO();
        HttpSession session = SessionUtils.getSession();
        long id;
        int perfil;
        try {
            perfil = (int)session.getAttribute("perfil");
            id = (long) session.getAttribute("id");
        } catch (Exception e) {
            perfil = 0;
            id = 0;
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
        
        if(perfil == 1){
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id); 
        }
        
        
        //Solo para Docente
        
    }
    
    
    
    public String guardarDatos(){
        
        System.out.println("Punto de quiebre");
        Periodo per = new Periodo();
        per.setId_periodo(1);
        p.setCod_ppp(3);
        p.setTiempoEsperaEstado(4);
        p.setEstado(true);
        p.setPeriodo(per);
        //est.setPasantia(setPas);
        //usuario.getEstudiante().setPasantia(setPas);
        
        //Datos de la Empresa
        enc.setEmpresa(emp);
        
        
        
        System.out.println("================= "+usuario.getEstudiante().getCedula());
        WizardDAO wd = new WizardDAO();
        wd.guardarDatosBasicos(usuario,p,enc,emp); 
        
        try {
            
        } catch (Exception e) {
            
        }
        
        return "student";
        
    }

    //FIN CONTENIDO PRUEBA
    
    
    private List<Campo> camposFormulario = new ArrayList();

    public List<Campo> getCamposFormulario() {
        return camposFormulario;
    }

    public List<Campo> getCamposFormulario(int formulario) {
        CampoDAO cd = new CampoDAO();
        camposFormulario = cd.obternerCampos(formulario);
        
        for (Iterator<Campo> iterator = camposFormulario.iterator(); iterator.hasNext();) {
            Campo next = iterator.next();
            respuestas_obtenidas.put(next.getNombre(), null);
            
        }
        
        
        return camposFormulario;
    }

    public Empresa getEmp() {
        return emp;
    }

    public void setEmp(Empresa emp) {
        this.emp = emp;
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estudiante getEst() {
        return est;
    }

    public void setEst(Estudiante est) {
        this.est = est;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    //Averiguar como usar este metodo
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    
    
}
