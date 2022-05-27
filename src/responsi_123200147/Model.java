/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200147;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author lenovo
 */
public class Model {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/movie_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connects;
    Statement statement;
    
    public Model() {
        try{
            Class.forName(JDBC_DRIVER);
            connects = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public String[][] readMovie(){
        try {
            int dataSums = 0;
            
            String datas[][] = new String[getDataMany()][5]; 
             
            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                datas[dataSums][0] = resultSet.getString("title"); 
                datas[dataSums][1] = String.valueOf(resultSet.getDouble("plot"));                
                datas[dataSums][2] = String.valueOf(resultSet.getDouble("character"));
                datas[dataSums][3] = String.valueOf(resultSet.getDouble("acting"));
                datas[dataSums][4] = String.valueOf(resultSet.getDouble("score"));
                dataSums++;
            }
                 return datas;   
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
        
        
    }
    
    public void insertMovie(String Title, double Plot, double Character, double Acting, double Score) {
        int dataSums = 0;
        
        try {
            String query = "SELECT * FROM movie WHERE title='"+ Title +"'";
            System.out.println(Title + " " + Plot + " " + Character + " " + Acting);
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                dataSums++;
            }
            if (dataSums==0) {
            query = "INSERT INTO movie(title,plot,character,acting,score) VALUES('"+Title+"','"+Plot+"','"+Character+"','"+Acting+"','"+Score+"')";
            
            statement = (Statement) connects.createStatement();
            statement.executeUpdate(query); 
            System.out.println("Input Success");
            JOptionPane.showMessageDialog(null, "Data inputed success");
             
            }else{
                    JOptionPane.showMessageDialog(null, "Cannot fill in");
                    }
            
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
            
        }
        
        
    }
    
    public void updateFilm(String Title, double Plot, double Character, double Acting, double Score){
       int dataSums = 0;
        try {
            String query = "SELECT * FROM movie WHERE title='" + Title+"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
            while (resultSet.next()) {
                dataSums++;
                
            }
           
            if (dataSums==1) {
                query = "UPDATE movie SET plot='" + Plot + "', character='" + Character + "', score='"+ Score+"' WHERE title='" + Title+"'"; 
                statement = (Statement) connects.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Succesfully updated");
                JOptionPane.showMessageDialog(null, "Data success updated");
            }else{
                JOptionPane.showMessageDialog(null, "Data empty");
            }
                
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }
    
    public int getDataMany(){
        int dataSums = 0;
        try {
            statement = connects.createStatement();
            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                dataSums++;
                
            }
            return dataSums;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL is Error");
            return 0;
            
        }
        
    }
    
    public void deleteMovie (String Title){
        try {
            String query = "DELETE FROM movie WHERE judul = '"+Title+"'";
            statement = connects.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Successfully deleted");
            
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    
    
}
    

