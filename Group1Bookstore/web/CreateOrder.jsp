<%-- 
    Document   : CreateOrder
    Created on : Apr 22, 2018, 9:36:00 PM
    Author     : Ashley Mains
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Buy/Sell Books</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/half-slider.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.html">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="addCustomer.jsp">Create Account
                <span class="sr-only">(current)</span>
              </a>
                <li class="nav-item">
              <a class="nav-link" href="CreateOrderServlet">Buy/Sell Book</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ListBookServlet">View Book</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="addManifest.jsp">Vendor</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.jsp">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <header>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url(pic1.jpg)">
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('pic2.jpg')">
          </div>
          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('pic3.jpg')">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </header>

    <!-- Page Content -->
    <section class="py-5">
      <div class="container">
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
      </div>
    </section>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Ashley - Cody - Sebastian - Xavier - 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
