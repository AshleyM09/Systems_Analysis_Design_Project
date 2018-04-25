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
        private String Bookname;
    private String OrderId;
    private int OrderQty;
    private double WholesalePrice;
  
    
    private Connection connection;
    
    public AddManifest(){
        connection = DatabaseConnector.getConnection();
    }
    public AddManifest(String Bookname, String OrderId, int OrderQty, double WholesalePrice){
        
        this.Bookname = Bookname;
        this.OrderId = OrderId;
        this.OrderQty = OrderQty;
        this.WholesalePrice = WholesalePrice;
    }

       
    public void addInventory(String Bookname, String OrderId, int OrderQty, double WholesalePrice ){
        try{
            connection = DatabaseConnector.getConnection();
            
            //write query
            String sql = "insert into VENDORMANIFEST values('" + Bookname + "','" + OrderId + "'," + OrderQty + "," + WholesalePrice + ")";
            
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

   
    public String getBookname() {
        return Bookname;
    }

    public String OrderId() {
        return OrderId;
    }

    public int OrderQty() {
        return OrderQty;
    }

    public double getWholesalePrice() {
        return WholesalePrice;
    }
    
    
    
    public ArrayList<AddManifest> listManifest(){
        //array list to store current vendor information
        ArrayList<AddManifest> manifest = new ArrayList<>();
        //connect to database
        connection = DatabaseConnector.getConnection();
        try{
            //execute a basic query to get the books
            String sql = "select * from STOREINVENTORY";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            //for each record, create a new object and put it in the arraylist
            while(rs.next()){
                 String bookname;
                 String orderId;
                 int orderQty;
                 double wholesalePrice;
                
                bookname = rs.getString("BOOKNAME");
                orderId = rs.getString("ORDERID");
                orderQty = rs.getInt("ORDERQTY");
                wholesalePrice = rs.getDouble("WHOLESALEPRICE");
                
                
                AddManifest manifst = new AddManifest(Bookname,OrderId,OrderQty,WholesalePrice);
                manifest.add(manifst);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
        
        return manifest;
    }
    
}
