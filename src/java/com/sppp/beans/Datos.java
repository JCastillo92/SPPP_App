/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Set;

/**
 *
 * @author Jairo
 */
public class Datos {
    private long id_tbdatos;
    private String valor_datos;
    private Set<DetallePasantia> detallePasantias;
    private Respuesta respuesta;

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public long getId_tbdatos() {
        return id_tbdatos;
    }

    public void setId_tbdatos(long id_tbdatos) {
        this.id_tbdatos = id_tbdatos;
    }

    public String getValor_datos() {
        return valor_datos;
    }

    public void setValor_datos(String valor_datos) {
        this.valor_datos = valor_datos;
    }

    public Set<DetallePasantia> getDetallePasantias() {
        return detallePasantias;
    }

    public void setDetallePasantias(Set<DetallePasantia> detallePasantias) {
        this.detallePasantias = detallePasantias;
    }
    
}
