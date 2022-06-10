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
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (Catalogue.listOfWork.isEmpty()){
            Artist tomCruise=new Artist("Tom Cruise");
            Artist michaelJackson=new Artist("Michael Jackson");
            Artist louisDeFunes=new Artist("Louis De Funes");


            Work minorityReport=new Work("Minority report");
            Work bad=new Work("Bad");
            Work leGendarmeDeSaintTropez=new Work("Le gendarme de Saint-Tropez");

            minorityReport.setMainArtist(tomCruise);
            bad.setMainArtist(michaelJackson);
            leGendarmeDeSaintTropez.setMainArtist(louisDeFunes);

            minorityReport.setRelease(2002);
            bad.setRelease(1987);
            leGendarmeDeSaintTropez.setRelease(1964);

            minorityReport.setSummary("Minority report place le spectateur dans un futur proche cyber punk, une dystopie dont le cardre est a Washington de 2054 oû des êtres humains mutants, les precoqs peuvent prédire les crimes");
            bad.setSummary("Bad est le septième album de Michael Jackson et son troisième opus solo chez Epic/Sony et le dernier album co-produit par Quincy Jones. C,est l'un des albums les plus vendus de l'histoire de celui qu'on surnomme le roi de la pop");
            leGendarmeDeSaintTropez.setSummary("Le film raconte les aventures de Ludovic Cruchot, un gendarme très service-service muté dans la cité balnéaire de Saint-Tropez, sur la côte d'azure avec le grade de marechal");

            minorityReport.setGenre("Science fiction");
            bad.setGenre("Pop");
            leGendarmeDeSaintTropez.setGenre("Comedie");

            Catalogue.listOfWork.add(minorityReport);
            Catalogue.listOfWork.add(bad);
            Catalogue.listOfWork.add(leGendarmeDeSaintTropez);
        }  
        
        // Mise en scope "request" de la list des oeuvres du catalogue pour affichage par la jsp catalogue
            request.setAttribute("listedesoeuvres", Catalogue.listOfWork);
            RequestDispatcher disp=request.getRequestDispatcher("/WEB-INF/catalogue.jsp");
            disp.forward(request, response);
    }
}
