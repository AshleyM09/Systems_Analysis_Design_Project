<%-- 
    Document   : ListManifest
    Created on : Apr 25, 2018, 3:51:01 PM
    Author     : Xavier Hawkins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <tbody>
       <body>
    <h2>Inventory</h2>&nbsp&nbsp&nbsp
        <c:out value="${vendorList}" />
        <table border="1">
            <thead>
                <tr>
            <th>&nbsp&nbsp&nbspBook Name&nbsp&nbsp&nbsp</th>
            <th>&nbsp&nbsp&nbspOrder ID&nbsp&nbsp&nbsp&nbsp</th>
            <th>&nbsp&nbsp&nbsp&nbspOrderQty&nbsp&nbsp&nbsp&nbsp&nbsp</th>
                    <th>&nbsp&nbsp&nbsp&nbspWholesale Price&nbsp&nbsp&nbsp&nbsp&nbsp</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${vendorList}" var="bk">
                <tr>
                    <td><c:out value="${bk.bookName}"/></td>
                    <td><c:out value="${bk.orderID}"/></td>
                    <td><c:out value="${bk.orderQty}"/></td>
                    <td><c:out value="${bk.wholesalePrice}" /></td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
      </div>
        
    </body>
</html>
