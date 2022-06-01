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
import static javax.swing.text.html.HTML.Tag.BR;
/**
 *
 * @author User
 */
@WebServlet(name = "AuthentificationServlet", urlPatterns = {"/login"})
public class AuthentificationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        
        PrintWriter out=response.getWriter();
        out.print("<HTML><BODY>");
        
        if(login.equals("michel") && password.equals("12345") || login.equals("caroline") && password.equals("abcdedf")){
           out.print("<a href=\"home\"> Accés validé à la page d'accueil </a>");
        }   
        else{
            out.print("Login ou mot de passe erronés <BR/>");
            out.print("<a href=\"login.html\">Nouvelle tentative</a>");
        }
            out.print("</HTML></BODY>");
        
    }

   
}
