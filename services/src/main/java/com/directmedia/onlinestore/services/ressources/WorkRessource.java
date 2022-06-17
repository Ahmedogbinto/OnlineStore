/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.services.ressources;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.util.Set;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
 @Path("/work")                                               //<-cette ressource repondra derriere l'url catalogue
public class WorkRessource {
      
                                         
      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public Set<Work> liste(){                              // une methode liste pour lister le conntenu du catalogue
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
            // Apres avoir copier coller la methode Get de CatalogueServlet, nous suppriner ObjectMapper et PrintWriter out=response.getWriter();
            // et nous nous contentons de returner juste la list des oeuvres.
            
             return  Catalogue.listOfWork;     
    }
      
    @POST
    public Response add(@FormParam("title") String title, @FormParam("genre") String genre, 
            @FormParam("release") int release, @FormParam("summary") String summary, @FormParam("artist") String artist )
    {
        boolean success=true;
        
        Work nouvelleOeuvre=new Work(title);
        nouvelleOeuvre.setGenre(genre);
        try{
            nouvelleOeuvre.setRelease(release);
        }
        catch(NumberFormatException nfe){
            success=false;
        }
        nouvelleOeuvre.setSummary(summary);
        nouvelleOeuvre.setMainArtist(new Artist(artist));
        
        return Response.status(Response.Status.CREATED).build();
    }     
}
