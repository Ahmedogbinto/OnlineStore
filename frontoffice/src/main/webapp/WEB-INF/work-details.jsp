<%-- 
    Document   : work-details
    Created on : 9 juin 2022, 19:28:51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails de l'oeuvre</title>
    </head>
    <body>
        <h1>Descriptif de l'oeuvre</h1>
        <!--Nous utilisons dans les ligne ci-dessous des la tecjnologie JSP EL 
        pour pout récupérer les attributs de l'oeuvre -->
            Titre:               ${work.title}    <BR/> 
            Année de parution:   ${work.release}  <BR/>
            Genre:               ${work.genre}    <BR/>
            Artiste:             ${work.mainArtist.name} <BR/>
            Résumé:              ${work.summary}  <BR/>

            <!--Ajout d'un formulaire caché qui va permettre de recupérer l'identifiant de l'ouvre
            à ajouter au caddie pour l'envoyer vers le servlet-->

            <form action="addToCart" method="POST">
                <input type="hidden"  name="identifiant" value="${work.id}"/>
                <input type="submit" value="Ajouter au caddie"/>
            </form>
    </body>
</html>
