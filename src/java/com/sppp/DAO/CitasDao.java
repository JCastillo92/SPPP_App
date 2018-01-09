/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import java.util.List;

/**
 *
 * @author KarenVanessaAchigGua
 */
public interface CitasDao {
    public List<VisitaTutor> findAll(String id);
     public List<VisitaTutor> confirma(long id);
     // public List<VisitaTutor> confirmaCita(String id);
     public List<Pasantia> listar(long user);
     
     public String obtenerNombre(long id);
     public long obtenercedulaTut(long id);
     public String obtenerApellido(long id);
     public String obtenerCorreo(long id);
     public String obtenerTelefono(long id);
     public String obtenerCorreoDirector(int id);
    public List<Pasantia> findUser(long id);
     public String obtenerCoordinador(long id);
        public List<VisitaTutor> listarVisitados(long id);
   public List<VisitaTutor> listarInformeCoor();
 public List<VisitaTutor> visitadosTuto(long user);
 public int horas(long user);
    
}
