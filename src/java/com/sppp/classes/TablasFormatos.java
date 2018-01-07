/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.VisitaDAO;
import com.sppp.mailing.MailingMain;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;

/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name="tablasFormatos")
public class TablasFormatos implements Serializable {

  
    @NotNull(message="Campo obligatorio")
  int pregunta1;
  int pregunta2;
  int pregunta3;
  int pregunta4;
  int pregunta5;
  int pregunta6;
  int pregunta7;
  int pregunta8;
  int pregunta10;
String des1;
  int hor1;
  int tec1;
  int per1;
  int cont1;
  String des2;
  int hor2;
  int tec2;
  int per2;
  int cont2;
  String des3;
  int hor3;
  int tec3;
  int per3;
  int cont3;
  String des4;
  int hor4;
  int tec4;
  int per4;
  int cont4;
String observaciones;
String observacionvisita;
String movilizacionvisita;
int auto1;
int auto2;
int auto3;
int auto4;
int auto5;
int total;

private boolean paso=false;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public boolean isPaso() {
        return paso;
    }

    public void setPaso(boolean paso) {
        this.paso = paso;
    }
   
    public int getAuto1() {
        return auto1;
    }

    public void setAuto1(int auto1) {
        this.auto1 = auto1;
    }

    public int getAuto2() {
        return auto2;
    }

    public void setAuto2(int auto2) {
        this.auto2 = auto2;
    }

    public int getAuto3() {
        return auto3;
    }

    public void setAuto3(int auto3) {
        this.auto3 = auto3;
    }

    public int getAuto4() {
        return auto4;
    }

    public void setAuto4(int auto4) {
        this.auto4 = auto4;
    }

    public int getAuto5() {
        return auto5;
    }

    public void setAuto5(int auto5) {
        this.auto5 = auto5;
    }




        public String getDes2() {
        return des2;
    }

    public void setDes2(String des2) {
        this.des2 = des2;
    }

    public int getHor2() {
        return hor2;
    }

    public void setHor2(int hor2) {
        this.hor2 = hor2;
    }

    public int getTec2() {
        return tec2;
    }

    public void setTec2(int tec2) {
        this.tec2 = tec2;
    }

    public int getPer2() {
        return per2;
    }

    public void setPer2(int per2) {
        this.per2 = per2;
    }

    public int getCont2() {
        return cont2;
    }

    public void setCont2(int cont2) {
        this.cont2 = cont2;
    }

    public String getDes3() {
        return des3;
    }

    public void setDes3(String des3) {
        this.des3 = des3;
    }

    public int getHor3() {
        return hor3;
    }

    public void setHor3(int hor3) {
        this.hor3 = hor3;
    }

    public int getTec3() {
        return tec3;
    }

    public void setTec3(int tec3) {
        this.tec3 = tec3;
    }

    public int getPer3() {
        return per3;
    }

    public void setPer3(int per3) {
        this.per3 = per3;
    }

    public int getCont3() {
        return cont3;
    }

    public void setCont3(int cont3) {
        this.cont3 = cont3;
    }

    public String getDes4() {
        return des4;
    }

    public void setDes4(String des4) {
        this.des4 = des4;
    }

    public int getHor4() {
        return hor4;
    }

    public void setHor4(int hor4) {
        this.hor4 = hor4;
    }

    public int getTec4() {
        return tec4;
    }

    public void setTec4(int tec4) {
        this.tec4 = tec4;
    }

    public int getPer4() {
        return per4;
    }

    public void setPer4(int per4) {
        this.per4 = per4;
    }

    public int getCont4() {
        return cont4;
    }

    public void setCont4(int cont4) {
        this.cont4 = cont4;
    }

    public int getHor1() {
        return hor1;
    }

    public void setHor1(int hor1) {
        this.hor1 = hor1;
    }

    public int getTec1() {
        return tec1;
    }

    public void setTec1(int tec1) {
        this.tec1 = tec1;
    }

    public int getPer1() {
        return per1;
    }

    public void setPer1(int per1) {
        this.per1 = per1;
    }

    public int getCont1() {
        return cont1;
    }

    public void setCont1(int cont1) {
        this.cont1 = cont1;
    }

    public String getDes1() {
        return des1;
    }

    public void setDes1(String des1) {
        this.des1 = des1;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservacionvisita() {
        return observacionvisita;
    }

    public void setObservacionvisita(String observacionvisita) {
        this.observacionvisita = observacionvisita;
    }

    public String getMovilizacionvisita() {
        return movilizacionvisita;
    }

    public void setMovilizacionvisita(String movilizacionvisita) {
        this.movilizacionvisita = movilizacionvisita;
    }

    
    public int getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(int pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public int getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(int pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public int getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(int pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public int getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(int pregunta4) {
        this.pregunta4 = pregunta4;
    }

    public int getPregunta5() {
        return pregunta5;
    }

    public void setPregunta5(int pregunta5) {
        this.pregunta5 = pregunta5;
    }

    public int getPregunta6() {
        return pregunta6;
    }

    public void setPregunta6(int pregunta6) {
        this.pregunta6 = pregunta6;
    }

    public int getPregunta7() {
        return pregunta7;
    }

    public void setPregunta7(int pregunta7) {
        this.pregunta7 = pregunta7;
    }

    public int getPregunta8() {
        return pregunta8;
    }

    public void setPregunta8(int pregunta8) {
        this.pregunta8 = pregunta8;
    }

 

    public int getPregunta10() {
        return pregunta10;
    }

    public void setPregunta10(int pregunta10) {
        this.pregunta10 = pregunta10;
    }

  
   

    public String informeTutor(long user){
        AlmacenamientoPDF g=new AlmacenamientoPDF();
       g.pdf_InformeTutor(user, 200, pregunta10,pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,observaciones);
paso=true;
return "revision_windowFin";

    }
    
    public void informeSeguimientoTu(long user){
      AlmacenamientoPDF g=new AlmacenamientoPDF();
      g.pdf_InformeSeguimientoTutor(user, 201, des1, hor1, tec1, per1, cont1, des2, hor2, tec2, per2, cont2, des3, hor3, tec3, per3, cont3, des4, hor4, tec4, per4, cont4,total);
    paso=true;
    }
    public String autoevaluacion(long user, String correo){
      AlmacenamientoPDF g=new AlmacenamientoPDF();
    g.pdf_autoevaluacion(user, 203, auto1, auto2, auto3, auto4, auto5);
    paso=true;
    MailingMain por = new MailingMain();
      por.mensajes(1005, correo,"vacio");
    VisitaDAO vi = new VisitaDAO();
    vi.documentacion_est();
    return"revision_window";
    }

 public void solicitudFinal(long user){
      AlmacenamientoPDF g=new AlmacenamientoPDF();
    g.pdf_solicitudFinal(user, 204);
    }    
    public void informeRuta(long cedula_est){
      AlmacenamientoPDF crear=new AlmacenamientoPDF();
   
   crear.pdf_hojaRuta(cedula_est,202,observacionvisita,movilizacionvisita);
    paso=true;     
    }
    
    public void cambiarestado(){
    paso=true;
    }
    
}
