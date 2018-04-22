<%-- 
    Document   : listCusts
    Created on : Apr 22, 2018, 4:41:57 PM
    Author     : Cody Youngs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Current Customers</title>
    </head>
    <body>
        <h1>Customer's Currently Registered</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Zipcode</th>
                    <th>State</th>
                    <th>Phone Number</th>
                    <th>Email Address</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${custList}" var="cust">
                <tr>
                    <td><c:out value="${cust.username}"/></td>
                    <td><c:out value="${cust.password}"/></td>
                    <td><c:out value="${cust.last}" /></td>
                    <td><c:out value="${cust.first}"/></td>
                    <td><c:out value="${cust.address}"/></td>
                    <td><c:out value="${cust.city}" /></td>
                    <td><c:out value="${cust.zipcode}"/></td>
                    <td><c:out value="${cust.state}"/></td>
                    <td><c:out value="${cust.phonenumber}"/></td>
                    <td><c:out value="${cust.email}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
