<%-- 
    Document   : ErrorSession
    Created on : Oct 27, 2023, 2:40:52 PM
    Author     : iceza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <%
            out.println("<h1> Your session has already ended! <br> Please select the product again. </h1>");
        %>
    </body>
</html>
