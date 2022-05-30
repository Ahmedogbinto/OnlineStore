/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
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
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id=request.getParameter("id");
        
        // rechercher dans le catalogue quel film possede cet id
        // Si on utilise Java8, on utilisisera la Syntaxe de l'API stream
        // Work work=Catalogue.listOfWork.stream().filter(w -> w.getId()==Long.parseLong(id)).findFirst().get();
        // Cette ligne me permet rechercher l'oeuvre dont l'identité  a ete recu en parametre.
        // Cette syntaxe pourrait gener de multiple exception si cette identifiant nexiste pas dans le catalogue.
        
        Work work=null;
        for (Work nextWork: Catalogue.listOfWork){
            if (nextWork.getId()== Long.parseLong(id)){
                work=nextWork;
                break;
            }
        } 
        PrintWriter out=response.getWriter();
        
         out.print("<HTML><BODY><h1>Descriptif de l'oeuvre</h1>");
         
         out.print("Titre:"+work.getTitle()+" <BR/>"); 
         out.print("Année de parution: "+work.getRelease()+"<BR/>");
         out.print("Genre: "+work.getGenre()+" <BR/>");
         out.print("Artiste: "+work.getMainArtist()+"<BR/>");
         out.print("Résumé: "+work.getSummary()+"<BR/>");
         out.print("<BODY><HTML>");
     
    }

   
   
      
 

}
