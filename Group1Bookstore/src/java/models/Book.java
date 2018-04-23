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
 * @author Sebastian Byczkowski
 */
public class Book {
    private String bookName;
    private String isbn;
    private String author;
    private String bookCondition;
    private String description;
    private double price;
    private int quantity;
    
    private Connection connection;
    
    public Book(){
        connection = DatabaseConnector.getConnection();
    }
    public Book(String bookName, String isbn, String author, String bookCondition, String description, double price, int quantity){
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.bookCondition = bookCondition;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

       
    public void addBook(String bookName, String isbn, String author, String bookCondition, String description, double price, int quantity){
        try{
            connection = DatabaseConnector.getConnection();
            
            //write query
            String sql = "insert into STOREINVENTORY values('" + bookName + "','" + isbn + "','" + author + "','" + bookCondition + "','" + description +
                    "'," + price + "," + quantity + ")";
            
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

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
    
    public ArrayList<Book> listBook(){
        //array list to store current apartments
        ArrayList<Book> books = new ArrayList<>();
        //connect to database
        connection = DatabaseConnector.getConnection();
        try{
            //execute a basic query to get the books
            String sql = "select * from STOREINVENTORY";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            //for each record, create a new object and put it in the arraylist
            while(rs.next()){
                 String bookName;
                 String isbn;
                 String author;
                 String bookCondition;
                 String description;
                 double price;
                 int quantity;
                
                bookName = rs.getString("BOOKNAME");
                isbn = rs.getString("ISBN");
                author = rs.getString("AUTHOR");
                bookCondition = rs.getString("BOOKCONDITION");
                description = rs.getString("DESCRIPTION");
                price = rs.getDouble("PRICE");
                quantity = rs.getInt("QUANTITY");
                
                Book bewk = new Book(bookName, isbn, author, bookCondition, description, price, quantity);
                books.add(bewk);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DatabaseConnector.closeConnection();
        }
        
        return books;
    }
    public static void main(String[] args){
        Book b = new Book();
        ArrayList<Book> books = b.listBook();
        
        for(Book bk : books){
            System.out.println(bk.getBookName());
        }
    }
    
}
