<%-- 
    Document   : insert
    Created on : 6 apr 2022, 15:33:47
    Author     : Aesys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="inserisci" method="post">
           Insert the datas of new user <br/>
            Name    : <input type="text" name="nome"> <br/>
            Surname: <input type="text" name="cognome"> <br/>
            Telephone number: <input type="text" name="numero"> <br/>
            <input type="submit" value="Add">
    </body>
</html>
