/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {


   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.print("<HTML><BODY><h1>OnlineStore - Gestion de la boutique</h1>");
        out.print("Bonjour "+request.getSession().getAttribute("login")+"<BR/>");
        
        out.print("<a href=\"add-work-form.html\">Ajouter une oeuvre au catalogue</a><BR/>");
        out.print("<a href=\"catalogue\">Acces au catalogue</a>");
        out.print("</BODY></HTML>");
                  
    }

}
