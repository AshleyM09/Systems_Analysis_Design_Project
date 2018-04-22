/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import util.DatabaseConnector;

/**
 *
 * @author Ashley Mains
 */
public class Order {
    private String orderNumber;
    private String customerUserName;
    private double totalPrice;
    private String shippingAddress;
    private int quantityBought;
    private int quantitySold;
    
    
    
    
    private Connection connection;
    
    public Order(){
        connection = DatabaseConnector.getConnection();
    }

    public Order(String orderNumber, String customerUserName, String shippingAddress, int quantityBought, int quantitySold) {
        this.orderNumber = orderNumber;
        this.customerUserName = customerUserName;
        this.totalPrice = 0.00;
        this.shippingAddress = shippingAddress;
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
    }
    
    
    
    public void createOrder(String orderNumber, String customerUserName, String shippingAddress, int quantityBought, int quantitySold){
        totalPrice = 0.00; //calculateTotalPrice(quantityBought, quantitySold);
        try{
            connection = DatabaseConnector.getConnection();

            //TODO: write query to add information to database
            String sql = "insert into CHECKOUTORDER values('" + orderNumber + "','" + customerUserName + 
                    "'," + totalPrice + ",'" +  shippingAddress + "'," + quantityBought + "," + quantitySold + ")";
            //Created the statement object
            Statement stmt = connection.createStatement();
            
            //execute query (update)
            stmt.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }    
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
    
    public void sellBook(){ //I don't think I need this method
        
        try{
            connection = DatabaseConnector.getConnection();
            //TODO: code to sell one or many books
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
    }
    
    public void buyBook(){//I don't think I need this method
        try{
            connection = DatabaseConnector.getConnection();
            //TODO: code to buy one or many books
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
    }
    */
    
    
    /**if there is time left:
     * 
     * 
     * public String DisplayAllOrders(){
     *  try{
     *      connection = DatabaseConnector.getConnection();
            //TODO: List all orders, only for owner login
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
     * }
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
