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
        this.totalPrice = 30.00;
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
    
    
    
    public void createOrder(int orderNumber, String customerUserName, double totalPrice, String shippingAddress, int quantityBought, int quantitySold){
        //totalPrice = 25.00;calculateTotalPrice(quantityBought, quantitySold);
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
    
   /** public static void main(String[] args){
        Order order = new Order();
        order.createOrder(3, "am1234", 0, "123 Mains St", 0, 0);
    }*/
    
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
        public String displayFinalOrder(){
        try{
            connection = DatabaseConnector.getConnection();

            //TODO display the Final Order.
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
        
    }
    
    public double calculateTotalPrice(int quantityBought, int quantitySold){
        try{
            connection = DatabaseConnector.getConnection();
            ///SELECT QUERY TO PULL BOOK PRICE FROM STOREINVENTORY
            //TODO Calculate total price using book price from the store inventory table
            //Remember: cancel calculation if int value passed = 0
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
    }
    
    
    
    /**if there is time left:
     * 
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
