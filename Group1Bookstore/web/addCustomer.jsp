<%-- 
    Document   : addCustomer
    Created on : Apr 22, 2018, 4:33:20 PM
    Author     : Cody Youngs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Customer</title>
    </head>
    <body>
        <h1>Add a New Customer</h1>
        <p>Enter the fields below to add a new apartment listing.</p>
        <form action="AddCustomerServlet" method="POST">
            <p>Create Username: <input type="text" name="username" value="" size="20" /><br />
               Create Password: <input type="text" name="password" value="" size="20" /><br />
               Enter Last Name: <input type="text" name="last" value="" size="20" /><br />
               Enter First Name: <input type="text" name="first" value="" size="20" /><br />
               Address: <input type="text" name="address" value="" size="20" /><br />
               City: <input type="text" name="city" value="" size="20" /><br />
               Zip Code: <input type="text" name="zipcode" value="" size="5" /><br />
               State: <input type="text" name="state" value="" size="20" /><br />
               Phone Number: <input type="text" name="phonenumber" value="" size="10" /><br />
               Email: <input type="text" name="email" value="" size="20" /><br />
                <input type="submit" value="Add Customer" name="submit" />
            </p>
        </form>
    </body>
</html>
