/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.PeriodoDAO;
import com.sppp.DAO.ProcesoTutDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name = "graficasTut")

public class GraficasTut implements Serializable {

   private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ProcesoTutDao p=new ProcesoTutDao();
        ChartSeries basico = new ChartSeries();
        basico.setLabel("Datos Basicos");
        basico.set("  ", p.countIngresoDatosBasicos());
       
        ChartSeries inicio = new ChartSeries();
        inicio.setLabel("Inicio actividades");
        inicio.set(" ", p.countIngresoInicioActividad());
        
        
        ChartSeries cits = new ChartSeries();
        cits.setLabel("Citas agendadas");
        cits.set(" ", p.countCitasAgendas());
        
        ChartSeries citaterminada = new ChartSeries();
        citaterminada.setLabel("Visita concluida");
        citaterminada.set(" ", p.countVisitaConcluida());
        
          ChartSeries validacion = new ChartSeries();
        validacion.setLabel("Validaciòn");
        validacion.set(" ", p.countVisitaConcluida());
        
        model.addSeries(basico);
        model.addSeries(inicio);
        model.addSeries(cits);
        model.addSeries(citaterminada);
        model.addSeries(validacion);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Estudiantes dentro del proceso");
        barModel.setLegendPosition("ne");
         PeriodoDAO q=new PeriodoDAO();
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Periodo "+q.encontrarPeriodoActual1());
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Estudiantes");
        yAxis.setMin(0);
        yAxis.setMax(80);
    }
      
}
