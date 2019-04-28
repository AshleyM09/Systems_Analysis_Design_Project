/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.util.ArrayList;
import util.DatabaseConnector;

/**
 *
 * @author Ashley Mains
 */
public class Order {
    private int orderNumber;
    private String customerUserName;
    private double totalPrice;
    private String shippingAddress;
    private int quantityBought;
    private int quantitySold;
    
    
    
    
    private Connection connection;
    
    public Order(){
        connection = DatabaseConnector.getConnection();
    }

    public Order(int orderNumber, String customerUserName, String shippingAddress, int quantityBought, int quantitySold) {
        this.orderNumber = orderNumber;
        this.customerUserName = customerUserName;
        this.shippingAddress = shippingAddress;
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public int getQuantitySold() {
        return quantitySold;
    }
    
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    
    
    /**
     * createOrder method takes the values from the CreateOrderServlet and adds them to 
     * the CHECKOUTORDER table in the database.
     */
    public void createOrder(int orderNumber, String customerUserName, double totalPrice, String shippingAddress, int quantityBought, int quantitySold){
        try{
            connection = DatabaseConnector.getConnection();

            //TODO: write query to add information to database
            String sql = "insert into CHECKOUTORDER values(" + orderNumber + ",'" + customerUserName + 
                    "'," + totalPrice + ",'" +  shippingAddress + "'," + quantityBought + "," + quantitySold + ")";
            //Created the statement object
            Statement stmt = connection.createStatement();
            System.out.println(sql);
            //execute query (update)
            stmt.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }    
    }
    /**
     * calculateTotalPrice method takes the ISBN number, searches for it in the 
     * STOREINVENTORY database, retrieves the price of the book, and multiplies it 
     * by the quantity passed. Incomplete: if a customer is selling a book, then the 
     * price would be retrieved from a table which has a reduced price to perform the proper
     * calculation.
     * NOTE: In a real world situation, the buy price offered to a customer is 
     * less than the sell price, so you would not pull the price from the 
     * STOREINVENTORY TABLE, but a table that has not been created in this project.
     * NOTE2/TODO: When a book is being bought or sold, the quantity in inventory table should 
     * increase or decrease as well.
     */
        public double calculateTotalPrice(String isbn, int quantityBought, int quantitySold){
        try{
            connection = DatabaseConnector.getConnection();
            //Calculates total price using book price from the store inventory table
            if (quantityBought > 0 && quantitySold == 0){
                String price = "select PRICE from STOREINVENTORY where ISBN = ?"; 

                PreparedStatement stmt = connection.prepareStatement(price);
                stmt.setString(1, isbn);
                ResultSet rs = stmt.executeQuery();
                double bkprice = 0.00;
                if(rs.next()){
                bkprice = rs.getDouble("PRICE");
                }
                bkprice *= quantityBought;
                setTotalPrice(bkprice); 
            }else{
                setTotalPrice(30.0);
            //NOTE: Normally would calculate the price of a book being sold by a customer.
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
        return totalPrice;
    }
    
    /**
     * listOrder method pulls the full list of orders from the CHECKOUTORDER 
     * table for the owner to review.
     */
    public ArrayList<Order> listOrder(){
      ArrayList<Order> orders = new ArrayList<>();
      connection = DatabaseConnector.getConnection();
      try{
        //TODO: List all orders, only for owner login
        String sql = "select * from CHECKOUTORDER";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
            
        //for each record, create a new object and put it in the arraylist
        while(rs.next()){
            int orderNumber;
            String customerUserName;
            double totalPrice;
            String shippingAddress;
            int quantityBought;
            int quantitySold;
                
        orderNumber = rs.getInt("ORDERNUMBER");
        customerUserName = rs.getString("CUSTOMERUSERNAME");
        totalPrice = rs.getDouble("TOTALPRICE");
        shippingAddress = rs.getString("SHIPPINGADDRESS");
        quantityBought = rs.getInt("QUANTITYBOUGHT");
        quantitySold = rs.getInt("QUANTITYSOLD");
        
                
        Order odr = new Order(orderNumber, customerUserName, shippingAddress, quantityBought, quantitySold);
        odr.setTotalPrice(totalPrice);
        orders.add(odr);                
            }
                        
      }catch(SQLException ex){
            System.out.println(ex.getMessage());
      }finally{
            DatabaseConnector.closeConnection();
      }
      
      return orders;
      
    }
    /**
     //File Testing code
     public static void main(String[] args){
        Order order = new Order();
        order.calculateTotalPrice("1450517161", 1, 0);
        System.out.println(order.getTotalPrice());
    }
    */
    /**
     * ADDITIONAL METHODS: 
     * orderConfirmation method would pull the information that the customer 
     * just entered and allow them to edit before officially placing the order.
     * 
        public String orderConfirmation(){
        try{
            connection = DatabaseConnector.getConnection();

            //TODO display the Final Order after purchase.
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
    }  
     * 
     *cancelOrder method would allow a customer to change their mind in placing 
     * an order.
     * 
     * public void cancelOrder(){
     *  try{
     *      connection = DatabaseConnector.getConnection();
     *      //TODO: cancel order form and go back to (homepage?)
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
     * }
     * 
     * createInvoice method would generate an invoice if the customer is considered credit worthy.
     * public void createInvoice(){
     *  try{
     *      connection = DatabaseConnector.getConnection();
            //TODO: generate an invoice with a payment due date (might need a table for invoices??
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
     * } 
     * 
     */
}
