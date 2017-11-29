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
public class Proceso {
    private long id_proceso;
    private String descripcion;
    private boolean estado;
    private Set procesos;
    private Set<DetallePasantia> detallePasantias;
    
    private Formato formato;

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
    

    public Set getProcesos() {
        return procesos;
    }

    public void setProcesos(Set procesos) {
        this.procesos = procesos;
    }
    
    private Proceso subproceso;
    private long proceso_de;

    public Proceso getSubproceso() {
        return subproceso;
    }

    public void setSubproceso(Proceso subproceso) {
        this.subproceso = subproceso;
    }

    public long getProceso_de() {
        return proceso_de;
    }

    public void setProceso_de(long proceso_de) {
        this.proceso_de = proceso_de;
    }
    

    public Set<DetallePasantia> getDetallePasantias() {
        return detallePasantias;
    }

    public void setDetallePasantias(Set<DetallePasantia> detallePasantias) {
        this.detallePasantias = detallePasantias;
    }

    public long getId_proceso() {
        return id_proceso;
    }

    public void setId_proceso(long id_proceso) {
        this.id_proceso = id_proceso;
    }
   
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    
    
}
