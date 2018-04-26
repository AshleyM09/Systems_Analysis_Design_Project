<%-- 
    Document   : OrderFormList
    Created on : Apr 22, 2018, 2:37:00 PM
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

    <title>Book Inventory</title>

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
           <a class="nav-link" href="ListCustomerServlet">Customer Accounts
                <span class="sr-only">(current)</span>
              </a>
                <li class="nav-item">
              <a class="nav-link" href="addBook.jsp">Add Book</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ListBookServlet1">View Books</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="OrderFormList">Orders</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ListManifest">Vendor Manifest</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="index.html">Logout</a>
            </li>
        </div>
      </div>
    </nav>

    <header>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url(pic4.jpg)">
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('pic1.jpg')">
          </div>
          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('pic3.jpg')">
          </div>
          <div class="carousel-item" style="background-image: url('pic2.jpg')">
          </div>
          <div class="carousel-item" style="background-image: url('pic5.jpg')">
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
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
    <h2>Customer Orders</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Order Number</th>
                    <th>&nbsp&nbsp&nbsp&nbspUsername&nbsp&nbsp&nbsp&nbsp</th>
                    <th>&nbsp&nbsp&nbsp&nbspTotal Price&nbsp&nbsp&nbsp&nbsp</th>
                    <th>&nbsp&nbsp&nbsp&nbspShipping Address&nbsp&nbsp&nbsp&nbsp</th>
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
