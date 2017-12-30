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
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KRUGER
 */
@ManagedBean
@ViewScoped
public class WizardCCValidacion extends WizardCC {

    //@ManagedProperty(value = "#{param.id}")
    int id_estudiante;
    
    List<Datos> datosCartaC = new LinkedList<>();
    DetallePasantia dp2 = new DetallePasantia();
    
    private boolean validar1;
    private boolean validar2;
    private boolean validar3;
    private boolean validar4;
    private boolean validar5;
    private boolean validar6;
    private boolean validar7;
    private boolean validar8;
    private boolean validar9;
    private boolean validar10;
    
    private boolean validar11;
    private boolean validar12;
    private boolean validar13;
    private boolean validar14;
    private boolean validar15;
    private boolean validar16;
    private boolean validar17;
    private boolean validar18;
    private boolean validar19;
    private boolean validar20;
    private boolean validar21;

    public boolean isValidar21() {
        return validar21;
    }

    public void setValidar21(boolean validar21) {
        this.validar21 = validar21;
    }

    public boolean isValidar1() {
        return validar1;
    }

    public void setValidar1(boolean validar1) {
        this.validar1 = validar1;
    }

    public boolean isValidar2() {
        return validar2;
    }

    public void setValidar2(boolean validar2) {
        this.validar2 = validar2;
    }

    public boolean isValidar3() {
        return validar3;
    }

    public void setValidar3(boolean validar3) {
        this.validar3 = validar3;
    }

    public boolean isValidar4() {
        return validar4;
    }

    public void setValidar4(boolean validar4) {
        this.validar4 = validar4;
    }

    public boolean isValidar5() {
        return validar5;
    }

    public void setValidar5(boolean validar5) {
        this.validar5 = validar5;
    }

    public boolean isValidar6() {
        return validar6;
    }

    public void setValidar6(boolean validar6) {
        this.validar6 = validar6;
    }

    public boolean isValidar7() {
        return validar7;
    }

    public void setValidar7(boolean validar7) {
        this.validar7 = validar7;
    }

    public boolean isValidar8() {
        return validar8;
    }

    public void setValidar8(boolean validar8) {
        this.validar8 = validar8;
    }

    public boolean isValidar9() {
        return validar9;
    }

    public void setValidar9(boolean validar9) {
        this.validar9 = validar9;
    }

    public boolean isValidar10() {
        return validar10;
    }

    public void setValidar10(boolean validar10) {
        this.validar10 = validar10;
    }

    public boolean isValidar11() {
        return validar11;
    }

    public void setValidar11(boolean validar11) {
        this.validar11 = validar11;
    }

    public boolean isValidar12() {
        return validar12;
    }

    public void setValidar12(boolean validar12) {
        this.validar12 = validar12;
    }

    public boolean isValidar13() {
        return validar13;
    }

    public void setValidar13(boolean validar13) {
        this.validar13 = validar13;
    }

    public boolean isValidar14() {
        return validar14;
    }

    public void setValidar14(boolean validar14) {
        this.validar14 = validar14;
    }

    public boolean isValidar15() {
        return validar15;
    }

    public void setValidar15(boolean validar15) {
        this.validar15 = validar15;
    }

    public boolean isValidar16() {
        return validar16;
    }

    public void setValidar16(boolean validar16) {
        this.validar16 = validar16;
    }

    public boolean isValidar17() {
        return validar17;
    }

    public void setValidar17(boolean validar17) {
        this.validar17 = validar17;
    }

    public boolean isValidar18() {
        return validar18;
    }

    public void setValidar18(boolean validar18) {
        this.validar18 = validar18;
    }

    public boolean isValidar19() {
        return validar19;
    }

    public void setValidar19(boolean validar19) {
        this.validar19 = validar19;
    }

    public boolean isValidar20() {
        return validar20;
    }

    public void setValidar20(boolean validar20) {
        this.validar20 = validar20;
    }
    
    
    

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    

    public WizardCCValidacion() {

        try {
            
            /////LLAMADO A informacion NECESERAIA PARA ingresar, crear AL P D F
 /*           UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_estudiante);

            PasantiaDAO passDAO = new PasantiaDAO();
            pasantia = passDAO.findPasantia(id_estudiante);

            EncargadoDAO encarDAO = new EncargadoDAO();
            encargado = encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());

            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa = empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());

            DetallePasantia dp2 = new DetallePasantia();
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
            dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
            
            obtenerDatosEstudiante(dp2.getIdDetallePasantia());
*/
        } catch (Exception e) {
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }
    }

