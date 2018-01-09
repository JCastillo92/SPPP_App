/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.utils.UploadFile;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name="controllerProcesos")
public class ControllerProcesos implements Serializable {

    List<String> nombresAArchivos;
    
    List<String> nombresArchivosSellados;

    public List<String> getNombresAArchivos(long user) throws IOException {
        UploadFile crear=new UploadFile();
       nombresAArchivos=crear.listar(user);
        return nombresAArchivos;
    }

    public List<String> getNombresArchivosSellados(long user) throws IOException {
        UploadFile crear=new UploadFile();
       nombresArchivosSellados=crear.listarSellados(user);
        return nombresArchivosSellados;
    }
    
}
