/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.CampoDAO;
import com.sppp.DAO.DatosDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.DAO.WizardDAO;
import com.sppp.utils.SessionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;
import com.sppp.DAO.PasantiaPracticaDAO;
import com.sppp.DAO.PeriodoDAO;
import com.sppp.classes.AlmacenamientoPDF;
import com.sppp.classes.ListaDocentesAdministrativos;
import com.sppp.mailing.MailingMain;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
@ViewScoped
public class UserWizard extends WizardDB implements Serializable {

    private boolean existe;
    DetallePasantia dpp = new DetallePasantia();
    private String texto_alerta;
    private boolean existeTexto;
    private List<Datos> dDbObtenidos = new LinkedList<>();
    private boolean[] datosAPintar = new boolean[18];

    public boolean[] getDatosAPintar() {
        return datosAPintar;
    }
    
    public List<Datos> getdDbObtenidos() {
        return dDbObtenidos;
    }
    
    public String getTexto_alerta() {
        
        try {
              texto_alerta = texto_alerta.replace("\n", "<br />");
        } catch (Exception e) {
        }

        return texto_alerta;
    }

    public boolean isExisteTexto() {
        return existeTexto;
    }
    
    
    
    public UserWizard() {

    }

    @PostConstruct
    void init() {

        //Obteniendo el Usuario del Sistema
        UsuarioDAO u = new UsuarioDAO();
        HttpSession session = SessionUtils.getSession();

        long id;
        int perfil;
        try {
            perfil = (int) session.getAttribute("perfil");
            id = (long) session.getAttribute("id");

            UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id);

            // COMPRUEBO SI EL ESTUDIANTE YA INGRESO DATOS DE SU PASANTIA PREVIAMENTE
            PasantiaDAO passDAO = new PasantiaDAO();
            existe = passDAO.existePasantia(id);

            if (existe) {
                p = passDAO.findPasantia(id);
                EncargadoDAO encarDAO = new EncargadoDAO();
                enc = encarDAO.findEncargado(p.getEncargado().getId_encargado());
                EmpresaDAO empreDAO = new EmpresaDAO();
                emp = empreDAO.findEmpresa(enc.getEmpresa().getId_empresa());
                //Encuentro la pasantia PERO QUE SEA DE IDPROCESO = 1 OSEA DATOSBASICOS
                DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
                dpp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),1);
                
                //Obtengo la observacion hecha por el gestor
                texto_alerta = dpp.getObservacion();
                
                //Compruebo que no sea null
                if (texto_alerta != null && !texto_alerta.trim().equalsIgnoreCase("")){
                    existeTexto = true;
                }else{
                    existeTexto = false;
                }
                
