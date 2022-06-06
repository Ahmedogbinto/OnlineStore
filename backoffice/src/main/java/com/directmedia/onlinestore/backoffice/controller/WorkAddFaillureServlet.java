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
@WebServlet(name = "WorkAddFaillureServlet", urlPatterns = {"/work-add-faillure"})
public class WorkAddFaillureServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<HTML><BODY>Une erreur est survenue, l'oeuvre n'a pas été ajouter<BR/><a href=\"home\">Retourner à la page d'accueil</a><BODY><HTML>");
     
   
        
}
}
