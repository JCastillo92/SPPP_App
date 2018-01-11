/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.ProcesoDAO;
import com.sppp.utils.SessionUtils;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
public class EstadoProceso {

    private int proceso;
    private String nombre_proceso;
    private int estado;
    private String color;

    public String obtenerColorEstado(int procesoEstatico) {

        if (procesoEstatico < proceso) {
            color = "timeline-badge success";
        } else {
            //Si estamos en ese proceso
            if (procesoEstatico == proceso) {
                switch (estado) {
                    case 0:
                        color = "timeline-badge info";
                        break;

                    case 1:
                        color = "timeline-badge warning";
                        break;

                    case 2:
                        color = "timeline-badge success";
                        break;
                }
            }else{
                color = "timeline-badge";
            }
        }
        return color;
    }

    public int getEstado() {
        return estado;
    }

    public int getProceso() {

        DetallePasantiaDAO dpd = new DetallePasantiaDAO();
        HttpSession session = SessionUtils.getSession();
        long id;

        try {
            id = (long) session.getAttribute("id");
            proceso = dpd.findDetallePasantiaIdProcesoTrue(id);
        } catch (Exception e) {
            proceso = 0;
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+proceso);
        return proceso;
    }

    public String getNombre_proceso() {

        getProceso();

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

    public EstadoProceso() {

        //Encontrando el numero del proceso
        List<Integer> datosProcesoEstado = new LinkedList<>();
        DetallePasantiaDAO dpd = new DetallePasantiaDAO();
        HttpSession session = SessionUtils.getSession();
        long id;

        try {
            id = (long) session.getAttribute("id");
            //proceso = dpd.findDetallePasantiaIdProcesoTrue(id);
            datosProcesoEstado = dpd.findDetallePasantiaTrue(id);
            proceso = datosProcesoEstado.get(0);
            estado = datosProcesoEstado.get(1);
        } catch (Exception e) {
            proceso = 0;
        }

    }

    //Redirigir a los JSFs necesarios
    public String getRuta(int numeroProceso) {

        String ruta = null;

        switch (numeroProceso) {

            case 0:
                ruta = "info_pasantia";
                break;
            case 1:
                ruta = "info_pasantia";
                break;
            case 4:
                ruta = "subir_archivo";
                break;
            case 5:
                ruta = "subir_archivo_iniciopasantia";
                break;
            case 6:
                ruta ="";
                break;
            case 7:
                ruta = "carta_compromiso";
                break;

            case 11:
                ruta = "subir_archivo_cartacompromiso";
                break;
            case 14:
                ruta = "subir_cCOCC";
                break;
                            
            case 16:
                ruta = "revision_window";//otra ventana de consejo de carrera
                break;
                
            case 17:
                ruta =null;
                break;
            case 18:
                ruta ="confirma_cita_est";
                break;
                case 21:
                ruta ="revision_window_visita";
                break;
                case 24:
                ruta ="revision_window_visita2";
                break;
            case 28:
                ruta = "autoEvaluacion"; 
                break;
            case 30:
                ruta = "documentos_est"; 
                break;
            case 34:
                ruta = "solicitud_vfinal";
                break;
            case 36:
                ruta = "revision_window";
                break;  
            case 37:
                ruta = "subir_docs_vali";
                break;
            case 38:
                ruta = "revision_window_resolucion";
                break;  
             case 40:
                ruta = "revision_window_fin";
                break; 
        }

        return ruta;
    }

}
