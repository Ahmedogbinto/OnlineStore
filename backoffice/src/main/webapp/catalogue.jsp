<%-- 
    Document   : catalogue
    Created on : 8 juin 2022, 18:51:27
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue des oeuvres</title>
    </head>
    <body>
        <h1>Oeuvres au catalogue</h1></BR>
        <!--Je fais une itération en utilisant la JSTL Java Standard Tag Library => Taglib -->
        <c:forEach items="${listedesoeuvres}" var="work">
            ${work.title} ${work.release}</BR>
        </c:forEach>
    </body>
    
</html>
