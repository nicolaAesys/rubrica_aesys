<%-- 
    Document   : welcome
    Created on : 6 apr 2022, 10:36:53
    Author     : Aesys
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.html");
            }
        %>
        
           Ecco tutte le persone
           <ol>
<c:forEach items="${persone}" var="persone">
      <br>
        <li>${persone} </li>
       </br> 
    </c:forEach>
       </ol>

        <h1>Welcome</h1>
        <form action="insert.jsp" method="get">
            <br>   <input type="submit" value="Aggiungicontatto"></br>
            <p>
                
                
                
        <a href="contatto.jsp">Vai al contatto</a></br>
                    <p>
                        
                        
                        
        <form action="Logout" method="get">
            <input type="submit" value="Logout"></br></br>

            </body>
            </html>
