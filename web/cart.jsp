<%@page import="controller.CentralController"%>
<%@page import="model.Cashier"%>
<%@page import="model.ProductsWithQuantity"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductTable"%>
<%@page import="model.Products"%>
.<%-- 
    Document   : cart.
    Created on : Oct 26, 2023, 5:50:55 PM
    Author     : iceza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <jsp:useBean id="product" class="model.Products" scope="request"/>
    <%  
        CentralController controller = CentralController.getController(session.getId());
        List<ProductsWithQuantity> products = controller.getProducts();
    %>    
    <body>
        <center>
            <form action="CheckOutController" method="POST" >
                <h1>Shopping Cart</h1>
                <table border="1">
                    <tr>
                        <th>DVD Names</th>
                        <th>Role</th>
                        <th>Year</th>
                        <th>Price/Unit</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    <%
                        for(int i = 0; i < products.size(); i++) {
                            out.println("<tr>");
                            out.println("<td> "+ products.get(i).getMovie() + "</td>");
                            out.println("<td> "+ products.get(i).getRating() + "</td>");
                            out.println("<td> "+ products.get(i).getYearcreate() + "</td>");
                            out.println("<td> "+ products.get(i).getPrice() + "</td>");
                            out.println("<td> "+ products.get(i).getQuantity() + "</td>");
                            out.println("<td> "+ products.get(i).getProductTotalPrice() + "</td>");
                            out.println("<tr>");
                        }
                        out.println("<tr>");
                            out.println("<td colspan=\"5\" style=\"text-align: center\" >Total</td>");
                            out.println("<td> "+ controller.getSumPrice() + "</td>");
                        out.println("<tr>");
                    %>
                </table>
                <input type="submit" value="Check out" name="Check out" />
            </form>
        </center>
    </body>
</html>
