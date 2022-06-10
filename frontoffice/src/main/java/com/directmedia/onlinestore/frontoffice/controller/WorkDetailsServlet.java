/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id=request.getParameter("id");
       
        // rechercher dans le catalogue quel oeuvre possede cet id
        // Si on utilise Java8, on utilisisera la Syntaxe de l'API stream
        
        // Work work=Catalogue.listOfWork.stream().filter(w -> w.getId()==Long.parseLong(id)).findFirst().get();
        
        // Cette ligne me permet rechercher l'oeuvre dont l'identité  a ete reçu en parametre.
        // Cette syntaxe pourrait gener de multiple exception si cette identifiant nexiste pas dans le catalogue.
        
        Work work=null;
        for (Work nextWork: Catalogue.listOfWork){
            if (nextWork.getId()== Long.parseLong(id)){
                work=nextWork;
                break;
            }
        } 
        // Stockage de l'oeuvre dont  l'utilisateur a fourni l'identifiant 
        request.setAttribute("work",work);
        
        // Affecter l'affichage à une JSP
        RequestDispatcher disp=request.getRequestDispatcher("/WEB-INF/work-details.jsp");
        disp.forward(request, response);
      
    }

   
   
      
 

}
