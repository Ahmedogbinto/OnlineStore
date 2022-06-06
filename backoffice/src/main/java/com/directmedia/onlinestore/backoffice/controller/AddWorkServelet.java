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
import java.util.Optional;
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
@WebServlet(name = "AddWorkServelet", urlPatterns = {"/add-work"})
public class AddWorkServelet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean success=true;
        
        Work nouvelleOeuvre = new Work(request.getParameter("title"));
        nouvelleOeuvre.setGenre(request.getParameter("genre"));
        
        // premiere condition de verification si l'oeuvre pourra etre ajouter au catalogue.
        try{
            nouvelleOeuvre.setRelease(Integer.parseInt(request.getParameter("release")));       
        }
        catch(NumberFormatException nfe){
            success=false;
        }
        nouvelleOeuvre.setSummary(request.getParameter("summary"));
        nouvelleOeuvre.setMainArtist(new Artist(request.getParameter("artist")));
        
        /* Itération sur une collection sans utiliser l'API Strream de java 8
        // Deuxième condition de vérification, si l'oeuvre pourra être ajouter au catalogue
            for (Work work : Catalogue.listOfWork){
               if ( work.getTitle().equals(nouvelleOeuvre.getTitle()) && work.getRelease()==nouvelleOeuvre.getRelease() && 
                       work.getMainArtist().getName().equals(nouvelleOeuvre.getMainArtist().getName())){
                   
                   success=false;
               }
            }*/
        
        // It/ration sur la collection listOfWork en utilisant l'API Stream de Java 8   
        Optional<Work> optionalWork=Catalogue.listOfWork.stream().filter(work->work.getTitle().equals(nouvelleOeuvre.getTitle()) && 
                work.getRelease()==nouvelleOeuvre.getRelease() && work.getMainArtist().getName().equals(nouvelleOeuvre.getMainArtist().getName())).findAny();
             if(optionalWork.isPresent()){
                success=false;
                }
             
             if(success){
                Catalogue.listOfWork.add(nouvelleOeuvre);
                RequestDispatcher disp=request.getRequestDispatcher("/work-added-success");
                disp.forward(request, response);
             }
             else{
                 RequestDispatcher disp=request.getRequestDispatcher("/work-add-faillure");
                 disp.forward(request, response);
                }
            
       
}
}
