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
@WebServlet(name = "WorkAddedSuccessServlet", urlPatterns = {"/work-added-success"})
public class WorkAddedSuccessServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<HTML><BODY>L'oeuvre a été ajoutée avec succès et son identifiant interne incrementale est "+request.getAttribute("identifiantOeuvre")+"</BR> <a href=\"home\">Retourner à la page d'accueil</a><BODY><HTML>");
     
   

    }

}
