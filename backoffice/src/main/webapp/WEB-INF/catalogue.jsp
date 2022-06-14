<%-- 
    Document   : catalogue
    Created on : 8 juin 2022, 18:51:27
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!--Je fais une itération en utilisant la JSTL Java Standard Tag Library => Taglib -->
        <c:forEach items="${listedesoeuvres}" var="work">
            ${work.title} ${work.release}</BR>
        </c:forEach>
  
