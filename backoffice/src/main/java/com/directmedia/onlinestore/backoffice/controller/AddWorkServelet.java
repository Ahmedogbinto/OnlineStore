/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
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
@WebServlet(name = "AddWorkServelet", urlPatterns = {"/add-work"})
public class AddWorkServelet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Work nouvelleOeuvre = new Work(request.getParameter("title"));
        nouvelleOeuvre.setGenre(request.getParameter("genre"));
        nouvelleOeuvre.setRelease(Integer.parseInt(request.getParameter("release")));
        nouvelleOeuvre.setSummary(request.getParameter("summary"));
        nouvelleOeuvre.setMainArtist(new Artist(request.getParameter("artist")));
        
        Catalogue.listOfWork.add(nouvelleOeuvre);
     
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<HTML><BODY>Le film a été ajouter<BR/><a href=\"home\">Retourner à la page d'accueil</a><BODY><HTML>");
     
   

}
}
