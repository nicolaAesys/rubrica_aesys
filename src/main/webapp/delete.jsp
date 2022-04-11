<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="inserisci" method="post">
           Insert the datas of new user <br/>
           <ul>
            <c:forEach items="${persone}" var="persona">
                <li>
                    Nome: ${persona.nome} 
                    Cognome: ${persona.cognome} 
                    Telefono: ${persona.telefono} 
                </li>
            </c:forEach>
        </ul>
        <br/>
            Insert contact to delete: <input type="text" name="nome"> <br/>
            <input type="submit" value="Delete">
    </body>
</html>
