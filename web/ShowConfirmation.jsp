<%-- 
    Document   : ShowComfirmation
    Created on : Oct 26, 2023, 11:40:34 PM
    Author     : iceza
--%>

<%@page import="controller.CentralController"%>
<%@page import="model.ProductsWithQuantity"%>
<%@page import="java.util.List"%>
<%@page import="model.Cashier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Confirmation Page</title>
    </head>
    <%
      CentralController controller = CentralController.getController(session.getId());
    %>    
    <body>
        <%
            out.println("<h1>Your Order is confirmed! <br> The total amount is $" + request.getAttribute("sumPrice") + ".00</h1>");
        %>
    </body>
</html>
