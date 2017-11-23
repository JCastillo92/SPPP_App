/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

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
                
                if(perfil == 1){
                    //Para acceder a paginas de estudiante o publicas
                    if(reqURI.indexOf("/user/gestores/") >= 1){
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
                if(perfil == 2){
                    
                    if(reqURI.indexOf("/user/estudiantes/") >= 1){
                        resp.sendRedirect(reqt.getContextPath() + "/faces/user/gestores/attendant.xhtml");
                    }
                    
                    //Para acceder a paginas de estudiante o publicas
                    if(reqURI.indexOf("/user/gestores") >= 0 || reqURI.indexOf("/public/") >=0 || reqURI.contains("javax.faces.resource")){
                        
                        //No debe volver al login
                        if (reqURI.indexOf("/public/login.xhtml") >= 0){
                            resp.sendRedirect(reqt.getContextPath() + "/faces/user/gestores/attendant.xhtml");
                        }else{
                            chain.doFilter(request, response);
                        }
                    }
                } // FIN estudiante
                else{
                    //if(ses == null){
                    if(perfil == 0){
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
