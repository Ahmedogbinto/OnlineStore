<%-- 
    Document   : home
    Created on : 8 juin 2022, 16:44:02
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onelinestore - Accueil du back-office</title>
    </head>
    <body>
        <h1>OnlineStore - Gestion de la boutique</h1>
        
        <!--Je peux essayer de donner une importance a notre formulaire d'authentification
        je veux m'assurer que les informations telsque le login existe en session, donc je dois me connecter avant-->
        <c:if test="${not empty login}">
              Bonjour ${login} <a href="logout">Déconnexion</a>)<BR/>
              </c:if>
           
            <a href="add-work-form.html">Ajouter une oeuvre au catalogue</a><BR/>
            <a href="catalogue">Acces au catalogue</a><BR/>
         
    </body
   
</html>
