/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DatosDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.classes.ListaDocentesAdministrativos;
import com.sppp.mailing.MailingMain;
import com.sppp.utils.SessionUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
public class PdfEstudiante {
    
    private boolean existe;
    private String texto_alerta;
    private boolean[] datosAPintar = new boolean[4];
    private Usuario usuario;
    private Pasantia pasantia;
    private boolean existeTexto;
    List<Datos> datosCartaC = new LinkedList<>();

    public boolean isExisteTexto() {
        return existeTexto;
    }

    public String getTexto_alerta() {
        try {
              texto_alerta = texto_alerta.replace("\n", "<br />");
        } catch (Exception e) {
        }
        return texto_alerta;
    }

    public boolean[] getDatosAPintar() {
        return datosAPintar;
    }

    public PdfEstudiante() {
        init();
    }
    
    
    
    public void init(){
        
        //OBTENIENDO EL DETALLE PASANTIA DEL USUARIO
        HttpSession session = SessionUtils.getSession();
        long id;
        try {
            id = (long) session.getAttribute("id");
            /////LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(id);
            
            //DEBO OBTENER EL DETALLE PASANTIA SOLO PARA BUSCAR LOS DATOS / EXISTE OTRA DETALLEPASANTIA MAS ABAJO
            DetallePasantia dpCargaDatos = new DetallePasantia();
            DetallePasantiaDAO dpDAOT = new DetallePasantiaDAO();
            dpCargaDatos = dpDAOT.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
            
            //Mandar a cargar la info si esta disponible en la DataBase de Datos
            
            DatosDAO datosDAO = new DatosDAO();
            existe = datosDAO.hayDatosDeDetallePasantia(dpCargaDatos.getIdDetallePasantia());
            
            //De acuerdo a si EXISTE se carga o NO Datos
            if(existe){
                obtenerDatosEstudiante(dpCargaDatos.getIdDetallePasantia());
            }else{
                 Arrays.fill(datosAPintar, true);
            }
            
            //PARA obtener la Observacion
            texto_alerta = dpCargaDatos.getObservacion();
                
            //Compruebo que no sea null
            if (texto_alerta != null && !texto_alerta.trim().equalsIgnoreCase("")) {
                existeTexto = true;
            } else {
                existeTexto = false;
            }
            
        } catch (Exception e) {
            id = 0;
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
        
    }
    
    public void obtenerDatosEstudiante(int id) {
        
        DatosDAO dDAO = new DatosDAO();
        datosCartaC = dDAO.datosPorDetallePasantia(id);
        
        //Lleno el vector auxiliar de Pintar
        llenarDatosAPintar(datosCartaC);

    }
    
    public void llenarDatosAPintar(List<Datos> dDbObtenidos2){
        
        for (int i = 0; i < dDbObtenidos2.size(); i++) {
            datosAPintar[i] = dDbObtenidos2.get(i).isEstado();
        }
        
    }
    
    //METODO PARA GUARDAR LOS TRUE
    public String guardarDatos(){
        String redireccion = "revision_window";
        MailingMain enviar_mail=new MailingMain();
        ListaDocentesAdministrativos corrreo_De=new ListaDocentesAdministrativos();
        try {
         //Obtener idDetallePasantia
        DetallePasantia dp2 = new DetallePasantia();
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
        
        //Mando a estado validar el registro en la DB
        //Porque no necesito guardar mas cosas
        //Solo mandar a validar de nuevo
        dp2.setValidacion(EnumEstado.validar);
        dpDAO.actualizarDetallePasantia(dp2);   
            
                    //envio mail a encargado mail para que revise scan de 4 PDFs
        enviar_mail.mensajes(1004,corrreo_De.corrreoDocenteAdministrativo(6),"vacio");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return redireccion;
    }
    
    public void estado(){
        EstadoProceso ep = new EstadoProceso();
        int estado = ep.getEstado();
        if (estado == 1){
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath() + "/faces/user/estudiantes/revision_window.xhtml");
            } catch (IOException ex) {
                
            }
        }else{
            
        }
    }
    
}
