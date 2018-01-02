/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Jairo
 */
public class Datos {
    private long id_tbdatos;
    private String valor_datos;
    private DetallePasantia detallePasantias;
    private Respuesta respuesta;
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public Datos(Respuesta respuesta, boolean estado) {
        this.respuesta = respuesta;
        this.estado = estado;
    }

    public Datos(long id_tbdatos, boolean estado) {
        this.id_tbdatos = id_tbdatos;
        this.estado = estado;
    }
    
    

    public Datos(long id_tbdatos, Respuesta respuesta, boolean estado) {
        this.id_tbdatos = id_tbdatos;
        this.respuesta = respuesta;
        this.estado = estado;
    }

    public Datos(long id_tbdatos, DetallePasantia detallePasantias, Respuesta respuesta, boolean estado) {
        this.id_tbdatos = id_tbdatos;
        this.detallePasantias = detallePasantias;
        this.respuesta = respuesta;
        this.estado = estado;
    }
    
    
    

    public Datos(String valor_datos, DetallePasantia detallePasantias, Respuesta respuesta) {
        this.valor_datos = valor_datos;
        this.detallePasantias = detallePasantias;
        this.respuesta = respuesta;
    }

    public Datos(String valor_datos, DetallePasantia detallePasantias, Respuesta respuesta, boolean estado) {
        this.valor_datos = valor_datos;
        this.detallePasantias = detallePasantias;
        this.respuesta = respuesta;
        this.estado = estado;
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

    public DetallePasantia getDetallePasantias() {
        return detallePasantias;
    }

    public void setDetallePasantias(DetallePasantia detallePasantias) {
        this.detallePasantias = detallePasantias;
    }

    public Datos() {
    }

    public Datos(long id_tbdatos, String valor_datos, DetallePasantia detallePasantias, Respuesta respuesta, boolean estado) {
        this.id_tbdatos = id_tbdatos;
        this.valor_datos = valor_datos;
        this.detallePasantias = detallePasantias;
        this.respuesta = respuesta;
        this.estado = estado;
    }

    
    
}
