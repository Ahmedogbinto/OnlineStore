<%-- 
    Document   : home
    Created on : 8 juin 2022, 16:44:02
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onelinestore - Accueil du back-office</title>
    </head>
    <body>
        <h1>OnlineStore - Gestion de la boutique</h1>
        
        <!--Je peux essayer de donner une importance a notre formulaire d'authentification-->
        <%
            String login=(String)session.getAttribute("login");
            if(login!=null)
            {%>
            Bonjour ${login} <a href="logout">Déconnexion</a>)<BR/>
            <%}%>
            <a href="add-work-form.html">Ajouter une oeuvre au catalogue</a><BR/>
            <a href="catalogue">Acces au catalogue</a><BR/>
         
    </body
   
</html>
