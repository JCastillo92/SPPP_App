/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import com.sppp.classes.Cls_PerfilNotation;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EstJhonAlexanderCast
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);

            String reqURI = reqt.getRequestURI();
            if (reqURI.indexOf("/login.xhtml") >= 0
                    || (ses != null && ses.getAttribute("username") != null)
                    || reqURI.indexOf("/public/") >= 0
                    || reqURI.contains("javax.faces.resource")) {
                
                //chain.doFilter(request, response);
                
                //BLOQUEADOR DE PAGINAS
                int perfil;
                
                try {
                    perfil = (int) ses.getAttribute("perfil");
                } catch (Exception e) {
                    perfil = 0;
                }
                Cls_PerfilNotation obj1= new Cls_PerfilNotation();
                
         if(obj1.perfilChooser(perfil).equals("Estudiante")){
                    //Para acceder a paginas de estudiante o publicas
                    if(reqURI.indexOf("/user/administrador/") >= 1 || reqURI.indexOf("/user/consejo/") >= 1 || reqURI.indexOf("/user/coordinador/") >= 1 || reqURI.indexOf("/user/gestores/") >= 1 || reqURI.indexOf("/user/secretaria/") >= 1 || reqURI.indexOf("/user/tutor/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/estudiantes/student.xhtml");
                    }
                    
                    if(reqURI.indexOf("/user/estudiantes") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/estudiantes/student.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN estudiante
                if(obj1.perfilChooser(perfil).equals("Gestor")){
                    
                    if(reqURI.indexOf("/user/administrador/") >= 1 || reqURI.indexOf("/user/consejo/") >= 1 || reqURI.indexOf("/user/coordinador/") >= 1 || reqURI.indexOf("/user/estudiantes/") >= 1 || reqURI.indexOf("/user/secretaria/") >= 1 || reqURI.indexOf("/user/tutor/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/gestores/attendant.xhtml");
                    }
                    
                    //Para acceder a paginas de gestores o publicas
                    if(reqURI.indexOf("/user/gestores") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/gestores/attendant.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN gestores
                if(obj1.perfilChooser(perfil).equals("Tutor")){
                    
                    if(reqURI.indexOf("/user/administrador/") >= 1 || reqURI.indexOf("/user/consejo/") >= 1 || reqURI.indexOf("/user/coordinador/") >= 1 || reqURI.indexOf("/user/estudiantes/") >= 1 || reqURI.indexOf("/user/gestores/") >= 1 || reqURI.indexOf("/user/secretaria/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/tutor/tutor.xhtml");
                    }
                    
                    //Para acceder a paginas de tutor o publicas
                    if(reqURI.indexOf("/user/tutor") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/tutor/tutor.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN tutor
                 if(obj1.perfilChooser(perfil).equals("Consejo")){
                    
                    if(reqURI.indexOf("/user/administrador/") >= 1 || reqURI.indexOf("/user/coordinador/") >= 1 || reqURI.indexOf("/user/estudiantes/") >= 1 || reqURI.indexOf("/user/gestores/") >= 1 || reqURI.indexOf("/user/secretaria/") >= 1 || reqURI.indexOf("/user/tutor/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/consejo/councel.xhtml");
                    }
                    
                    //Para acceder a paginas de consejo o publicas
                    if(reqURI.indexOf("/user/consejo") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/consejo/councel.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN consejo
                  if(obj1.perfilChooser(perfil).equals("Secretaria")){
                    
                    if(reqURI.indexOf("/user/administrador/") >= 1 || reqURI.indexOf("/user/consejo/") >= 1 || reqURI.indexOf("/user/coordinador/") >= 1 || reqURI.indexOf("/user/estudiantes/") >= 1 || reqURI.indexOf("/user/gestores/") >= 1 || reqURI.indexOf("/user/tutor/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/secretaria/secretary.xhtml");
                    }
                    
                    //Para acceder a paginas de secretaria o publicas
                    if(reqURI.indexOf("/user/secretaria") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/secretaria/secretary.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN secretaria
                   if(obj1.perfilChooser(perfil).equals("Coordinador")){
                    
                    if(reqURI.indexOf("/user/administrador/") >= 1 || reqURI.indexOf("/user/consejo/") >= 1 || reqURI.indexOf("/user/estudiantes/") >= 1 || reqURI.indexOf("/user/gestores/") >= 1 || reqURI.indexOf("/user/secretaria/") >= 1 || reqURI.indexOf("/user/tutor/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/coordinador/coordinator.xhtml");
                    }
                    
                    //Para acceder a paginas de coordinador o publicas
                    if(reqURI.indexOf("/user/coordinador") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/coordinador/coordinator.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN coordinador
                   if(obj1.perfilChooser(perfil).equals("Administrador")){
                    
                    if(reqURI.indexOf("/user/consejo/") >= 1 || reqURI.indexOf("/user/coordinador/") >= 1 || reqURI.indexOf("/user/estudiantes/") >= 1 || reqURI.indexOf("/user/gestores/") >= 1 || reqURI.indexOf("/user/secretaria/") >= 1 || reqURI.indexOf("/user/tutor/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/administrador/administrator.xhtml");
                    }
                    
                    //Para acceder a paginas de coordinador o publicas
                    if(reqURI.indexOf("/user/administrador") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/administrador/administrator.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN administrador                   
                else{
                    //if(ses == null){
                    if(obj1.perfilChooser(perfil).equals("0")){
                        chain.doFilter(request, response);
                    }
                }
                
                
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/public/login.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }

}
