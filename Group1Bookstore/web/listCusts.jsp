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
                <c:forEach items="${custList}" var="cus">
                <tr>
                    <td><c:out value="${cus.username}"/></td>
                    <td><c:out value="${cus.password}"/></td>
                    <td><c:out value="${cus.last}" /></td>
                    <td><c:out value="${cus.first}"/></td>
                    <td><c:out value="${cus.address}"/></td>
                    <td><c:out value="${cus.city}" /></td>
                    <td><c:out value="${cus.zipcode}"/></td>
                    <td><c:out value="${cus.state}"/></td>
                    <td><c:out value="${cus.phonenumber}"/></td>
                    <td><c:out value="${cus.email}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
