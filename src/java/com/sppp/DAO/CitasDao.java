/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import java.util.List;

/**
 *
 * @author KarenVanessaAchigGua
 */
public interface CitasDao {
    public List<VisitaTutor> findAll(String id);
     public List<VisitaTutor> confirma(String id);
      public List<VisitaTutor> confirmaCita(String id);
     public List<Usuario> listar();
     
    
}
