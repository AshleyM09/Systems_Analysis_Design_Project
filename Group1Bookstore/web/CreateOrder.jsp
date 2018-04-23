<%-- 
    Document   : CreateOrder
    Created on : Apr 22, 2018, 9:36:00 PM
    Author     : Ashley Mains
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Form</title>
    </head>
    <body>
        <h1>Current Books in Stock</h1>
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
                <c:forEach items="${bokList}" var="bok">
                <tr>
                    <td><c:out value="${bok.bookName}"/></td>
                    <td><c:out value="${bok.isbn}"/></td>
                    <td><c:out value="${bok.author}"/></td>
                    <td><c:out value="${bok.bookCondition}" /></td>
                    <td><c:out value="${bok.description}"/></td>
                    <td><c:out value="${bok.price}"/></td>
                    <td><c:out value="${bok.quantity}" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
                <h1>Create an Order To Buy/Sell Book</h1>
                <p>Enter the fields below to add a book to your order.</p>
        <form action="CreateOrderServlet" method="POST">
            <p>
               <strong><u>Order Information</u></strong><br />
               <br />
               Enter an Order Number: <input type="text" name="orderNumber" value="" size="20" /><br />
               Enter Your Username: <input type="text" name="customerUserName" value="" size="20" /><br />
               Enter a Shipping Address:<input type="text" name="shippingAddress" value="" size="50" /><br />
               <sup>-<i>Include Recipient name</i></sup><br />
               <br />
               <strong><u>Book Information</u></strong><br />
               <br />
               Enter number of books you are buying: <input type="text" name="quantityBought" value="" size="3" /><br />
               <sup>-<i>If you are not buying a book, enter 0</i></sup><br />
               Enter number of books you are selling: <input type="text" name="quantitySold" value="" size="3" /><br />
               <sup>-<i>If you are not selling a book, enter 0</i></sup><br />
               Enter Book Name: <input type="text" name="bookName" value="" size="20" /><br />
               Enter ISBN Number: <input type="text" name="isbn" value="" size="15" /><br />
                <input type="submit" value="Create Order" name="submit" />
            </p>
        </form>
    </body>
</html>
