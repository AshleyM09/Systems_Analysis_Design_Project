<%-- 
    Document   : listBook
    Created on : Apr 22, 2018, 3:29:12 PM
    Author     : Sebastian Byczkowski
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Current Books</title>
    </head>
    <body>
        <h1>Added Books</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Book Name</th>
                    <th>ISBN</th>
                    <th>Author</th>
                    <th>Book Condition</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${bkList}" var="bk">
                <tr>
                    <td><c:out value="${bk.bookName}"/></td>
                    <td><c:out value="${bk.isbn}"/></td>
                    <td><c:out value="${bk.author}"/></td>
                    <td><c:out value="${bk.bookCondition}" /></td>
                    <td><c:out value="${bk.description}"/></td>
                    <td><c:out value="${bk.price}"/></td>
                    <td><c:out value="${bk.quantity}" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>