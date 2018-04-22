<%-- 
    Document   : OrderFormList
    Created on : Apr 22, 2018, 2:37:00 PM
    Author     : Ashley Mains
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"> 
        <title>History of Orders</title>
    </head>
    <body>
        <h1>Order History</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Order Number</th>
                    <th>Customer Username</th>
                    <th>Total Price</th>
                    <th>Shipping Address</th>
                    <th>Quantity Bought</th>
                    <th>Quantity Sold</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${odrList}" var="odr">
                <tr>
                    <td><c:out value="${odr.orderNumber}"/></td>
                    <td><c:out value="${odr.customerUserName}"/></td>
                    <td><c:out value="${odr.totalPrice}" /></td>
                    <td><c:out value="${odr.shippingAddress}" /></td>
                    <td><c:out value="${odr.quantityBought}" /></td>
                    <td><c:out value="${odr.quantitySold}" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
