/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.ProcesoDAO;
import com.sppp.DAO.UsuarioDAO;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author KRUGER
 */
@ManagedBean
public class DetalleEstudianteBean {

    private long id_est;
    private Pasantia pasantia = new Pasantia();
    private Usuario usuario = new Usuario();
    private DetallePasantia dp = new DetallePasantia();
    private Encargado encargado = new Encargado();
    private List<DetallePasantia> listaDetalles = new LinkedList<>();
    private String tipo;

    public Encargado getEncargado() {
        return encargado;
    }

    

    public List<DetallePasantia> getListaDetalles() {
        return listaDetalles;
    }

    public String getTipo() {
        try {
            if (pasantia.getTipo_ppp().equals("PA")) {
                tipo = "Pasantia";
            } else {
                tipo = "Practica Pre Profesional";
            }
        } catch (Exception e) {
        }

        return tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pasantia getPasantia() {
        return pasantia;
    }

    public long getId_est() {
        return id_est;
    }

    public void setId_est(long id_est) {
        this.id_est = id_est;
    }

    public void init() {

        //PARA REALIZAR LA BUSQUEDA EL USUARIO AL MENOS DEBE TENER REGISTRADO LOS DATOS BASICOS
        
        try {

            //Encontrar el Usuario
            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_est);

            //Encontrar la pasantia
            PasantiaDAO pDAO = new PasantiaDAO();
            pasantia = pDAO.findPasantia(id_est);

            //Encontrar todos los detalle pasantias de ese usuario
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
            listaDetalles = dpDAO.findAll(pasantia.getTipo_ppp(), pasantia.getCod_ppp());

            //Encontrar el encargado de ese usuario
            EncargadoDAO encDAO = new EncargadoDAO();
            encargado = encDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
        } catch (Exception e) {
           
        }

        System.out.println("Holas");
        //Buscar encargado

    }
    
    //Obtener el nombre del proceso
    public String nombreProceso( int proceso){
        String nombre_proceso;
        //SI PROCESO ES CERO IMPLICA QUE NO HAY INICIADO LA PASANTIA
        if (proceso != 0) {
            ProcesoDAO pDAO = new ProcesoDAO();
            Proceso p = new Proceso();
            nombre_proceso = pDAO.findDescripcionProceso(proceso);
        } else {
            nombre_proceso = "Comenzar Pasantia";
        }

        return nombre_proceso;

        
    }
    

}