                //Traer el listado de los datos guardados
                DatosDAO dDbDAO = new DatosDAO();
                dDbObtenidos = dDbDAO.datosPorDetallePasantia(dpp.getIdDetallePasantia());
                llenarDatosAPintar(dDbObtenidos);
                System.out.println("");
                //
                
            }else{
                Arrays.fill(datosAPintar, true);
            }
            
            
        } catch (Exception e) {
            //p = null;
            System.out.println("========== ERROR AL TRAER INFO DE USUARIO ==============0");
        }

    }
    
    public void llenarDatosAPintar(List<Datos> dDbObtenidos2){
        
        for (int i = 0; i < dDbObtenidos2.size(); i++) {
            datosAPintar[i] = dDbObtenidos2.get(i).isEstado();
        }
        
    }
    
    public String guardarDatos() {

        System.out.println("Punto de quiebre");
        PasantiaPracticaDAO objeto_ppp = new PasantiaPracticaDAO();
        PeriodoDAO objeto_periodo = new PeriodoDAO();
        AlmacenamientoPDF one_time_unique = new AlmacenamientoPDF();

        //SI LA PASANTIA NO EXISTE , LE AGREGO LOS DATOS MAS ACTUALES
        //INCLUYENDO EL ULTIMO ID, ULTIMO PERIODO
        if (!existe) {

            //veo el periodo
            Periodo per = new Periodo();
            long id_periodo = 0;//creo la variable long ya que periodo es de tipo long
            id_periodo = objeto_periodo.encontrarPeriodoActual();//lamo a obtener el ID del periodo actual el cual estara en TRUE
            per.setId_periodo(id_periodo);//aqui seteo el periodo actual obtenido

            //veo tipo de pasantia o practca pre-profesional
            String tipo_pa_pp = "none";
            tipo_pa_pp = p.getTipo_ppp();
            //<f:selectItem itemLabel="Pasantia" itemValue="pa"/>
            //<f:selectItem itemLabel="Practica Pre Profesional" itemValue="pp"/>

            int receive_new_code = 0;
            if (tipo_pa_pp.equals("PP")) {
                receive_new_code = objeto_ppp.encontrarUltimoPP();//aqui recibo el nuevo codigo de PP
                p.setCod_ppp(receive_new_code);
            }
            if (tipo_pa_pp.equals("PA")) {
                receive_new_code = objeto_ppp.encontrarUltimoPA();//aqui recibo el nuevo codigo de Pa
                p.setCod_ppp(receive_new_code);
            }

            p.setTiempoEsperaEstado(4);
            p.setEstado(true);
            p.setPeriodo(per);
            //est.setPasantia(setPas);
            //usuario.getEstudiante().setPasantia(setPas);

            // 2DA PARTE
            //Datos adicionales de pasantia para agregarle el estudiante y el encargado
            enc.setEmpresa(emp);
            est = usuario.getEstudiante();
            p.setEstudiante(est);
            p.setEncargado(enc);

            //Creando valores en detalle pasantia
            Proceso proceso = new Proceso();
            proceso.setId_proceso(1);
            //DetallePasantia dpp = new DetallePasantia();
            dpp.setDescripcion("Dato Inicio Procesos Pasantia");
            dpp.setEstado(true);
            
            dpp.setProceso(proceso);

            //Asignando a pasantia
            dpp.setPasantia(this.p);

        }

        //Siempre debe hacerse a validar EXISTA  O NO
        dpp.setValidacion(EnumEstado.validar);
        //DATOS DE LA EMPRESA
        //enc.setEmpresa(emp);
        
        WizardDAO wd = new WizardDAO();
        wd.guardarDatosBasicos(usuario, p, enc, emp,dpp);

        //Mando los datos a guardar a la tabla DATOS
        DatosDAO dDAO = new DatosDAO();
        if(!existe){
            dDAO.guardarDatosBasicos(usuario, emp, enc, p, dpp);
        }else{
            //Aqui hay que recuperar el ID de los anteriores datos
            //Seria con el IdDetallePasantia
            dDAO.actualizarDatosBasicos(usuario, emp, enc, p, dpp);
        }
        

        //aqui llamo por una y solo una vez al siguiente metodo "create_student_folder_first_time"
        one_time_unique.create_student_folder_first_time(usuario.getEstudiante().getCedula());

        //aqui envio el email al docente encargado del inicio del PROCESO de pasantias.
        MailingMain primer_mensaje = new MailingMain();
        ListaDocentesAdministrativos corrreo_De = new ListaDocentesAdministrativos();
        primer_mensaje.mensajes(1001, corrreo_De.corrreoDocenteAdministrativo(6), "vacio");
        return "revision_window";

    }

    //FIN CONTENIDO PRUEBA
    /*
    private List<Campo> camposFormulario = new ArrayList();

    public List<Campo> getCamposFormulario() {
        return camposFormulario;
    }

    public List<Campo> getCamposFormulario(int formulario) {
        CampoDAO cd = new CampoDAO();
        camposFormulario = cd.obternerCampos(formulario);
        
        for (Iterator<Campo> iterator = camposFormulario.iterator(); iterator.hasNext();) {
            Campo next = iterator.next();
            respuestas_obtenidas.put(next.getNombre(), null);
            
        }
        
        
        return camposFormulario;
    }*/
    //Averiguar como usar este metodo
    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
    
    public void estado(){
        EstadoProceso ep = new EstadoProceso();
        int estado = ep.getEstado();
        if (estado == 1){
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath() + "/faces/user/estudiantes/revision_window.xhtml");
            } catch (IOException ex) {
                
            }
        }else{
            
        }
    }

}
