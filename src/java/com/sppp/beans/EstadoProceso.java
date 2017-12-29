/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.ProcesoDAO;
import com.sppp.utils.SessionUtils;
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

    //Redirigir a los JSFs necesarios
    public String getRuta(int numeroProceso) {

        String ruta = null;

        switch (numeroProceso) {

            case 0:
                ruta = "info_pasantia";

                break;

            case 1:
                ruta = "subir_archivo";
                break;

            case 2:
                ruta = "carta_compromiso";

                break;

            case 3:
                ruta = "subir_archivo_cartacompromiso";
                break;

            case 4:
                ruta = "xxx";

                break;

            case 5:
                ruta = "subir_archivo_iniciopasantia";
                break;
            //PARA FUTUROS CASOS
            case 6:
                ruta = "";

                break;
            //PARA FUTUROS CASOS
            case 7:
                ruta = "";
                break;
        }

        return ruta;
    }

}