    public void obtenerDatosEstudiante(int id) {
        
        DatosDAO dDAO = new DatosDAO();
        datosCartaC = dDAO.datosPorDetallePasantia(id);
        llenarDatosEstudiante();
    }
    
    public void llenarDatosEstudiante(){
        
        lugarFecha = datosCartaC.get(28).getValor_datos();
        
        objetoDeLaActividad = datosCartaC.get(11).getValor_datos();
        horarioPrevisto = datosCartaC.get(15).getValor_datos();
        nombrePrograma = datosCartaC.get(16).getValor_datos();
        areaAcademica = datosCartaC.get(17).getValor_datos();
        actividadPrevista = datosCartaC.get(19).getValor_datos();
        resultadosPrevistos = datosCartaC.get(20).getValor_datos();
        productosEntregables = datosCartaC.get(21).getValor_datos();
        
        //Zona checkbox
        validar11  = datosCartaC.get(11).isEstado();
        
        validar15  = datosCartaC.get(15).isEstado();
        validar16 = datosCartaC.get(16).isEstado();
        validar17 = datosCartaC.get(17).isEstado();
        
        validar19 = datosCartaC.get(19).isEstado();
        validar20 = datosCartaC.get(20).isEstado();
        validar21 = datosCartaC.get(21).isEstado();
        //FIN ZONA CHECKBOX
    }
    
    public void init(){
        System.out.println("========== "+id_estudiante);
        
        UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_estudiante);

            PasantiaDAO passDAO = new PasantiaDAO();
            pasantia = passDAO.findPasantia(id_estudiante);

            EncargadoDAO encarDAO = new EncargadoDAO();
            encargado = encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());

            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa = empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            
            
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
            dp2 = dpDAO.findDetallePasantia(pasantia.getTipo_ppp(), pasantia.getCod_ppp());
            
            obtenerDatosEstudiante(dp2.getIdDetallePasantia());
        
    }
    
    
    
    public String guardarDatos(){
        
        //Tomo los datos de la validacion
        //Son solo 7 , porque los demas datos ya llegan validados
        //init();
        List<Datos> lDatos = new LinkedList<>();
        lDatos.add(new Datos(datosCartaC.get(11).getId_tbdatos(),datosCartaC.get(11).getValor_datos() ,datosCartaC.get(11).getDetallePasantias(),new Respuesta(12), validar11));
        lDatos.add(new Datos(datosCartaC.get(15).getId_tbdatos(),datosCartaC.get(15).getValor_datos() ,datosCartaC.get(15).getDetallePasantias(),new Respuesta(16), validar15));
        lDatos.add(new Datos(datosCartaC.get(16).getId_tbdatos(),datosCartaC.get(16).getValor_datos() ,datosCartaC.get(16).getDetallePasantias(),new Respuesta(17), validar16));
        lDatos.add(new Datos(datosCartaC.get(17).getId_tbdatos(),datosCartaC.get(17).getValor_datos() ,datosCartaC.get(17).getDetallePasantias(),new Respuesta(18), validar17));
        lDatos.add(new Datos(datosCartaC.get(19).getId_tbdatos(),datosCartaC.get(19).getValor_datos() ,datosCartaC.get(19).getDetallePasantias(),new Respuesta(20), validar19));
        lDatos.add(new Datos(datosCartaC.get(20).getId_tbdatos(),datosCartaC.get(20).getValor_datos() ,datosCartaC.get(20).getDetallePasantias(),new Respuesta(21), validar20));
        lDatos.add(new Datos(datosCartaC.get(21).getId_tbdatos(),datosCartaC.get(21).getValor_datos() ,datosCartaC.get(21).getDetallePasantias(),new Respuesta(22), validar21));

        DatosDAO dDAO = new DatosDAO();
        dDAO.guardarValidacionCC(lDatos);
        
        //DESPUES DEL GUARDADO EN CASO DE APROBAR O NO VALIDAR
        DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        if(validar11 && validar15 && validar16 && validar17 && validar19 && validar20 && validar21 ){
            //Cambio el campo validacion y el estado en DetallePasantia
            dp2.setValidacion(EnumEstado.aprobar);
            dp2.setEstado(false);
            dpDAO.actualizarDetallePasantia(dp2);
            
            //Paso a agregar el nuevo proceso 11
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Descargar/Subir Carta Compromiso");
            dp3.setEstado(true);
            dp3.setPasantia(pasantia);
            dp3.setProceso(new Proceso(11));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
            
        }else{
            //Cambio solo el campo Validacion
            dp2.setValidacion(EnumEstado.llenar);
            dpDAO.actualizarDetallePasantia(dp2);
        }
        
        return "dashboard_gestor";
        
    }

}
