<%-- 
    Document   : catalogue
    Created on : 8 juin 2022, 18:51:27
    Author     : User
--%>

<%@page import="com.directmedia.onlinestore.core.entity.Work"%>
<%@page import="com.directmedia.onlinestore.core.entity.Artist"%>
<%@page import="com.directmedia.onlinestore.core.entity.Catalogue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue des oeuvres</title>
    </head>
    <body>
        <h1>Oeuvres au catalogue</h1></BR>
        
        <%
        for (Work work: Catalogue.listOfWork ){ %>
            <!-- j'affiche du html donc jouvre et je ferme toujours d'abord les %-->
            <%=work.getTitle()%> <%=work.getRelease()%></BR>
        <%}%>
    </body>
    
</html>
