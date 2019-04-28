/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DatabaseConnector;

/**
 *
 * @author Xavier Hawkins
 */
public class AddManifest {
    private String bookName;
    private String orderId;
    private int orderQty;
    private double wholesalePrice;
  
    
    private Connection connection;
    
    public AddManifest(){
        connection = DatabaseConnector.getConnection();
    }
    public AddManifest(String bookName, String orderId, int orderQty, double wholesalePrice){
        
        this.bookName = bookName;
        this.orderId = orderId;
        this.orderQty = orderQty;
        this.wholesalePrice = wholesalePrice;
    }

       
    public void addInventory(String bookName, String orderId, int orderQty, double wholesalePrice ){
        try{
            connection = DatabaseConnector.getConnection();
            
            //write query
            String sql = "INSERT into VANDORMANIFEST values('" + bookName + "','" + orderId + "'," + orderQty + "," + wholesalePrice + ")";
            
            //create statement object to send to database
            Statement stmt = connection.createStatement();
            
            //execute query (update)
            stmt.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
    }

    public String getBookName() {
        return bookName;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }
    
    public ArrayList<AddManifest> listManifest(){
        //array list to store current vendor information
        ArrayList<AddManifest> manifest = new ArrayList<>();
        //connect to database
        connection = DatabaseConnector.getConnection();
        try{
            //execute a basic query to get the books
            String sql = "select * from VANDORMANIFEST";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            //for each record, create a new object and put it in the arraylist
            while(rs.next()){
                 String bookName;
                 String orderId;
                 int orderQty;
                 double wholesalePrice;
                
                bookName = rs.getString("BOOKNAME");
                orderId = rs.getString("ORDERID");
                orderQty = rs.getInt("ORDERQTY");
                wholesalePrice = rs.getDouble("WHOLESALEPRICE");
                
                
                AddManifest manifst = new AddManifest(bookName,orderId,orderQty,wholesalePrice);
                manifest.add(manifst);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
        
        return manifest;
    }
    
    public String toString(){
        return "Book name: " + bookName + " OrderID: " + orderId+ " QTY: " + orderQty + " Price: " + wholesalePrice;
    }
    
/**    
    public static void main(String[] args){
        AddManifest a = new AddManifest();
        ArrayList<AddManifest> test = a.listManifest();
        for (AddManifest t : test){
            System.out.println(t);
        }
    }*/
    
}
