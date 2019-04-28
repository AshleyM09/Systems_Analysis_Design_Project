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
 * @Cody Youngs
 */
public class Customer{
    private String username;
    private String password;
    
    private String last;
    private String first;
    
    private String address;
    private String city;
    private String zipcode;
    private String state;
    
    private String phonenumber;
    private String email;
    
    private Connection connection;
    
    public Customer(){
        connection = DatabaseConnector.getConnection();
    }
    public Customer(String username, String password, String last, String first, String address, String city, String zipcode, String phonenumber, String email, String state){
        this.username = username;
        this.password = password;
        this.last = last;
        this.first = first;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.phonenumber = phonenumber;
        this.email = email;
        
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

   
    

    
    public void addCustomer(String username, String password, String last, String first, String address, String city, String zipcode, String phonenumber, String email, String state){
        try{
            connection = DatabaseConnector.getConnection();
            
            //write query
            String sql = "insert into CUSTOMER values('" + username + "','" + password + "','" + last + "','" + first + "','" + address + 
                    "','" + city +  "','" + zipcode + "','" + phonenumber + "','" + email + "','" + state + "')";
            
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
    
    public ArrayList<Customer> listCustomers(){
        //array list to store current apartments
        ArrayList<Customer> customers = new ArrayList<>();
        //connect to database
        connection = DatabaseConnector.getConnection();
        try{
            //execute a basic query to get the apartments
            String sql = "select * from CUSTOMER";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            //for each record, create a new object and put it in the arraylist
            while(rs.next()){
                String username;
                String password;
    
                String last;
                String first;
    
                String address;
                String city;
                String zipcode;
                String state;
    
                String phonenumber;
                String email;
                
                username = rs.getString("USERNAME");
                password = rs.getString("PASSWORD");
                last = rs.getString("LASTNAME");
                first = rs.getString("FIRSTNAME");
                address = rs.getString("STREETADDRESS");
                city = rs.getString("CITY");
                zipcode = rs.getString("ZIPCODE");                
                phonenumber = rs.getString("PHONENUMBER");
                email = rs.getString("EMAILADDRESS");
                state = rs.getString("STATE");
                
                Customer cust = new Customer(username, password, last, first, address, city, zipcode, phonenumber, email, state);
                customers.add(cust);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
        
        return customers;
    }
    
}
