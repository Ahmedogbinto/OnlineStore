/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // idAsString est le parametre de l'oeuvre choisie envoyé depuis le formulaire invisible?
        
        String idAsString=request.getParameter("identifiant");
        long idAsLong=Long.parseLong(idAsString);
        
         ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
         
       //  Si c'est la premiere fois que l'utilisateur entre dans la Servlet ShoppingCar, la variable de session cart vaudrait null)  
       // Il va falloir instancier le shopping cart et mettre maintenant le Shopping cart dans session.
       if(cart==null){
         cart = new ShoppingCart();
         request.getSession().setAttribute("cart", cart);
       }
       // Retrouvons notre oeuvre dans la catalogue
       // Utilisons la version avant java 8 sans l'api stream; classic.
       
       /*for(Work work: Catalogue.listOfWork){
                if(work.getId()==idAsLong){
                    cart.getItems().add(work);
                } 
           }*/
    
     // Avec l'api stream maintenant à l'avenement de java8
     
     Optional<Work> optionalWork=Catalogue.listOfWork.stream().filter(work->work.getId()==idAsLong).findAny();
        if(optionalWork.isPresent()){
                cart.getItems().add(optionalWork.get());
            }
        
    PrintWriter out=response.getWriter();
    out.print("<HTML><BODY>Oeuvre ajoutée au caddie("+cart.getItems().size()+")<BR/><a href=\"catalogue\">Retour au catalogue</a></BODY></HTML>");
      
    }

}

