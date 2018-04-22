<%-- 
    Document   : addBooks
    Created on : Apr 22, 2018, 2:04:17 PM
    Author     : Sebastian Byczkowski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Books</title>
    </head>
    <body>
        <h1>Book Information</h1>
        <p>Please enter required information:</p>
        <form action="AddBookServlet" method="POST">
            <p>Book Name: <input type="text" name="bookName" value="" size="50" /><br />
                <br>
                ISBN: <input type="text" name="isbn" value="" size="13" /><br />
                <br>
                Author: <input type="text" name="author" value="" size="20" /><br />
                <br>
                Condition: <input type="text" name="bookCondition" value="" size="4" /><br />
                <br>
                Description: <input type="text" name="description" value="" size="4" /><br />
                <br>
                <br>
                Price: <input type="text" name="price" value="" size="5" /><br />
                <br>
                Quantity: <input type="text" name="quantity" value="" size="2" /><br />
                <br>
                <input type="submit" value="Add Book" name="submit" />
           
            </p>
        </form>
    </body>
</html>
